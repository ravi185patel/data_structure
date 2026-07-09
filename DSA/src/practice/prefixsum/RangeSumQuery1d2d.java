package practice.prefixsum;

import common.PrintUtil;

public class RangeSumQuery1d2d {
    public static void main(String[] args) {
        rangeSumQuery2d(new int[][]{
                {1,2,3},
                {2,3,4}
        });
    }

    public static void rangeSumQuery1d(int nums[]){

    }

    public static void rangeSumQuery2d(int nums[][]){
        // build prefix matrix
        //
        int m = nums.length;
        int n = nums[0].length;
        int prefixSum[][]=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prefixSum[i][j] = nums[i-1][j-1]
                        + prefixSum[i-1][j]
                        + prefixSum[i][j-1]
                        - prefixSum[i-1][j-1];
            }
        }
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(i==0){
//                    prefixSum[i][j+1] = prefixSum[i][j] + nums[i][j];
//                }
//                if(j==0){
//                    prefixSum[i+1][j] = prefixSum[i][j] + nums[i][j];
//                }
//                if(i!=0 && j!=0){
//                    prefixSum[i+1][j+1] = nums[i][j] + prefixSum[i][j]+prefixSum[i][j] - prefixSum[i-1][j-1];
//                }
//            }
//        }
        System.out.println("*****************  nums *****************");
        PrintUtil.print(nums);
        System.out.println("*****************  prefix sum *****************");
        PrintUtil.print(prefixSum);
    }


}
