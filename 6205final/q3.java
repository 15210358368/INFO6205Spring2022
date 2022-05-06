package com.company;

import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static List<List<String>> res;
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        String[] str1 = {};
        String[] str2 = {""};
        System.out.println(groupAnagrams(str));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        res = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);

            if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());
            mp.get(key).add(s);

        }

        for(String s : mp.keySet()){
            res.add(mp.get(s));
        }

        return res;
    }
}
