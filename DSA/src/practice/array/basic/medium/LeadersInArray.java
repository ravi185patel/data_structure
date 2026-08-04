package practice.array.basic.medium;

import common.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeadersInArray {
    public static void main(String[] args) {
        PrintUtil.print(findLeaders(new int[]{4, 7, 1, 0}));
        PrintUtil.print(findLeaders(new int[]{10, 22, 12, 3, 0, 6}));
        PrintUtil.print(findLeaders(new int[]{1}));
        PrintUtil.print(findLeaders(new int[]{1,2,3}));
        PrintUtil.print(findLeaders(new int[]{3,2,1}));
    }

    public static int[] findLeaders(int nums[]){
//        return findLeaders1(nums);
        return findLeadersOpt(nums);
    }

    public static int[] findLeaders1(int nums[]){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            stack.push(i);
        }

        int res[]=new int[stack.size()];
        int index=stack.size()-1;
        while(!stack.isEmpty()){
            res[index]=nums[stack.pop()];
            index--;
        }
        return res;
    }

    public static int[] findLeadersOpt(int nums[]){
        List<Integer> elements=new ArrayList<>();
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] > max ){
                elements.add(nums[i]);
            }
            max = Math.max(max,nums[i]);
        }

        int res[]=new int[elements.size()];
        int index=elements.size()-1;
        for(int i:elements){
            res[index]=i;
            index--;
        }
        return res;
    }
}
