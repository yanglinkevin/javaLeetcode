package leetcode.DP;

public class Leetcode303 {
    private int[] res;

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        Leetcode303 solution = new Leetcode303(nums);
        solution.sumRange(0,2);
    }

    public Leetcode303(int[] nums) {
        int n = nums.length;
        res = new int[n+1];
        res[0] = 0;
        for(int i=1; i<n+1; i++) {
            res[i] = res[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return res[j+1] - res[i];
    }
}
