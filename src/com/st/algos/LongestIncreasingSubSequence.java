package com.st.algos;

import java.util.*;

/**
 * Created by Praveen on 12/3/16.
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5};
        System.out.println(longestWidth(arrs));
        System.out.println(longestWidthBest(arrs));

    }


    /**
     * Soltuion would be to have two different set's. 1. With increasing index set and another one increasing value's set
     * So for an element, we would find the next max element of the current element. If the index of this nextMax element is
     * highest among all the other smaller elements, solution is that + 1. Else, solution is the max of that +1 or
     * the last indexes element  +1
     * @param array
     * @return
     */
    public static int longestWidthBest(int[] array) {
        int[] maxEndingArray =  new int[array.length];
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        TreeMap<Integer, Integer> tr = new TreeMap<>();
        for (int i =0; i< array.length ; i++) {


            //best possible solution for elements less than array[i]

            // with next best value
            SortedMap<Integer, Integer> integerIntegerSortedMap = tr.headMap(array[i]);
            if (integerIntegerSortedMap.size() > 0) {
                int tempVal = integerIntegerSortedMap.lastKey();
                Integer highestValueIndex = tr.get(tempVal);
                int highestValueIndexSolution = maxEndingArray[highestValueIndex];
                // with next best index
                int highestIndexIndex = Collections.max(integerIntegerSortedMap.values());
                int highestIndexIndexSolution = maxEndingArray[highestIndexIndex];

                int bestSolution =  Math.max(highestValueIndexSolution, highestIndexIndexSolution);
                maxEndingArray[i] = bestSolution + 1;

            } else {
                maxEndingArray[i] = 1;
            }
            tr.put(array[i], i);

        }

        int finalSol = -1;
        for (int i =0 ; i < maxEndingArray.length ; i++) {
            if (maxEndingArray[i] > finalSol) {
                finalSol = maxEndingArray[i];
            }
        }
        return finalSol;
    }

    private static int maxValueLessThanNum(int num) {
        return -1;
    }

    private static int maxIndexLessThanNum(int num) {
        return -1;
    }

    private static int bestSolutinLessThanNum(int solutionWithBestIndex, int solutionWithBestNumber) {
        return Math.max(solutionWithBestIndex, solutionWithBestNumber);
    }

    public static int longestWidth(int[] array) {
        int[] maxEndingArray =  new int[array.length];
        TreeSet<Integer> tr = new TreeSet<>();
        Map<Integer, List<Integer>> valueToIndicesMap = new HashMap<>();
        for (int i =0; i< array.length ; i++) {


            //finding the minimum so far
            int maxSoFar = Integer.MIN_VALUE;
            NavigableSet<Integer> integers = tr.headSet(array[i], false);
            boolean exisitsMins = false;
            for (Integer integer : integers) {
                exisitsMins = true;
                List<Integer> indices = valueToIndicesMap.get(integer);
                for (Integer in : indices) {
                    if (maxEndingArray[in] > maxSoFar) {
                        maxSoFar = maxEndingArray[in];
                    }
                }
            }
            if (exisitsMins) {
                maxEndingArray[i] = maxSoFar + 1;
            } else {
                maxEndingArray[i] = 1;
            }


            // storing it in indices for future
            tr.add(array[i]);
            List<Integer> indices = valueToIndicesMap.get(array[i]);
            if (indices == null) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(i);
                valueToIndicesMap.put(array[i], objects);
            } else {
                indices.add(i);
            }
            // find all elements less than arrray[i]
           // fid min of such elements
        }

        int finalSol = -1;
        for (int i =0 ; i < maxEndingArray.length ; i++) {
            if (maxEndingArray[i] > finalSol) {
                finalSol = maxEndingArray[i];
            }
        }
        return finalSol;
    }
}

