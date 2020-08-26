package leetcode.DP;

import java.util.*;

public class Leetcode131 {
    private static List<List<String>> res;
    private int n;
    private Boolean[][] dp;

    public static void main(String[] args) {
        Leetcode131 solution = new Leetcode131();
        String s = new String("aab");
        res = solution.partition(s);
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new Boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                if(s.indexOf(j)==s.indexOf(i) && (i-j<2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                else {
                    dp[j][i] = false;
                }
            }
        }
        helper(0, new ArrayList(), s);
        return res;
    }

    public void helper(int i, List tmpres, String s) {
        if(i==n) {
            res.add(tmpres);
        }
        for(int j=i; i<n; j++) {
            if(dp[i][j]) {
                tmpres.add(s.substring(i,j));
                helper(j+1, tmpres, s);
            }
        }
    }
}
