package com.st.algos.btrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Praveen on 1/9/17.
 */
public class Leaves {

    public static void getLeaves(BinaryTree btree) {
        List<String> list = new ArrayList<>();
        leavesOFBinaryTree(btree, list);
    }

    public static void leavesOFBinaryTree(BinaryTree tree, List<String> list) {
        if (tree != null) {
            if (tree.left == null && tree.right == null) {
                list.add(tree.data);
            } else {
                leavesOFBinaryTree(tree.left, list);
                leavesOFBinaryTree(tree.right, list);
            }
        }
    }

    public static void inOrderPractise(BinaryTree tree) {
        List<String> list = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            if (tree != null) {
                stack.add(tree);
                tree = tree.left;
            } else {
                BinaryTree pop = stack.pop();
                list.add(tree.data);
                tree = pop.right;
            }
        }
    }

    public static void preOrder(BinaryTree binaryTree) {
        List<String> list = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();
        while (binaryTree != null || !stack.isEmpty()) {
            if (binaryTree != null) {
                list.add(binaryTree.data);
                stack.add(binaryTree.left);
                binaryTree = binaryTree.left;
            } else {
                BinaryTree pop = stack.pop();
                binaryTree = pop.right;
            }
        }
    }

    public static void postOrder(BinaryTree binaryTree) {
        List<String> list = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();
        while (binaryTree != null || !stack.isEmpty()) {
            if (binaryTree != null) {
                stack.add(binaryTree.left);
                binaryTree = binaryTree.left;
            } else {
                BinaryTree pop = stack.pop();
                list.add(pop.data);
                binaryTree = pop.right;
            }
        }
    }

}
