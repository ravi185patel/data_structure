package practice.segmenttree;

import template.segmenttree.SegmentTree;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class CountOfGoodTriplets {
    public static void main(String[] args) {
        System.out.println(goodTriplets(new int[]{2,0,1,3},new int[]{0,1,2,3}));
        System.out.println(goodTriplets(new int[]{4,0,1,3,2},new int[]{4,1,0,2,3}));
    }

    public static long goodTriplets(int nums1[],int nums2[]){
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums1.length;
        for(int i =0;i<n;i++){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        BiFunction<Integer,Integer,Integer> sumOp = Integer::sum;
        Supplier<Integer> supplier = ()-> 0;
        SegmentTree segmentTree = new SegmentTree(n,sumOp,supplier);
        long result = 0;
        segmentTree.update(map.get(nums1[0]),1);
        for(int i=1;i<n;i++){
            int idx = map.get(nums1[i]);
            long leftCommonCount = segmentTree.query(0,idx,0,0,n-1);
            long leftNotCommonCount = i - leftCommonCount;
            long elementsAfterIdxNums2 = (n-1) - idx;
            long rightCommonCount = elementsAfterIdxNums2 - leftNotCommonCount;
            result +=leftCommonCount * rightCommonCount;
            segmentTree.update(idx,1);
        }
        return result;
    }
}
