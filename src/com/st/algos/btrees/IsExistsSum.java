package com.st.algos.btrees;

import java.util.ArrayList;
import java.util.List;

public class IsExistsSum {

    public static boolean isExists(BinaryTree tree, int sumSoFar, int givenSum) {
        if (tree == null) {
            return false;
        }
        sumSoFar = Integer.parseInt(tree.data) + sumSoFar;
        if (sumSoFar == givenSum) {
            return true;
        } else if (sumSoFar > givenSum) {
            return false;
        } else {
            return isExists(tree.left, sumSoFar, givenSum) || isExists(tree.right, sumSoFar, givenSum);
        }
    }

    public static Elements isExistsWithPath(BinaryTree tree, int sumSoFar, int givenSum, List<String> vals) {
        Elements elements = new Elements();
        if (tree == null) {
            return elements;
        }
        vals.add(tree.data);
        sumSoFar = Integer.parseInt(tree.data) + sumSoFar;
        if (sumSoFar == givenSum) {
            elements.vals.add(vals);
            return elements;
        } else if (sumSoFar > givenSum) {
            return elements;
        } else {
            Elements existsWithPath1 = isExistsWithPath(tree.left, sumSoFar, givenSum, vals);
            elements.vals.addAll(existsWithPath1.vals);
            Elements existsWithPath2 = isExistsWithPath(tree.right, sumSoFar, givenSum, vals);
            elements.vals.addAll(existsWithPath2.vals);
        }
        return elements;
    }

    static class Elements {
        List<List<String>> vals;
    }
}
