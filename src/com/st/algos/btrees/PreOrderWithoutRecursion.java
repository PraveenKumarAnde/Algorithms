package com.st.algos.btrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderWithoutRecursion {

    public static void preOrderWithoutRecursion(BinaryTree binaryTree) {
        List<String> elements = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree currentElement = binaryTree;
        while (currentElement!= null || !stack.isEmpty()) {
            if (currentElement != null) {
                elements.add(currentElement.data);
                stack.add(currentElement);
                currentElement = currentElement.left;
            } else {
                BinaryTree pop = stack.pop();
                currentElement = pop.right;
            }
        }

        for (String ele : elements) {
            System.out.println(ele);
        }
     }

    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", new BinaryTree("26", null, null), new BinaryTree("17", null, null)), new BinaryTree("45", null, null));
        preOrderWithoutRecursion(binaryTree);
    }
}
