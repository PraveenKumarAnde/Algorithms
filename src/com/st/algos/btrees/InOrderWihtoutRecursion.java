package com.st.algos.btrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderWihtoutRecursion {

    public static void inOrderTraversal(BinaryTree binaryTree) {
        //
        Stack<BinaryTree> stack = new Stack<>();
        List<String> results = new ArrayList<>();
        BinaryTree current = binaryTree;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                BinaryTree pop = stack.pop();
                results.add(pop.data);
                current = pop.right;

            }
        }
        for (String ele : results) {
            System.out.println(ele);
        }
    }

    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", new BinaryTree("26", null, null), new BinaryTree("17", null, null)), new BinaryTree("45", null, null));
        inOrderTraversal(binaryTree);
    }

}
