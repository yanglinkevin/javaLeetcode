package leetcode.DP;

import java.util.Scanner;

public class Leetcode64 {
    public static void main(String[] args) {
        Leetcode64 solution = new Leetcode64();
//        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        Scanner reader = new Scanner(System.in);
        int m = reader.nextInt();
        int n = reader.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = reader.nextInt();
            }
        }
        reader.close();
        solution.minPathSum(grid);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j>0) {
                    grid[i][j] += grid[i][j-1];
                }
                else if(j==0 && i>0) {
                    grid[i][j] += grid[i-1][j];
                }
                else if(i>0 && j>0) {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
