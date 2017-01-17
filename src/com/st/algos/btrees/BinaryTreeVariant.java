package com.st.algos.btrees;


public class BinaryTreeVariant {

    public String data;
    public BinaryTreeVariant left;
    public BinaryTreeVariant right;
    public int childCount;

    public BinaryTreeVariant(String data, BinaryTreeVariant left, BinaryTreeVariant right, int childCount) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.childCount = childCount;
    }
}