package 剑指offer;

public class Compose100 {

    /**
     * @param x 商品金额
     */
    public static void test2(int n){
        //纸币面额
        int money[]={1,5,10};
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0;i < money.length;i++){
            for(int j = money[i];j <= n;j++){
                dp[j] =(dp[j]+dp[j-money[i]]);
            }
        }
        for(int i=0; i<n+1; i++){
            System.out.println((dp[i]));
        }
        System.out.println(dp[n]);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //指定200元的金额
        test2(10);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime) + "ms");
    }
}

