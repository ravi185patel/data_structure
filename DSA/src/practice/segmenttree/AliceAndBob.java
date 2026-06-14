package practice.segmenttree;

import common.PrintUtil;
import template.segmenttree.RangeMaxQueryIndex;
import template.segmenttree.SegmentTree;

/*
https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

 */
public class AliceAndBob {
    public static void main(String[] args) {
        PrintUtil.print(leftmostBuildingQueries(new int[]{6,4,8,5,2,7},
                new int[][]{
                        {0,1},{0,3},{2,4},{3,4},{2,2}
                }));
        PrintUtil.print(leftmostBuildingQueries(new int[]{5,3,8,2,6,1,4,6},
                new int[][]{
                        {0,7},{3,5},{5,2},{3,0},{1,6}
                }));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            return helper(heights,queries);
    }

    public static int[] helper(int []heights,int queries[][]){
        int n = heights.length;
        SegmentTree segmentTree = new RangeMaxQueryIndex(n, Math::max,()->-1,heights);
        segmentTree.buildSegTree(heights);
        PrintUtil.print(segmentTree.seg);
        int res[]=new int[queries.length];
        int index=0;
        for(int i=0;i<queries.length;i++){
            int minIdx = Math.min(queries[i][0],queries[i][1]);
            int maxIdx = Math.max(queries[i][0],queries[i][1]);
//            System.out.println(minIdx+"  <always select right side index>  "+maxIdx);
            if(minIdx == maxIdx){
                res[i]=minIdx;
                continue;
            }else if( heights[minIdx] < heights[maxIdx]){
                res[i]=maxIdx;
                continue;
            }
            int l = maxIdx+1;
            int r = n-1;
            int resIdx = Integer.MAX_VALUE;
            while(l <= r){
                int mid = l + (r-l)/2;
                int idx = segmentTree.query(l,mid);

                if(heights[idx] > Math.max(heights[minIdx],heights[maxIdx])){
                    resIdx = Math.min(resIdx,idx);
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            res[i]= resIdx == Integer.MAX_VALUE ? -1: resIdx;
        }
        return res;
    }
}

