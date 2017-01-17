package com.st.algos;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Praveen on 12/3/16.
 */
public class CoinChange {

    public static void main(String args[]) {
        int[] coins = {1,2, 5,10,25};
        System.out.print(leastSum(27,coins));
    }

    public static int leastSum(int num, int[] coins) {
        ArrayList<Integer> leastAtIndex=  new ArrayList<>();
        for (int i = 0; i< num ; i++ ){
            Integer currentLeast = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length; j++) {
                if (i - coins[j] >=0) {
                    if (currentLeast > leastAtIndex.get(i - coins[j])) {
                        currentLeast = leastAtIndex.get(i - coins[j]) +1;
                    }
                } else if (i == coins[j]-1 ){
                    currentLeast = 1;
                } else {
                    break;
                }

            }
            leastAtIndex.add(i, currentLeast);
        }
        return leastAtIndex.get(leastAtIndex.size()-1);
    }
}
