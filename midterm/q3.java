package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Box box = new Box(0);
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode node = buildTree(preorder, inorder, box);

        System.out.println(node);
        System.out.println(node.left.val);
        System.out.println(node.right.val);

    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, Box box) {
        for (int i = 0; i < inorder.length; i++) {
            box.inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1, box);
    }



    private static TreeNode arrayToTree(int[] preorder, int left, int right , Box box) {
        if (left > right) return null;

        int rootValue = preorder[box.preorderIndex];
        box.preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, box.inorderIndexMap.get(rootValue) - 1, box);
        root.right = arrayToTree(preorder, box.inorderIndexMap.get(rootValue) + 1, right, box);
        return root;
    }


    }

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Box{
    int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    Box(int p){
        preorderIndex = p;
    }
}
