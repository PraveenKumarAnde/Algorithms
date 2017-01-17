package com.st.algos.btrees;

/**
 * Created by Praveen on 1/7/17.
 */
public class BinaryTree {


    public String data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTree() {

    }
}