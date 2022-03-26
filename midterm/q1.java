package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0, upper = 51;

        for(String s : findMissing(nums, lower, upper)){
            System.out.println(s);
        }
    }

    public static List<String> findMissing(int[] nums, int lower, int upper){
        Set<Integer> st = new HashSet<>();

        List<String> res = new ArrayList<>();
        for(int i : nums){
            st.add(i);
        }

        List<Integer> tmp;

        for(int i = lower; i < upper; i++){
            tmp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            if(!st.contains(i)){
                tmp.add(i);
                while(!st.contains(i + 1) && i + 1 < upper) i++;
                tmp.add(i);
                if(tmp.get(0) == tmp.get(1)) sb.append(tmp.get(0));
                else sb.append(tmp.get(0) + "->" + tmp.get(1));
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
}
