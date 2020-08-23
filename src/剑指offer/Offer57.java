package 剑指offer;

import java.util.*;

class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int tmpsum = nums[left]+nums[right];
        int[] res = new int[2];
        while(left<right) {
            if(tmpsum==target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
            else if(tmpsum<target) {
                tmpsum -= nums[left];
                left += 1;
                tmpsum += nums[left];
            }
            else {
                tmpsum -= nums[right];
                right -= 1;
                tmpsum += nums[right];
            }
        }
        return res;
    }
}