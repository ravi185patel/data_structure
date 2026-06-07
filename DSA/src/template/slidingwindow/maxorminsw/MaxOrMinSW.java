package template.slidingwindow.maxorminsw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxOrMinSW {
    Deque<Integer> deque = new ArrayDeque<>();

    int []ans;

    int index;

    public MaxOrMinSW(){
    }

    public int[] findMaxSw(int []nums,int k){
        deque.clear();
        ans=new int[nums.length-k+1];
        index =0;
        for(int i=0;i<nums.length;i++){

            // shrink sliding window.
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= i-k){
                deque.removeFirst();
            }

            // remove lower elements from queue based on current elements. <= unique
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);

            if(i >= k-1){
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public int[] findMinSw(int []nums,int k){
        deque.clear();
        ans=new int[nums.length-k+1];
        index =0;
        for(int i=0;i<nums.length;i++){

            // shrink sliding window.
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= i-k){
                deque.removeFirst();
            }

            // remove lower elements from queue based on current elements. <= unique
            while(!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);

            if(i >= k-1){
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxOrMinSW maxOrMinSW = new MaxOrMinSW();
        int nums[]={1,2,3,4,5,6};
        int ans[] = maxOrMinSW.findMaxSw(nums,3);
        System.out.println(Arrays.toString(ans));
        ans = maxOrMinSW.findMinSw(nums,3);
        System.out.println(Arrays.toString(ans));

    }
}
