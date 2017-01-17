package com.st.algos.dp;

public class MaxSumSubsequence {

    private static int maxSumSubsequece(int[] arr) {
        int currentMax = 0;
        int maxAtI = 0;
        for (int i = 0; i < arr.length; i++) {
            //
            if (maxAtI + arr[i] > arr[i]) {
                //  continue seq
                maxAtI = maxAtI + arr[i];
            } else {
                //start new sub seq
                maxAtI = arr[i];
            }
            if (maxAtI > currentMax) {
                currentMax = maxAtI;
            }
            System.out.println("max so far : " + maxAtI);
        }
        return currentMax;
    }

    public static void main(String args[]) {
        int[] arrs = {1, 2, 3, -7, 5};
        System.out.println("max of all " + maxSumSubsequece(arrs));
    }
}
