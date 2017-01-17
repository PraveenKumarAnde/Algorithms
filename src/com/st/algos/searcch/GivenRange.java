package com.st.algos.searcch;

public class GivenRange {

    public int inGivenRange(BinarySearchTree binaryTree, int minimum, int maximum) {
        if (binaryTree.data > minimum && binaryTree.data < maximum) {
            return inGivenRange(binaryTree.left, minimum, maximum) + inGivenRange(binaryTree.right, minimum, maximum) + 1;
        } else if (binaryTree.data >= maximum) {
            return inGivenRange(binaryTree.left, minimum, maximum);
        } else if (binaryTree.data <= minimum){
            return inGivenRange(binaryTree.left, minimum, maximum);
        }
        return 0;
    }


}

