package 剑指offer;

import java.util.ArrayList;
import java.util.*;

public class Offer57_2 {
    public static void  main(String[] args) {
        Offer57_2 test = new Offer57_2();
        int[][] res = test.findContinuousSequence(15);
        System.out.println(res);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList();
        int[] nums = new int[target];
        for(int i=0; i<target; i++) {
            nums[i] = i+1;
        }
        int left = 0;
        int tmpres = 0;
        int cnt = 0;
        for(int right=1; right<target; right++) {
            tmpres += right;
            while(left<right & tmpres>=target) {
                if(tmpres==target) {
                    list.add(Arrays.copyOfRange(nums, left, right));
                    cnt += 1;
                }
                tmpres -= left;
                left += 1;
            }
        }
        int[][] res = new int[list.size()][];
        for(int i=0; i< list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
