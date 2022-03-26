package com.company;

public class Main {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);



       Node l2 = new Node(1);
        l2.next = new Node(2);
       l2.next.next = new Node(3);



        Node n = add(l1, l2);

        System.out.println("");

        Node ll3 = n;
        while(ll3 != null){
            System.out.print(ll3.val + "->");
            ll3 = ll3.next;
        }

        System.out.println("null");
    }

    public static Node add(Node l1, Node l2){
        Node res = new Node(0);

        Node node = res;
        int carry = 0;
        int sum = 0;

        while(l1 != null && l2 != null){

            sum = carry;
            sum += l1.val + l2.val;

            carry = sum/10;
            node.next = new Node(sum % 10);


            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while(l1 != null){
            node.next = new Node(l1.val);

            l1 = l1.next;
            node = node.next;
        }
        while(l2 != null){
            node.next = new Node(l2.val);

            l2 = l2.next;
            node = node.next;
        }

        return res.next;

    }
}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
