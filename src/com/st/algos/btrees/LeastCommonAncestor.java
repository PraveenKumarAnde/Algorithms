package com.st.algos.btrees;


public class LeastCommonAncestor {

    public static String lcs(BinaryTree binaryTree, String element1, String element2) {
        if (binaryTree.data.equals(element1) || binaryTree.data.equals(element2)) {
            return binaryTree.data;
        }
        return postOrderTraverse(binaryTree, element1, element2).answer;
    }

    public static ResultValue postOrderTraverse(BinaryTree binaryTree, String element1, String element2) {
        ResultValue result = new ResultValue();
        if (binaryTree == null) {
            return new ResultValue();
        }
        ResultValue result1 = postOrderTraverse(binaryTree.left, element1, element2);
        ResultValue result2 = postOrderTraverse(binaryTree.right, element1, element2);

        if (result1.answer!= null) {
            return result1;
        } else if(result2.answer != null){
            return result2;
        }
        else if (result1.valueFound!=null && result2.valueFound!=null) {
            result.answer = binaryTree.data;
            return result;
        }
        else if (binaryTree.data.equals(element1) || binaryTree.data.equals(element2)) {
            result.valueFound = binaryTree.data;
        }else if (result1.valueFound != null){
            return result1;
        }else if (result2.valueFound != null) {
            return result2;
        }
        return result;
    }
    static class ResultValue {
        String valueFound;
        String answer;
    }


    public static Result posOrderTraversalWithTrick(BinaryTree binaryTree, String value1, String value2) {
        Result result = new Result();
        if (binaryTree == null) {
            return null;
        }
        Result result1 = posOrderTraversalWithTrick(binaryTree.left, value1, value2);
        Result result2 = posOrderTraversalWithTrick(binaryTree.right, value1, value2);


        if (result1 != null && result1.isTwoFound()) {
            return result1;
        } else if (result2!= null && result2.isTwoFound()) {
            return result2;
        }

        if (result1 != null && result2 != null && result1.isOneFound() && result2.isOneFound()) {
            result.value = binaryTree.data;
            result.foundA = true;
            result.foundB = true;
        }
        //left is found so lets move an ancestor up and ask it do find another
        else if (result1 != null && result1.isOneFound()) {
            result.foundA = true;
        } else if (result2 != null  && result2.isOneFound()) {
            result.foundB = true;
        }
        // none found so far
        else if (binaryTree.data.equals(value1) || binaryTree.data.equals(value2)) {
            result.foundA = true;
        }
        return result;
    }

    static class Result {
        boolean foundA;
        boolean foundB;
        String value;

        public boolean isOneFound() {
            return foundA || foundB;
        }

        public boolean isTwoFound() {
            return foundA && foundB;
        }
    }

    public static void anotherApproach(BinaryTree binaryTree) {
        //if leaf see if its in the left node
            // logic here
        //yes
            //see if its the node itself

        // no
        // see if its in the right node
    }



    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree("25", new BinaryTree("35", new BinaryTree("26", null, null), new BinaryTree("17", null, null)), new BinaryTree("45", null, null));
        Result result = posOrderTraversalWithTrick(binaryTree, "26", "45");
        System.out.println(result.value);
        System.out.println(lcs(binaryTree, "26", "45"));
    }
}
