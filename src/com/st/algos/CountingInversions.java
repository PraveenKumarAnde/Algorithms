package com.st.algos;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Praveen on 12/1/16.
 */
public class CountingInversions implements Comparable<CountingInversions> {
    int val;
    String name;

    public int compareTo(CountingInversions p1) {
        if (p1 == null || this. val > p1.val)
        {
            return 1;
        }
        return -1;
    }


    public static boolean isMerge(String s, String part1, String part2) {
        char[] chars = s.toCharArray();
        char[] part1s = part1.toCharArray();
        char[] part2s = part2.toCharArray();
        int k = 0;
        int l =0;
        boolean rval = true;
        for (int i =0 ;i < chars.length ; i++) {
            if (k < part1s.length && chars[i] == part1s[k]) {
                k++;
            }
            else if (l < part2s.length && chars[i] == part2s[l]) {
                l++;
            } else {
                rval = false;
                break;
            }
        }
        return rval;
    }

    public static void main(String[] args) {
        System.out.print(isMerge("banana", "bana", "an"));
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
