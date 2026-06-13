package practice.topksortedstructure;

import common.PrintUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
K Smallest Pair Sum → Min Heap + Frontier Expansion
K Largest Pair Sum → Max Heap + Frontier Expansion + Visited Set

 */
public class MaxOrTopKSumPair {
    record Tuple(long sum, int i, int j) {}

    public static long[] findMaxOrTopKSumPair(int[] nums1, int[] nums2, int k) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<Tuple> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.sum(), a.sum()));

        Set<String> visited = new HashSet<>();

        pq.offer(new Tuple(
                (long) nums1[n - 1] + nums2[m - 1],
                n - 1,
                m - 1));

        visited.add((n - 1) + "#" + (m - 1));

        long[] ans = new long[Math.min(k, n * m)];
        int idx = 0;

        while (!pq.isEmpty() && idx < ans.length) {

            Tuple cur = pq.poll();

            ans[idx++] = cur.sum();

            // Move up in nums1
            if (cur.i() - 1 >= 0) {
                String key = (cur.i() - 1) + "#" + cur.j();

                if (visited.add(key)) {
                    pq.offer(new Tuple(
                            (long) nums1[cur.i() - 1] + nums2[cur.j()],
                            cur.i() - 1,
                            cur.j()));
                }
            }

            // Move left in nums2
            if (cur.j() - 1 >= 0) {
                String key = cur.i() + "#" + (cur.j() - 1);

                if (visited.add(key)) {
                    pq.offer(new Tuple(
                            (long) nums1[cur.i()] + nums2[cur.j() - 1],
                            cur.i(),
                            cur.j() - 1));
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        MaxOrTopKSumPair maxOrTopKSumPair = new MaxOrTopKSumPair();
        PrintUtil.print(maxOrTopKSumPair.findMaxOrTopKSumPair(new int[]{9,5,7},new int[]{8,1,6},3));
    }
}
