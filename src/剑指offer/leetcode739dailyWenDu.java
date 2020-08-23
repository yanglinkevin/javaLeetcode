package 剑指offer;

import java.util.*;

class Solution {
    public static void  main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = Solution.dailyTemperatures(temperatures);
        for(int i=0;i<temperatures.length;i++){
            System.out.println(result[i] + "");
        }
    }
    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && T[i]>=T[stack.peek()]){
                stack.pop();
            }
            if(stack.size()==0){
                res[i] = 0;
            }
            else{
                res[i] = stack.peek() - i;
            }
            stack.add(i);
        }
        return res;
    }
}