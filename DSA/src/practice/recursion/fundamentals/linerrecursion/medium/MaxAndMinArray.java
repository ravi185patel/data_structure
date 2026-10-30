package practice.recursion.fundamentals.linerrecursion.medium;

public class MaxAndMinArray {
    public static void main(String[] args) {
        findMaxMin(new int[]{1,2,6,5,2,4});
    }

    record State(int max,int min){};
    public static void findMaxMin(int nums[]){
        System.out.println(findMax(0,nums));
        System.out.println(findMin(0,nums));
        State state = findMaxMinState(0,nums);
        System.out.println(state.min+" <> "+state.max);
    }

    public static State findMaxMinState(int index,int nums[]){
        if(index == nums.length){
            return new State(Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        State state = findMaxMinState(index+1,nums);
        int min = Math.min(state.min,nums[index]);
        int max = Math.max(state.max,nums[index]);
        return new State(max,min);
    }

    public static int findMax(int index,int nums[]){
        if(index == nums.length){
            return Integer.MIN_VALUE;
        }
        return Math.max(nums[index],findMax(index+1,nums));
//        int max = findMax(index+1,nums);
//        return Math.max(max,nums[index]);
    }
    public static int findMin(int index,int nums[]){
        if(index == nums.length){
            return Integer.MAX_VALUE;
        }
        return Math.min(nums[index],findMin(index+1,nums));
//        int max = findMax(index+1,nums);
//        return Math.max(max,nums[index]);
    }
}
