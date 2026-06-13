package practice.segmenttree;

import common.PrintUtil;
import template.segmenttree.SegmentTree;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RangeMaxQuery {

    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        int queries[]={0,2,2,3};
        int size = nums.length;
        BiFunction<Integer,Integer,Integer> minOp = Integer::max;
        Supplier<Integer> supplier = ()-> Integer.MIN_VALUE;
        SegmentTree segmentTree= new SegmentTree(size,minOp,supplier);
        segmentTree.buildSegTree(nums);
        PrintUtil.print(segmentTree.seg);
        for(int i=0;i+1<size;i+=2){
            int start = queries[i];
            int end = queries[i+1];
            System.out.println(start+" <> "+end+" <> "+segmentTree.query(start,end));
        }

    }
}
