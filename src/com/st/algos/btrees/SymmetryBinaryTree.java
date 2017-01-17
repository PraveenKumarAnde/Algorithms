package com.st.algos.btrees;

import java.util.ArrayList;
import java.util.List;

public class SymmetryBinaryTree {

    public static boolean isSymmetric(BinaryTree tree) {
        ArrayList<String> elemets1 = new ArrayList<>();
        inOrderTraversal(tree.left, elemets1);
        ArrayList<String> elemets2 = new ArrayList<>();
        inOrderTraversalVariant(tree.right, elemets2);
        if (elemets1.size() != elemets2.size()) {
            return false;
        }
        for (int i = 0; i < elemets1.size(); i++) {
            if (!elemets1.get(i).equals(elemets2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void inOrderTraversal(BinaryTree binaryTree, List<String> elements) {
        if (binaryTree == null) {
            return;
        }
        inOrderTraversal(binaryTree.left, elements);
        elements.add(binaryTree.data);
        inOrderTraversal(binaryTree.right, elements);
    }

    public static void inOrderTraversalVariant(BinaryTree binaryTree, List<String> elements) {
        if (binaryTree == null) {
            return;
        }
        inOrderTraversalVariant(binaryTree.right, elements);
        elements.add(binaryTree.data);
        inOrderTraversalVariant(binaryTree.left, elements);
    }

    public static void main(String[] args) {

    }
}
