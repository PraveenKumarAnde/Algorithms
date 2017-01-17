package com.st.algos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Praveen on 12/1/16.
 */
public class MergeSort {
    public static long inversionsCount = 0;
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/Users/Praveen/Downloads/_bcb5c6658381416d19b01bfc1d3993b5_IntegerArray.txt"));
        List<Integer> collect = lines.map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        int[] input = new int[collect.size()];
        for (int i=0; i< collect.size(); i++) {
            input[i] = collect.get(i);
        }

        ReturnVal sort = sort(input, 0, input.length);
        for ( int t: sort.arr) {
            System.out.println(t);

        }
        System.out.println(inversionsCount);
    }

    public static ReturnVal sort(int[] array, int startInclusive, int endExclusive) {
        if (endExclusive - startInclusive  == 1) {
            int num = array[startInclusive];
            int[] arr = {num};
            ReturnVal returnVal = new ReturnVal();
            returnVal.arr = arr;
            return returnVal;
        }
        int mid = startInclusive + (endExclusive - startInclusive) /2 + (endExclusive - startInclusive) % 2;
        ReturnVal leftReturnVal = sort(array, startInclusive, mid);
        ReturnVal rightReturnVal  = sort( array, mid, endExclusive);
        return merge(leftReturnVal, rightReturnVal);
    }

    private static ReturnVal merge(ReturnVal leftVal, ReturnVal rightVal) {
        int[] left = leftVal.arr;
        int right[] = rightVal.arr;
        int[] result = new int[left.length + right.length];
        int currentLeft = 0;
        int currentRight = 0;
        int counter = 0;
        int invCountForThisMerge = 0;
        while (currentLeft != left.length && currentRight != right.length) {
            if (left[currentLeft] <= right[currentRight]) {
                result[counter] = left[currentLeft];
                currentLeft++;
            } else {
                inversionsCount = inversionsCount + (left.length - currentLeft);
                result[counter] = right[currentRight];
                currentRight++;
            }
            counter++;
        }
        while (currentLeft != left.length) {
            result[counter] = left[currentLeft];
            currentLeft++;
            counter++;
        }
        while (currentRight != right.length) {
            result[counter] = right[currentRight];
            currentRight++;
            counter++;
        }
        ReturnVal returnVal = new ReturnVal();
        returnVal.arr = result;
        return returnVal;
    }

    static class ReturnVal {
        int[] arr;
        long noInversions;
    }
}
