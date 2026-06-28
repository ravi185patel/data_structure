package practice.segmenttree;

import java.util.*;

class BalanceBinarySegTree{
    public int segMin[],segMax[],lazy[];
    int n;

    public BalanceBinarySegTree(int n) {
        this.n = n;
    }
}

public class LongestBalancedSubarrayII {
    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{1,2,3,2}));
    }
    public int longestBalanced1(int[] nums) {
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> even=new HashSet<>();
            Set<Integer> odd=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                if(even.size()==odd.size()){
                    maxLength= Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }

    public static int longestBalanced(int[] nums) {
        int n = nums.length;

        int[] cumSum = new int[n];
        int maxL = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            int val = (nums[r] % 2 == 0) ? 1 : -1;

            int prev = map.getOrDefault(nums[r], -1);

            if (prev != -1) {
                for (int l = 0; l <= prev; l++) {
                    cumSum[l] -= val;
                }
            }

            for (int l = 0; l <= r; l++) {
                cumSum[l] += val;
            }

            System.out.println(Arrays.toString(cumSum));

            for (int l = 0; l <= r; l++) {
                if (cumSum[l] == 0) {
                    maxL = Math.max(maxL, r - l + 1);
                    break;
                }
            }

            map.put(nums[r], r);
        }

        return maxL;
    }
}
