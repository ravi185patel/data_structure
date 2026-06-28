package template.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumWithHashing {
    public static void main(String[] args) {

    }

    public void find(int nums[],int k){
        Map<Long, Integer> map = new HashMap<>();

        map.put(0L, 1);
        long prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;

            count += map.getOrDefault(prefix - k, 0);
            map.put(prefix,
                    map.getOrDefault(prefix, 0) + 1);
        }

    }

    public void equalsZeroAndOne(int nums[]){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefix = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            prefix += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefix)) {
                maxLen = Math.max(maxLen,
                        i - map.get(prefix));
            } else {
                map.put(prefix, i);
            }
        }
    }


    public void longestSubArrayWithSumK(int nums[],int k){
        Map<Long, Integer> map = new HashMap<>();

        long prefix = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if (prefix == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefix - k)) {
                maxLen = Math.max(maxLen,
                        i - map.get(prefix - k));
            }

            map.putIfAbsent(prefix, i);
        }

    }
}
