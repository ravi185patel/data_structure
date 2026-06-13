package template.segmenttree;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class SegmentTree {
    public int seg[];
    public int lazy[];
    public int size;

    public BiFunction<Integer,Integer,Integer> ops;
    public Supplier<Integer> supplier;

    public SegmentTree(int size,BiFunction<Integer,Integer,Integer> ops,Supplier<Integer> supplier){
        seg=new int[4*size];
        lazy=new int[4*size];
        this.size = size;
        this.ops = ops;
        this.supplier = supplier;
    }

    public void buildSegTree(int nums[]){
        buildSegTree(nums,0,0,size-1);
    }

    public void buildSegTree(int nums[],int i,int l,int r){
        if(l == r){
            seg[i]=nums[l];
            return ;
        }
        int mid = l + (r-l)/2;
        buildSegTree(nums,2*i+1,l,mid);
        buildSegTree(nums,2*i+2,mid+1,r);
        seg[i] = ops.apply(seg[2*i+1],seg[2*i+2]); // derive parent value based on child;
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
        return ops.apply(query(2*i+1,l,mid,start,end), query(2*i+2,mid+1,r,start,end));
    }

    public void update(int index,int value){
        update(index,0,0,size-1,value);
    }
    public void update(int index,int i,int l,int r,int value){
        if(l == r){
            seg[i]=value;
            return;
        }

        int mid = l + (r-l)/2;
        if(mid >= index) {
            update(index,2 * i + 1, l, mid, value);
        }else {
            update(index,2 * i + 2, mid + 1, r, value);
        }
        seg[i] = ops.apply(seg[2*i+1],seg[2*i+2]); // derive parent value based on child;
    }

    public void updateRange(int start,int end,int value){
        updateRange(start,end,0,0,size-1,value);
    }
    public void updateRange(int start,int end,int i,int l,int r,int value){
        if(lazy[i] != 0){
            seg[i]+=(r-l+1)*lazy[i];
            if(l!=r) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i]=0;

            return ;
        }
        if( r < start && end < l){
            return;
        }
        if(start <= l && r <= end){
            seg[i]+=(r-l+1)*value;
            if(l!=r){
                lazy[2*i+1]+=value;
                lazy[2*i+2]+=value;
            }
            return;
        }
        if(l == r){
            seg[i]=value;
            return;
        }

        int mid = l + (r-l)/2;
        updateRange(start,end,2*i+1,l,mid,value);
        updateRange(start,end,2*i+2,mid+1,end,value);
        seg[i] = ops.apply(seg[2*i+1],seg[2*i+2]); // derive parent value based on child;
    }
}
