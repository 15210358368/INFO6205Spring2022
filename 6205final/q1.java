package com.company;

public class Main {

    public static void main(String[] args) {
        //String input = "aabcccccaaa";
        //String input = "abcdddddddddd";
        String input = "a";
        String input1 = "abcd";
        System.out.println(compressString(input1));
    }

    public static String compressString(String c){

        StringBuilder sb = new StringBuilder();
        if(c.length() == 1){
            return c;
        }

        int i = 0;
        int j = 1;

        while(i < c.length()){
            int curNum = 1;

            while(j < c.length() && c.charAt(i) == c.charAt(j)){
                curNum++;
                j++;
            }

            sb.append(c.charAt(i));
            sb.append(curNum);

            i = j;
            j ++;

        }

        if(sb.toString().length() / 2 == c.length()
                || sb.toString().length()  >= c.length()) return c;
        return sb.toString();
    }
}
