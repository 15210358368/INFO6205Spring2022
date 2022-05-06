package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //[6,2,8,0,4,7,9,null,null,3,5]

        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        node6.left = node7;
        node6.right = node8;



        System.out.println(lowestCommonAncestor(root, node8, node4).val);


    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Queue<TreeNode> Q = new ArrayDeque<>();
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        mp.put(root, null);
        Q.offer(root);

        while(!Q.isEmpty()){
            TreeNode cur = Q.poll();

            if(cur.left != null) {
                Q.offer(cur.left);
                mp.put(cur.left, cur);
            }

            if(cur.right != null){
                Q.offer(cur.right);
                mp.put(cur.right, cur);
            }
        }

        Set<TreeNode> path = new HashSet<>();
        while(p != null){
            path.add(p);
            p = mp.get(p);
        }

        while(!path.contains(q)){
            q = mp.get(q);
        }

        return q;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

