package practice.array.basic;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{8, 2, 4, 5, 3, 7, 1}));
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 5}));

        System.out.println(findMissingNumberHashing(new int[]{8, 2, 4, 5, 3, 7, 1}));
        System.out.println(findMissingNumberHashing(new int[]{1, 2, 3, 5}));

        System.out.println(findMissingNumberXor(new int[]{8, 2, 4, 5, 3, 7, 1}));
        System.out.println(findMissingNumberXor(new int[]{1, 2, 3, 5}));

        System.out.println(findMissingNumberFormula(new int[]{8, 2, 4, 5, 3, 7, 1}));
        System.out.println(findMissingNumberFormula(new int[]{1, 2, 3, 5}));
    }

    public static int findMissingNumber(int nums[]){
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        for(int i=1;i<=n;i++){
            int no = i;
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(no == nums[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return no;
            }
        }
        return -1;
    }

    public static int findMissingNumberHashing(int nums[]){
//        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int temp[]=new int[n+1];
        for(int i:nums){
//            set.add(i);
            if(i >= n){
                continue;
            }
            temp[i]++;
        }
        for(int i=1;i<=n;i++){
//            if(!set.contains(i)){
//                return i;
//            }
            if(temp[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static int findMissingNumberXor(int nums[]){
        int xor=0,iXor=0;
        int n = nums.length;
        for(int i:nums){
            xor ^= i;
        }
        for(int i=1;i<=n+1;i++){ // we are consider 1 to n not 0 to n so we take 1 to n+1
            iXor ^= i;
        }
        return xor^iXor;
    }

    public static int findMissingNumberFormula(int nums[]){
        int n = nums.length + 1;
        int total = n * (n+1)/2;
        for(int i:nums){
            total -= i;
        }
        return total;
    }
}
