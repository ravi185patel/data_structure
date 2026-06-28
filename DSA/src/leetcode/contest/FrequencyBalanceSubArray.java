package leetcode.contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrequencyBalanceSubArray {
    public static void main(String[] args) {
        System.out.println(longestFrequencyBalanceSubarray(new int[]{1,2,2,1,2,3,3,3}));
        System.out.println(longestFrequencyBalanceSubarray(new int[]{5,5,5,5}));
        System.out.println(longestFrequencyBalanceSubarray(new int[]{1,2,3,4}));
    }
    public static int longestFrequencyBalanceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();
            int distinct = 0;

            for (int right = left; right < n; right++) {
                int x = nums[right];

                int oldFreq = count.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    int c = freqCount.get(oldFreq) - 1;
                    if (c == 0) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, c);
                    }
                } else {
                    distinct++;
                }

                int newFreq = oldFreq + 1;
                count.put(x, newFreq);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

                boolean valid = false;

                if (distinct == 1) {
                    valid = true;
                } else if (freqCount.size() == 2) {
                    Iterator<Integer> it = freqCount.keySet().iterator();
                    int f1 = it.next();
                    int f2 = it.next();

                    int low = Math.min(f1, f2);
                    int high = Math.max(f1, f2);

                    if (high == 2 * low) {
                        valid = true;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
}
