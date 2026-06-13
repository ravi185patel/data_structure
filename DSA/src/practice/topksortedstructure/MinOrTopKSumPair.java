package practice.topksortedstructure;

import common.PrintUtil;

import java.util.*;

/*
K Smallest Pair Sum → Min Heap + Frontier Expansion
K Largest Pair Sum → Max Heap + Frontier Expansion + Visited Set

 */
public class MinOrTopKSumPair {
    public record Tuple(long value, int index, int listIndex) {}

    public long[] findMaxOrTopKSumPair(int[] nums1, int[] nums2, int k) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<Tuple> pq =
                new PriorityQueue<>(Comparator.comparingLong(Tuple::value));

        // Push first element of every row
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Tuple((long) nums1[i] + nums2[0], i, 0));
        }

        long[] res = new long[k];
        int idx = 0;

        while (!pq.isEmpty() && idx < k) {

            Tuple curr = pq.poll();

            res[idx++] = curr.value();

            // Expand to next element in same row
            if (curr.listIndex() + 1 < nums2.length) {

                pq.offer(new Tuple(
                        (long) nums1[curr.index()] + nums2[curr.listIndex() + 1],
                        curr.index(),
                        curr.listIndex() + 1
                ));
            }
        }

        return res;
    }
    public static void main(String[] args) {
        MinOrTopKSumPair maxOrTopKSumPair = new MinOrTopKSumPair();
        PrintUtil.print(maxOrTopKSumPair.findMaxOrTopKSumPair(
                new int[]{9,5,7},
                new int[]{8,1,6},3));
    }
}
