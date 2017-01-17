package com.st.algos.btrees;


public class LCSWithParent {

    public static int getHeight(BinaryNode binaryNode) {
        int height = 0;
        while (binaryNode != null) {
            binaryNode = binaryNode.parent;
            height++;
        }
        return height;
    }

    public BinaryNode commmonAncestor(BinaryNode binaryNode1, BinaryNode binaryNode2) {
        int height1 = getHeight(binaryNode1);
        int height2 = getHeight(binaryNode2);
        if (height1 != height2) {
            if (height1 > height2) {
                int diff = height1 - height2;
                while (diff > 0) {
                    binaryNode1 = binaryNode1.parent;
                }
            }
            else if (height1 < height2) {
                int diff = height2 - height2;
                while (diff > 0) {
                    binaryNode2 = binaryNode2.parent;
                }
            }
        }
        while (binaryNode1.data != binaryNode2.data) {
            binaryNode1 = binaryNode1.parent;
            binaryNode2 = binaryNode2.parent;
        }
        return binaryNode1;
    }
}
