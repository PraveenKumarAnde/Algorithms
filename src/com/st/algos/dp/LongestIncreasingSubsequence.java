package com.st.algos.dp;

/**
 * Created by Praveen on 1/16/17.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] maxSubseq = {6, 5,4,3,7,1, 9};
        SubResults subResults = maxIncreasingSubSeq(maxSubseq);
        System.out.println(subResults.count);
    }

    private static SubResults maxIncreasingSubSeq(int[] arr) {
        SubResults[] maxAtI = new SubResults[arr.length];
        for (int i = 0; i < arr.length; i++) {
            maxAtI[i] = getMaxLessThankNumber(maxAtI, arr[i], i);
        }
        SubResults max = null;
        for (int i = 0; i < maxAtI.length; i++) {
            if (max == null) {
                max = maxAtI[i];
            } else {
                if (max.value <= maxAtI[i].value) {
                    max = maxAtI[i];
                }
            }
        }
        return max;
    }

    private static SubResults getMaxLessThankNumber(SubResults[] subResults, int number, int index) {
        SubResults maxSoFar = null;
        if (index == 0) {
            return new SubResults(0, number, 1, 0);
        }
        for (int i = 0; i < index; i++) {
            if (subResults[i].value < number) {
                if (maxSoFar == null) {
                    maxSoFar = subResults[i];
                } else {
                    if (maxSoFar.count <= subResults[i].count) {
                        maxSoFar = subResults[i];
                    }
                }
            }
        }
        if (maxSoFar != null) {
            return new SubResults(maxSoFar.startIndex, number, maxSoFar.count + 1, index);
        } else {
            return new SubResults(index, number, 1, index);
        }
    }

    static class SubResults {
        int startIndex;
        int value;
        int count;
        int endIndex;

        public SubResults(int startIndex, int value, int count, int endIndex) {
            this.startIndex = startIndex;
            this.value = value;
            this.count = count;
            this.endIndex = endIndex;
        }
    }
}
