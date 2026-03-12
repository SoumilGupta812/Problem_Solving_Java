package Dp;

public class fibo {
    public int fib(int n) {
        if(n<2) return n;
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n-1];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==2) return Math.min(cost[0],cost[1]);
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);

    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max( dp[i-1], nums[i]+ dp[i-2] );
        }
        return dp[n-1];
    }
    public int coinChange2D(int[] coins, int amount) {
        int n=coins.length;
        int m=amount;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=1;i<=m;i++)
            dp[0][i]=amount+1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j-coins[i-1]>=0)
                    dp[i][j]=Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        if(dp[n][m]>amount)
            return -1;
        else return dp[n][m];
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]=dp[i]+dp[i-coin];
            }
        }
        return dp[amount];
    }
}
