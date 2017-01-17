package com.st.algos.btrees;


import java.util.List;

public class ConstructTree {

    public static void constrcut(List<String> preOrder, List<String> inOrder) {
        while (!preOrder.isEmpty() && !inOrder.isEmpty()) {
            BinaryNode binaryTree = new BinaryNode();
            binaryTree.data = preOrder.get(0);
            int index = getIndex(inOrder, binaryTree.data);
            String leftInInOrder = inOrder.get(index - 1);
            String leftInPreOrder = preOrder.get(1);
            if (leftInInOrder == leftInPreOrder) {
                BinaryNode left = new BinaryNode();
                left.data = leftInInOrder;
                left.parent=binaryTree;
                binaryTree.left = left;
                preOrder.remove(1);
                inOrder.remove(index - 1);
            }
            //anomaly, left in preOrder has to be a rigth in trre
            else {

            }
            String rightInInOrder = inOrder.get(index + 1);
            String rightInPreOrder = preOrder.get(2);
            if (rightInInOrder == rightInPreOrder) {
                BinaryNode right = new BinaryNode();
                right.data = rightInInOrder;
                right.parent = binaryTree;
                binaryTree.right = right;
                preOrder.remove(2);
                inOrder.remove(index - 2);
            }
            preOrder.remove(0);
            inOrder.remove(index);
        }
    }

    public static int getIndex(List<String> elements, String value) {
        return 5;
    }
}
