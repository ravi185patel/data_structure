package practice.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1,-1},2)); // why sliding window not worked.
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }
    /*
    1,1,1,-1
    k = 2
    here in sliding window you have dynamic window
    but at what point need to shrink not fixed as it is depend on future.
    so in sw it is calculate on current index not future index.
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0,count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int reminder = sum-k;
            count+=map.getOrDefault(reminder,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
