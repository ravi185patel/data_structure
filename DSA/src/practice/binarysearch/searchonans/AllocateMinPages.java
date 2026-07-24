package practice.binarysearch.searchonans;

import java.util.Arrays;

public class AllocateMinPages {
    public static void main(String[] args) {
        System.out.println(findPages(new int[]{12, 34, 67, 90},2));
        System.out.println(findPages(new int[]{15,17,20},5));
    }

    /*
     12, 34, 67, 90
     max 90 to total = 203

     90 -> 12+34 | 67 | 90 != k
     100 -> 12+34 | 67 | 90 != k
     113 -> 12+34+76 | 90 == k ans
     BF
     TC = O(range*n)
      We are searching on ans and find out min() -> right = mid - 1;

      90,100,113,.....,203
      l         m       r
      F   F   T   T  T T  -> because lower numbers <=k true
      if(possible){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
      O(longR*n)


     */

    public static int findPages(int[] arr, int k) {
        if(arr.length <= k) return -1;
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        int ans =-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(arr,mid,k)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int arr[],int mid,int k){
        int count=1;
        int sum=0;
        for(int i:arr){
            if(sum+i >mid){
                sum=i;
                count++;
            }else{
                sum+=i;
            }
        }
        return count <=k;
    }
}

