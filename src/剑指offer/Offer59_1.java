package 剑指offer;

import java.util.*;


//  滑动窗口的位置                最大值
//  ---------------               -----
//  [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
public class Offer59_1 {
    private int[] nums;
    private ArrayList<Integer> maxStack;

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        Offer59_1 solution = new Offer59_1();
        int[] result = solution.maxSlidingWindow(nums, k);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int getMax() {
        return this.maxStack.get(0);
    }
    public void push(int i) {
        while (this.maxStack.size()!=0 && this.maxStack.get(this.maxStack.size()-1)<this.nums[i]) {
            this.maxStack.remove(this.maxStack.size()-1);
        }
        this.maxStack.add(this.nums[i]);
    }
    public void pop(int i) {
        if(this.maxStack.size()!=0 && this.nums[i]==this.getMax()) {
            this.maxStack.remove(0);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums = nums;
        this.maxStack = new ArrayList(k);
        int[] res = new int[nums.length-k+1];
        if(k==0 || nums.length==0) {
            return new int[0];
        }
        for(int i=0; i<nums.length; i++) {
            if(i<k-1) {
                this.push(i);
            }
            else {
                this.push(i);
                res[i-k+1] = this.getMax();
                this.pop(i+1-k);
            }
        }
        return res;
    }
}

class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }
}