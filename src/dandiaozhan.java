//小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
//小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
//6
//5 3 8 3 2 5
//3 3 5 4 4 4
//当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼
import java.util.*;
public class dandiaozhan {
    public static void  main(String[] args) {
        int n = 6;
        int nums[] = {5, 3, 8, 3, 2, 5};
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            res[i] = helper(stack, nums[i]);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            res[i] += helper(stack, nums[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println(res[i]+1 + " ");
        }
    }

    public static int helper(Stack<Integer> stack, int num){
        if(stack.isEmpty()){
            stack.add(num);
            return 0;
        }
        int tmpres = stack.size();
        while(!stack.isEmpty() && num>stack.peek()){
            stack.pop();
        }
        stack.add(num);
        return tmpres;
    }
}
