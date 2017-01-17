package com.st.algos.btrees;


import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public static void inOrderTraversal(BinaryTree binaryTree, List<String> elements) {
        if (binaryTree != null) {
            inOrderTraversal(binaryTree.left, elements);
            elements.add(binaryTree.data);
            inOrderTraversal(binaryTree.right, elements);
        }
    }

    public static void preOrderTraversal(BinaryTree binaryTree, List<String> elements) {
        if (binaryTree != null) {
            elements.add(binaryTree.data);
            preOrderTraversal(binaryTree.left, elements);
            preOrderTraversal(binaryTree.right, elements);
        }
    }

    public static void postOrderTraversal(BinaryTree binaryTree, List<String> elements) {
        if (binaryTree != null) {
            postOrderTraversal(binaryTree.left, elements);
            postOrderTraversal(binaryTree.right, elements);
            elements.add(binaryTree.data);
        }
    }



    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", null, new BinaryTree("17", null, null)), new BinaryTree("45", null, null));
        List<String> elements = new ArrayList<>();
        inOrderTraversal(binaryTree, elements);
        print(elements);


        elements = new ArrayList<>();
        preOrderTraversal(binaryTree,elements);
        print(elements);

        elements = new ArrayList<>();
        postOrderTraversal(binaryTree, elements);
        print(elements);
    }

    private static void print(List<String> elements) {
        System.out.println("printing elements");
        for (String str : elements) {
            System.out.println(str);
        }
    }
}
