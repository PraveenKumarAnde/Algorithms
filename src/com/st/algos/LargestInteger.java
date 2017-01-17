package com.st.algos;

/**
 * Created by Praveen on 1/6/17.
 */
public class LargestInteger {

    public static int largestInteger(int num) {
        int start = 0;
        int end = num;
        while (end - start > 1) {
            int mid = start + ((end - start) / 2);
            System.out.println("start : " + start + ", mid = " + mid + ", end = " + end);
            int square = mid * mid;
            if (square > num) {
                end = mid - 1;
            } else {
                start = mid;
            }

        }
        return end;
    }

    public static void main(String args[]) {
        System.out.println(largestInteger(25));
    }
}