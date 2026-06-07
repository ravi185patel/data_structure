package template.heap;

import template.slidingwindow.maxorminsw.MaxOrMinSW;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxOrMinHeap {
    public PriorityQueue<Integer> pq;

    /*

     */
    public int[] findTopK(int nums[],int k){ // top max
        pq = new PriorityQueue<>(); // max -> minHeap -> peek will be smallest = smallest -> highest
        for(int ele:nums){
            pq.add(ele);
            if(pq.size() > k){
                pq.remove();
            }
        }

        int ans[]=new int[k+1];
        int index=0;
        while(!pq.isEmpty()){
            ans[index++]=pq.poll();
        }
        return ans;
    }

    public int[] findMin(int nums[],int k){
        pq = new PriorityQueue<>(Collections.reverseOrder()); // min -> maxHeap -> peek will be highest = highest -> smallest
        for(int ele:nums){
            pq.add(ele);
            if(pq.size() > k){
                pq.remove();
            }
        }

        int ans[]=new int[k+1];
        int index=0;
        while(!pq.isEmpty()){
            ans[index++]=pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,3,2,4};
        MaxOrMinSW maxOrMinSW = new MaxOrMinSW();
        System.out.println(" max :- "+ Arrays.toString(maxOrMinSW.findMaxSw(nums,2)));
        System.out.println(" min :- "+ Arrays.toString(maxOrMinSW.findMinSw(nums,2)));
    }
}
