package template.prefixsum;

import common.PrintUtil;

import java.util.Arrays;
import java.util.function.BiFunction;

public class BasicPrefixSum {

    public static void main(String[] args) {

        PrintUtil.print(findRangeSum(new int[][]{{0,3},{2,4},{1,4}},new int[]{1,2,3,4,5,6},(i,j)->i*j,1));
        PrintUtil.print(findRangeSum(new int[][]{{0,3},{2,4},{1,4}},new int[]{1,2,3,4,5,6}, Integer::sum,0));
    }


    public static int[] findRangeSum(int[][] queries, int nums[]
            , BiFunction<Integer,Integer,Integer> ops,int initValue){
        int prefixSum []=prefixSum(nums,ops,initValue);
        int ans[]=new int[queries.length];
        for(int q=0;q<queries.length;q++){
            int query[] =queries[q];
            ans[q]=range(query[0],query[1],prefixSum,initValue);
        }
        return ans;
    }

    public static int[] prefixSum(int nums[], BiFunction<Integer,Integer,Integer> ops,int initValue){
        int n = nums.length;
        int prefixSum[]=new int[n+1];
        Arrays.fill(prefixSum,initValue);
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1]=ops.apply(nums[i],prefixSum[i]);
        }
        System.out.println(Arrays.toString(prefixSum));
        return prefixSum;
    }

    public static int range(int l,int r,int prefixSum[],int initValue){
        if(initValue==1){
            return  prefixSum[r + 1] / prefixSum[l];
        }else {
            System.out.println(prefixSum[r + 1] +" <> "+prefixSum[l]);
            return prefixSum[r + 1] - prefixSum[l];
        }
    }

    public static void prefixRun(int nums[]){
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            // condition : based on it get previous or current sum.
        }
    }
}
