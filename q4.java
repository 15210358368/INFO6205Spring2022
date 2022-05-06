package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //[6,2,8,0,4,7,9,null,null,3,5]
        Node root = new Node(6);
        Node node1 = new Node(2);
        Node node2 = new Node(8);
        root.left = node1;
        root.right = node2;
        Node node3 = new Node(0);
        Node node4 = new Node(4);
        node1.left = node3;
        node1.right = node4;
        Node node5 = new Node(7);
        Node node6 = new Node(9);
        node2.left = node5;
        node2.right = node6;
        Node node7 = new Node(3);
        Node node8 = new Node(5);
        node6.left = node7;
        node6.right = node8;



        System.out.println(lowestCommonAncestor(root, node7, node5).val);


    }


    public static Node lowestCommonAncestor(Node root, Node p, Node q){
        Queue<Node> Q = new ArrayDeque<>();
        Map<Node, Node> mp = new HashMap<>();
        mp.put(root, null);
        Q.offer(root);

        while(!Q.isEmpty()){
            Node cur = Q.poll();

            if(cur.left != null) {
                Q.offer(cur.left);
                mp.put(cur.left, cur);
            }

            if(cur.right != null){
                Q.offer(cur.right);
                mp.put(cur.right, cur);
            }
        }

        Set<Node> path = new HashSet<>();
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

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
