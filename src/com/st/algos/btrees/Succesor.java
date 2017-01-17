package com.st.algos.btrees;


public class Succesor {

    /**
     * if a node has right successor is in the right child
     * else successor is in the ancestor (i.e the closest ancestor which has a right child )
     * @param node
     * @return
     */

    public static String  printSuccesor(BinaryNode node) {
        BinaryNode right = node.right;
        if (right != null) {
            while(right.left != null) {
                right = right.left;
            }
            return right.data;
        }
        BinaryNode parent = node.parent;
        while (parent != null && parent.right != node) {
            node = node.parent;
            parent = node.parent;
        }
        return parent != null ? parent.data : null;
    }
}
