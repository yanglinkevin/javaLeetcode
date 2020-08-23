package 剑指offer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Offer56 {
    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        Offer56 test = new Offer56();
        int result = test.singleNumber(nums);
        System.out.println(result);
    }
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        hashtable.put(1,1);
        hashtable.get(1);
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,1);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        for(int i=0;i<n;i++) {
            if(!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            }
            else{
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }
        }
        for(int i=0;i<n;i++) {
            if(hashMap.get(nums[i])==1) {
                res = nums[i];
            }
        }
        return res;
    }
}