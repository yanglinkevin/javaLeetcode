package leetcode.DP;

import java.util.*;

public class Leetcode213 {
    public static void main(String[] args) {
        Leetcode213 solution = new Leetcode213();
        int[] nums = new int[]{1,3,1,3,100};
        solution.rob(nums);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) {
            return 0;
        }
        if(n<=3) {
            Arrays.sort(nums);
            return nums[0];
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
        }
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++) {
            dp2[i-1] = Math.max(dp2[i-2], dp2[i-3]+nums[i]);
        }
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}
