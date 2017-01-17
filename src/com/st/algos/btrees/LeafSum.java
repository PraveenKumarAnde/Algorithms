package com.st.algos.btrees;


public class LeafSum {

    public static void sumLeaves(BinaryTree tree, String substr, Integer sum) {
        String append = substr + tree.data;
        if (tree.left == null && tree.right == null) {
            sum = sum + Integer.parseInt(append);
        } else {
            sumLeaves(tree.left, append, sum);
            sumLeaves(tree.right, append, sum);
        }
    }
}
