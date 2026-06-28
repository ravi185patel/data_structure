package practice.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithMajorityElementII {

    public static void main(String[] args) {

    }

    public static long countMajoritySubarrays(int[] nums, int target) {
        Map<Long,Long> prefixSum=new HashMap<>(); // need frequency of target
        long sum=0;
        int n = nums.length,count=0;
        long freq[]=new long[n+1];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            prefixSum.put((long)nums[i],(long)i);
        }
        return count;
    }

    public int countMajoritySubarraysBf(int[] nums, int target) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = i; j < n; ++j) {
                count += (nums[j] == target ? 1 : -1);
                if (count > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public int countMajoritySubarraysCSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                nums[i] = 1;
            else
                nums[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        long ans = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int sum = nums[r] - ((l > 0) ? nums[l - 1] : 0);
                if (sum > 0)
                    ans++;
            }
        }
        return (int) ans;
    }

    public long countMajoritySubarraysCSumMap(int[] nums, int target) {
        //Instead of map you can use an array of size 2*n+1 as well because we can have cumulative sum from -n to +n
        Map<Integer, Integer> mp = new HashMap<>();   // mp[cumSum] = frequency of how many times cumSum has occurred

        int currSum = 0;

        mp.put(0, 1); //we have seen cumSum = 0 in the beginning once
        long validLeftPoints = 0;
        long result = 0;
        for (int x : nums) {
            if (x == target) {
                validLeftPoints += mp.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeftPoints -= mp.getOrDefault(currSum, 0);
            }
            mp.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }

    public long countMajoritySubarraysCSumArr(int[] nums, int target) {
        int n = nums.length;
        // represents the occurrence count of prefix sums -n, -(n-1), ..., 0, 1, ..., n, with index offset by n.
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0;
        long presum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                presum += pre[cnt];
                ++cnt;
                ++pre[cnt];
            } else {
                --cnt;
                presum -= pre[cnt];
                ++pre[cnt];
            }
            ans += presum;
        }
        return ans;
    }
}
