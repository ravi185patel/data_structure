package practice.segmenttree;

import common.PrintUtil;
import template.segmenttree.SegmentTree;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RangeSumQuery {

    public static void main(String[] args) {
        int nums[]={1, 3, 5};
        int queries[][]={
                {0,2,-1},
                {1,2,1},
                {0,2,-1}
        };
        int size = nums.length;
        BiFunction<Integer,Integer,Integer> minOp = Integer::sum;
        Supplier<Integer> supplier = ()-> 0;
        SegmentTree segmentTree= new SegmentTree(size,minOp,supplier);
        segmentTree.buildSegTree(nums);
        PrintUtil.print(segmentTree.seg);
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int op=queries[i][2];
            if(op==1) {
                segmentTree.update(start,end);
            }else{
                System.out.println(start + " <> " + end + " <> " + segmentTree.query(start, end));
            }
        }

    }
}
