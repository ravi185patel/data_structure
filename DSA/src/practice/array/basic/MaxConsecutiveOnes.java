package practice.array.basic;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOne(new int[]{1,1,1,1,0,0,0,1,1,1,1,1}));
    }

    public static int findMaxConsecutiveOne(int nums[]){
        int count=0,max=0;
        for(int no:nums){
            if(no == 0){
                count=0;
            }else{
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}

