package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(1,3));
        intervals.add(Arrays.asList(5,11));
        intervals.add(Arrays.asList(8,10));
        intervals.add(Arrays.asList(2,4));
        intervals.add(Arrays.asList(15,18));
        intervals.add(Arrays.asList(99,181));

        for(List<Integer> li : intervals){
            System.out.print("(");
            for(int i : li){
                System.out.print(i + ",");
            }
            System.out.print(")  ");
        }


        //merge(intervals)
        for(List<Integer> li : merge(intervals)){
            System.out.print("(");
            for(int i : li){
                System.out.print(i + ",");
            }
            System.out.print(")  ");
        }


    }

    public static List<List<Integer>> merge(List<List<Integer>> intervals){

        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));


        System.out.println(" ");
        LinkedList<List<Integer>> q = new LinkedList<>();
        q.offer(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++){
            if(q.getLast().get(1) >= intervals.get(i).get(0)){
                List<Integer> li = new ArrayList<>();
                List<Integer> pre = q.pollLast();
                li.add(Math.min(pre.get(0), intervals.get(i).get(0)));
                li.add(Math.max(pre.get(1), intervals.get(i).get(1)));
                q.offer(li);
            }else{
                q.offer(intervals.get(i));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}
