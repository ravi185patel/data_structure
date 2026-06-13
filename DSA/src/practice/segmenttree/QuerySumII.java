package practice.segmenttree;

import common.PrintUtil;
import template.segmenttree.SegmentTree;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class QuerySumII {

    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        int queries[]={1,4,2,3};
        int size = nums.length;
        BiFunction<Integer,Integer,Integer> sumOp = Integer::sum;
        Supplier<Integer> supplier = ()-> 0;
        SegmentTree segmentTree= new SegmentTree(size,sumOp,supplier);
        segmentTree.buildSegTree(nums);
        PrintUtil.print(segmentTree.seg);
        for(int i=0;i+1<size;i+=2){
            int start = queries[i]-1;
            int end = queries[i+1]-1;
            System.out.println(start+" <> "+end+" <> "+segmentTree.query(start,end));
        }

    }
}
