package practice.segmenttree;

import java.util.Arrays;

class FruitsBasketSegTree{
    public int seg[];
    public int lazy[];
    public int baskets[];
    public int size;

    public FruitsBasketSegTree(int size) {
        this.seg = new int[4*size];
        this.lazy = new int[4*size];
        this.size = size;
    }

    public void buildTree(int baskets[]){
        this.baskets = baskets;
        buildTree(0,0,size-1,baskets);
    }

    public void buildTree(int index,int l,int r,int baskets[]){
        if(l == r){
            seg[index] = baskets[l]; // need to store value max as root
            return;
        }

        int mid = l + (r - l)/2;
        buildTree(2*index+1,l,mid,baskets);
        buildTree(2*index+2,mid+1,r,baskets);
        seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
    }

    public boolean query(int value){
        return query(0,0,size-1,value);
    }
    public boolean query(int index,int l,int r, int value){
        if(seg[index] < value){
            return false;
        }
        if(l == r){
            seg[index]=-1;
            return true;
        }

        int mid = l + (r -l)/2;
        boolean placed=false;
        if(seg[2*index+1] >= value){
            placed= query(2*index+1,l,mid,value);
        }else{
            placed= query(2*index+2,mid+1,r,value);
        }
        seg[index]=Math.max(seg[index*2+1],seg[index*2+2]);
        return placed;
    }
}
public class FruitsBasketIII {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4,2,5},new int[]{3,5,4}));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        FruitsBasketSegTree fruitsBasketSegTree = new FruitsBasketSegTree(baskets.length);

        int n = fruits.length;

        // Build segment tree
        fruitsBasketSegTree.buildTree(baskets);
        System.out.println(Arrays.toString(fruitsBasketSegTree.seg));
        int unplaced = 0;
        for (int fruit : fruits) {
            if (!fruitsBasketSegTree.query(fruit)) {
                unplaced++;
            }
        }

        return unplaced;
    }



}
