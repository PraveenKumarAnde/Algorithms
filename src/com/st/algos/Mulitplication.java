package com.st.algos;

/**
 * Created by Praveen on 11/25/16.
 */
public class Mulitplication {

    public static void main(String args[]) {
        Double d = new Double("2");
        //3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2
        //2,7,1,8,2,8,1,8,2,8,4,5,9,0,4,5,2,3,5,3,6,0,2,8,7,4,7,1,3,5,2,6,6,2,4,9,7,7,5,7,2,4,7,0,9,3,6,9,9,9,5,9,5,7,4,9,6,6,9,6,7,6,2,7
        int[] number1 = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2};
        int[] number2 = {2,7,1,8,2,8,1,8,2,8,4,5,9,0,4,5,2,3,5,3,6,0,2,8,7,4,7,1,3,5,2,6,6,2,4,9,7,7,5,7,2,4,7,0,9,3,6,9,9,9,5,9,5,7,4,9,6,6,9,6,7,6,2,7};
        int sSize = (2 * (number1.length)) +1;
        int[] sum = new int[sSize];
        int sIndex = sSize - 1;
        for (int i = number1.length - 1; i >= 0; i--) {
            int results[] = new int[number2.length + 1];
            int carryFwd = 0;
            for (int j = number2.length - 1; j >= 0; j--) {
                int res = (number1[i] * number2[j]) + carryFwd;
                int resultIndex = j + 1;
                if (res < 10) {
                    carryFwd = 0;
                    results[resultIndex] = res;
                } else {
                    carryFwd = res / 10;
                    results[resultIndex] = res % 10;
                }
            }
            results[0] = carryFwd;
            int sCarryFwd = 0;
            int cSIndex = sIndex;
            for (int t = results.length - 1; t >= 0; t--) {
                int res = sum[cSIndex] + results[t] + sCarryFwd;
                if (res < 10) {
                    sCarryFwd = 0;
                    sum[cSIndex] = res;
                } else {
                    sCarryFwd = res / 10;
                    sum[cSIndex] = res % 10;
                }
                cSIndex--;
            }
            sIndex--;
        }
        for (int i =0 ; i< sum.length;i++) {
            System.out.print(sum[i]);
        }
    }
}
