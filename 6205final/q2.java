package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] grid = new String[][]{
                        {"0","0","0","0","0"},
                        {"0","0","0","1","0"},
                        {"0","0","0","0","0"},
                        {"0","0","0","0","0"}
        };


        System.out.println(numIslands(grid));

    }

    public static int numIslands(String[][] grid){
        if(grid.length == 0) return 0;

        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == "1"){
                    num++;
                    helper(grid, i, j);
                }
            }
        }

        return num;
    }

    public static void helper(String[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == "0") return;
        grid[x][y] = "0";

        helper(grid, x + 1 , y);
        helper(grid, x - 1 , y);
        helper(grid, x, y + 1);
        helper(grid, x , y - 1);
    }
}
