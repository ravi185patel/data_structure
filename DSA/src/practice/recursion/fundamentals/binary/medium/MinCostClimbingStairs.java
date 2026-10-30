package practice.recursion.fundamentals.binary.medium;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
//            return Math.min(minCostClimbing(0,cost),minCostClimbing(1,cost));
            return minCostClimbingDp(0,cost,new int[cost.length+1]);
    }

    public static int minCostClimbing(int index,int cost[]){
        if(index >= cost.length){
            return 0;
        }

        int oneStep = minCostClimbing(index+1,cost);
        int twoStep = minCostClimbing(index+2,cost);

        return cost[index] + Math.min(oneStep,twoStep);
    }

    public static int minCostClimbing(int index,int cost[],int memo[]){
        if(index >= cost.length){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }

        int oneStep = minCostClimbing(index+1,cost,memo);
        int twoStep = minCostClimbing(index+2,cost,memo);

        return memo[index] = cost[index] + Math.min(oneStep,twoStep);
    }

    public static int minCostClimbingDp(int index,int cost[],int memo[]){
        Arrays.fill(memo,0);
        /*memo[0]=0;
        for(int i=1;i<=cost.length;i++){
            int oneStep = memo[i-1];
            int twoStep = 0;
            if(i-2 >= 0){
                twoStep = memo[i-2];
            }
            memo[i] = cost[i-1]+Math.min(oneStep,twoStep);
        }
        return Math.min(memo[cost.length],memo[cost.length-1]);*/

        /*memo[0] = cost[0];
        memo[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            memo[i] = cost[i] + Math.min(memo[i-1],memo[i-2]);
        }
        return Math.min(memo[cost.length-1],memo[cost.length-2]);*/

        int oneStepCost = cost[0];
        int twoStepCost = cost[1];
        for(int i=2;i<cost.length;i++){
            int currentCost = cost[i] + Math.min(oneStepCost,twoStepCost);
            twoStepCost = oneStepCost;
            oneStepCost = currentCost;
        }
        return Math.min(twoStepCost,oneStepCost);
    }
}
