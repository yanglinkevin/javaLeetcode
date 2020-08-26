package leetcode.DP;

import java.util.Scanner;

public class Leetcode62 {
    private static int[][] mem;
    public static void main(String[] args) {
        Leetcode62 solution = new Leetcode62();
        Scanner reader = new Scanner(System.in);
        int m=reader.nextInt();
        int n=reader.nextInt();
        reader.close();
        int res = solution.uniquePaths(m, n);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        mem = new int[m][n];
        return helper(0, 0, m, n);
    }

    public int helper(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) {
            return 1;
        }
        if(i>m-1 || j>n-1) {
            return 0;
        }
        if(mem[i][j]!=0) {
            return mem[i][j];
        }
        mem[i][j] = helper(i+1, j, m, n) + helper(i, j+1, m, n);
        return mem[i][j];
    }
}
