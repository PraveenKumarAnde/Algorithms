package com.st.algos.btrees;


import java.util.ArrayList;
import java.util.List;

public class InOrderWithO1Space {

    public static void inOrderSimplee(BinaryNode node) {

        List<String> elements = new ArrayList<>();
        BinaryNode currentNode = node;
        while (currentNode != null) {
            if (currentNode.left == null) {
                elements.add(currentNode.data);
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    while (currentNode.parent.right != currentNode) {
                        currentNode = currentNode.parent.right;
                    }
                    elements.add(currentNode.parent.data);
                }
            } else {
                currentNode = currentNode.left;
            }

        }
    }

    public static void inOrder(BinaryNode root) {
        List<String> elements = new ArrayList<>();
        BinaryNode current = root;
        int currentHeight = 0;
        int previousHeight = -1;
        while (current != null) {
            if (current.left != null && previousHeight < currentHeight) {
                previousHeight = currentHeight;
                currentHeight++;
                current = current.left;
            } else {

                elements.add(current.data);
                if (current.right != null && previousHeight < currentHeight) {
                    previousHeight = currentHeight;
                    currentHeight++;
                    current = current.right;
                } else {
                    previousHeight = currentHeight;
                    currentHeight--;
                    BinaryNode currentsParent = current.parent;
                    elements.add(currentsParent.data);
                    current = currentsParent.right;
                }
            }
        }

    }
}
