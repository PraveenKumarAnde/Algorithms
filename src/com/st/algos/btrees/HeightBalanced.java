package com.st.algos.btrees;

public class HeightBalanced {

    public static int getHeight(BinaryTree binaryTree) throws Exception {
        if (binaryTree.left == null && binaryTree.right == null) {
            return 0;
        } else {
            int leftHeight = getHeight(binaryTree.left);
            int rightHeight = getHeight(binaryTree.right);
            if ((Math.abs(leftHeight - rightHeight) > 1)) {
                throw new Exception("nopt");
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static HeightWithBalanced variant(BinaryTree binaryTree) throws Exception {
        if (binaryTree.left == null && binaryTree.right == null) {
            return new HeightWithBalanced(0, true);
        } else {
            HeightWithBalanced leftHeight = variant(binaryTree.left);
            HeightWithBalanced rightHeight = variant(binaryTree.right);
            boolean isBalanced = Math.abs(leftHeight.height - rightHeight.height) > 1;
            return new HeightWithBalanced(Math.max(leftHeight.height, rightHeight.height) + 1, isBalanced);
        }
    }

    static class HeightWithBalanced {
        public int height;
        public boolean isBalanced;

        public HeightWithBalanced(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static void testCase(String args[]) {
        BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", new BinaryTree("26", null, null), null), new BinaryTree("45", null, null));
        // BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", null, null), new BinaryTree("45", null, null));
        try {
            getHeight(binaryTree);
            System.out.println("yes");
        } catch (Exception e) {
            System.out.println("nope");
        }
    }
}
