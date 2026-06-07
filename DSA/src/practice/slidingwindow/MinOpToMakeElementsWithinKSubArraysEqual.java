package practice.slidingwindow;

import java.util.*;

class MedianWindow {

    public TreeMap<Integer, Integer> left = new TreeMap<>();
    public TreeMap<Integer, Integer> right = new TreeMap<>();

    public int leftSize = 0;
    public int rightSize = 0;

    public long leftSum = 0;
    public long rightSum = 0;

    public  void add(TreeMap<Integer,Integer> map,int val){
        map.put(val,map.getOrDefault(val,0)+1);
    }

    public  void remove(TreeMap<Integer,Integer> map,int val){
        int freq = map.get(val);

        if(freq == 1){
            map.remove(val);
        }else{
            map.put(val,freq-1);
        }
    }

    public void insert(int val){

        if(leftSize == 0 || val <= left.lastKey()){
            add(left,val);
            leftSize++;
            leftSum += val;
        }else{
            add(right,val);
            rightSize++;
            rightSum += val;
        }

        balance();
    }

    public void erase(int val){

        if(left.containsKey(val)){
            remove(left,val);
            leftSize--;
            leftSum -= val;
        }else{
            remove(right,val);
            rightSize--;
            rightSum -= val;
        }

        balance();
    }

    public  void balance(){

        while(leftSize > rightSize + 1){

            int move = left.lastKey();

            remove(left,move);
            leftSize--;
            leftSum -= move;

            add(right,move);
            rightSize++;
            rightSum += move;
        }

        while(leftSize < rightSize){

            int move = right.firstKey();

            remove(right,move);
            rightSize--;
            rightSum -= move;

            add(left,move);
            leftSize++;
            leftSum += move;
        }
    }

    public long cost(){

        long median = left.lastKey();

        long leftCost =
                median * leftSize - leftSum;

        long rightCost =
                rightSum - median * rightSize;

        return leftCost + rightCost;
    }
}

public class MinOpToMakeElementsWithinKSubArraysEqual {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5,-2,1,3,7,3,6,4,-1},3,2));
        System.out.println(minOperations(new int[]{9,-2,-2,-2,1,5},2,2));
    }

    public static long minOperations(int[] nums, int x, int k) {
        int length = nums.length;
//        long buckets[]=fillBuckets(nums,x);
        long buckets[]=fillBucketsOptTree(nums,x);
//        return helper(0,buckets,x,k);
        return helperOpt(0,buckets,x,k);
    }

    public static long helperOpt(int index,long buckets[],int x,int K){
        int n = buckets.length;
        long INF = (long)1e15;

        long[][] dp = new long[n + x + 1][K + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k <= K; k++) {
                dp[i][k] = INF;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= K; k++) {

                long notTake = dp[i + 1][k];

                long take = buckets[i] + dp[i + x][k - 1];

                dp[i][k] = Math.min(notTake, take);
            }
        }

        return dp[0][K];
    }
    public static long helper(int index,long buckets[],int x,int k){
        if (k == 0) {
            return 0;
        }

        if (index >= buckets.length) {
            return (long)1e9;
        }

        // Skip current bucket
        long notTake = helper(index + 1, buckets, x, k);

        // Take current bucket
        long take = buckets[index] +
                helper(index + x, buckets, x, k - 1);

        return Math.min(take, notTake);
    }

    public static long[] fillBuckets(int []nums,int x){

        long buckets[]=new long[nums.length-x+1];
        for(int i=0;i<=nums.length-x;i++){
            int arr[]= Arrays.copyOfRange(nums,i,i+x);
            Arrays.sort(arr);
            int median = x/2;
            for(int j=0;j<arr.length;j++) {
                buckets[i] += Math.abs(arr[median]-arr[j]);
            }
        }
        return buckets;
    }

    public static long[] fillBucketsOpt(int [] nums,int x){
        int n = nums.length;
        long[] buckets = new long[n - x + 1];

        for (int start = 0; start <= n - x; start++) {

            TreeMap<Integer,Integer> map = new TreeMap<>();

            for (int i = start; i < start + x; i++) {
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }

            int count = 0;
            int median = 0;
            int target = x / 2;

            for (Map.Entry<Integer,Integer> e : map.entrySet()) {
                count += e.getValue();
                if (count > target) {
                    median = e.getKey();
                    break;
                }
            }

            long cost = 0;

            for (int i = start; i < start + x; i++) {
                cost += Math.abs((long)nums[i] - median);
            }

            buckets[start] = cost;
        }

        return buckets;
    }

    public static long[] fillBucketsOptTree(int[] nums,int k){

        int n = nums.length;

        long[] buckets = new long[n-k+1];

        MedianWindow window = new MedianWindow();

        for(int i=0;i<k;i++){
            window.insert(nums[i]);
        }

        buckets[0] = window.cost();

        for(int i=k;i<n;i++){

            window.erase(nums[i-k]);

            window.insert(nums[i]);

            buckets[i-k+1] = window.cost();
        }

        return buckets;
    }
}
