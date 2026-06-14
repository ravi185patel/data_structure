package template.segmenttree;

import common.PrintUtil;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RangeMaxQueryIndex extends SegmentTree{

    public int nums[];
    public RangeMaxQueryIndex(int size, BiFunction<Integer, Integer, Integer> ops, Supplier<Integer> supplier,int[]nums) {
        super(size, ops, supplier);
        this.nums= nums;
    }

    public void buildSegTree(int nums[], int i, int l, int r){
        if(l == r){
            seg[i]=l;
            return ;
        }
        int mid = l + (r-l)/2;
        buildSegTree(nums,2*i+1,l,mid);
        buildSegTree(nums,2*i+2,mid+1,r);
        int leftMaxIndex = seg[2*i+1];
        int rightMaxIndex = seg[2*i+2];
        if(nums[leftMaxIndex] >= nums[rightMaxIndex]){
            seg[i]=leftMaxIndex;
        }else{
            seg[i] = rightMaxIndex;
        }
    }

    public int query(int start,int end){
        return query(0,0,size-1,start,end);
    }
    public int query(int i,int l,int r,int start,int end){
        if(l > end || r < start ){
            return supplier.get();
        }
        if(l >= start && r <= end){
            return seg[i];
        }

        int mid = l + (r-l)/2;
        int leftMax = query(2*i+1,l,mid,start,end);
        int rightMax = query(2*i+2,mid+1,r,start,end);  // same code ( find max value from bst or binary tree)
        if(leftMax == -1 ) return rightMax;
        else if(rightMax == -1) return leftMax;
        if(nums[leftMax] >= nums[rightMax]){
            return leftMax;
        }else{
            return rightMax;
        }
    }

    public void update(int index,int value){
        updateIndex(index,0,0,size-1,value);
    }
    public int updateIndex(int index,int i,int l,int r,int value){
        if(l == r){
            nums[index]=value;
            seg[i]=index;
            return index;
        }

        int mid = l + (r-l)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        if(mid >= index) {
            leftMax = updateIndex(index,2 * i + 1, l, mid, value);
            rightMax = seg[2*i+2]; // if visit left then right should be same no changes
            //               root
            //(changed) left      right(unchanged)
             /*
                             Parent
                           /      \
                     Update Here   No Change
                        ↓             ↓
                   updateIndex()    seg[right]
             */
        }else {
            leftMax = seg[2*i+1];
            rightMax = updateIndex(index,2 * i + 2, mid + 1, r, value);
            //                 root
            //(unchanged) left      right(changed)
            /*
                            Parent
                           /      \
                     No Change    Update Here
                        ↓             ↓
                    seg[left]     updateIndex()
             */
        }

        if(nums[leftMax] >= nums[rightMax]){
            seg[i] = leftMax;
        }else{
            seg[i] = rightMax;
        }
        return seg[i];
    }

    public static void main(String[] args) {
//        int nums[]={1,2,3,4};
//        int queries[]={0,2,2,3};
        int nums[]={11, 3, 7, 5, 9, 1};
        int queries[][]={
                {0,2,1},
                {3,17,-1},
                {0,5,1},
        };
        int size = nums.length;
        BiFunction<Integer,Integer,Integer> maxOp = Integer::max;
        Supplier<Integer> supplier = ()-> -1;
        SegmentTree segmentTree= new RangeMaxQueryIndex(size,maxOp,supplier,nums);
        segmentTree.buildSegTree(nums);
        PrintUtil.print(segmentTree.seg);
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int ops = queries[i][2];
            if(ops == -1){
                segmentTree.update(start,end); // need to check because now need to store index
            }else {
                int index = segmentTree.query(start, end);
                System.out.println(start + " <> " + end + " <> " + (index >= 0 && index < size ? nums[index] : -1));
            }
        }

    }
}
