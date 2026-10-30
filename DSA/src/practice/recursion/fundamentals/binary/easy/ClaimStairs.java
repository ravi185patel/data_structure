package practice.recursion.fundamentals.binary.easy;

public class ClaimStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n){
//        return climb(n);
//        return climbDp(n);
        return climbDpNormal(n);
    }

    public static int climb(int n){
        if(n <= 1) return 1;
        int stepOne= climb(n-1);
        int stepTwo = climb(n-2);
        return stepOne + stepTwo;
    }

    public static int climbDp(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            int stepOne= dp[i-1];
            int stepTwo = dp[i-2];
            dp[i] = stepOne + stepTwo;
        }
        return dp[n];
    }

    public static int climbDpNormal(int n){
        int oneStep = 1;
        int twoStep = 1;

        for(int i=2;i<=n;i++){
            int currentStep = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = currentStep;
        }
        return oneStep;
    }
}
