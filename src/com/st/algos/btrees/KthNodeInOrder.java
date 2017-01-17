package com.st.algos.btrees;

public class KthNodeInOrder {

    public static String kthNode(BinaryTreeVariant binaryTreeVariant, int k) {
        int safeLeftCount = getSafeCount(binaryTreeVariant.left);
        if (k == safeLeftCount + 1) {
            return binaryTreeVariant.data;
        }
        if (safeLeftCount + 1 > k) {
            return kthNode(binaryTreeVariant.left, k);
        } else {
            return kthNode(binaryTreeVariant.right, k - safeLeftCount - 2);
        }
    }

    public static String kthNodeWithoutRecursion(BinaryTreeVariant binaryTreeVariant, int k) {
        while (binaryTreeVariant != null) {
            int safeLeftCount = getSafeCount(binaryTreeVariant.left);
            if (k == safeLeftCount + 1) {
                return binaryTreeVariant.data;
            }
            if (safeLeftCount + 1 > k) {
                binaryTreeVariant = binaryTreeVariant.left;
            } else {
                binaryTreeVariant = binaryTreeVariant.right;
                k = k - safeLeftCount - 2;
            }
        }
        return null;
    }

    private static int getSafeCount(BinaryTreeVariant binaryTree) {
        return binaryTree != null ? binaryTree.childCount : 0;
    }

    public static void main(String args[]) {
        BinaryTreeVariant binaryTree = new BinaryTreeVariant("25",
                new BinaryTreeVariant("35",
                        new BinaryTreeVariant("26", null, null, 1),
                        new BinaryTreeVariant("17", null, null, 1), 2),
                new BinaryTreeVariant("45", null, null, 1),
                4
        );
        String s = kthNodeWithoutRecursion(binaryTree, 1);
        System.out.println(s);
    }
}
