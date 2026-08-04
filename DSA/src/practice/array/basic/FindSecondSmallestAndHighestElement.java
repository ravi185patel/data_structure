package practice.array.basic;

import java.util.Arrays;

public class FindSecondSmallestAndHighestElement{

  public static void main(String args[]){
	System.out.println(Arrays.toString(findSecondSmallestAndHighestElement(new int[]{1,2,3,4,5,6})));
	System.out.println(Arrays.toString(findSecondSmallestAndHighestElement(new int[]{5,2,4,1,2,5,7})));

	System.out.println(Arrays.toString(findSecondSmallestAndHighestElement1(new int[]{1,2,3,4,5,6})));
	System.out.println(Arrays.toString(findSecondSmallestAndHighestElement1(new int[]{5,2,4,1,2,5,7})));
  }
  
  public static int[] findSecondSmallestAndHighestElement1(int nums[]){
	Arrays.sort(nums);
	int n = nums.length;
	int smallest = -1,highest = -1;
	for(int i=1;i<=n-1;i++){
		
		if(smallest == -1 && nums[i-1] <nums[i]){
			smallest = nums[i];
		}
		
		if(highest == -1 && nums[n-i-1] < nums[n-i]){
			highest = nums[n-i-1];
		}
	}
	return new int[]{smallest,highest};
  }
  public static int[] findSecondSmallestAndHighestElement(int nums[]){
		int smallest=Integer.MAX_VALUE,nextSmallest=-1,highest=Integer.MIN_VALUE,nextHighest=-1;
		for(int i:nums){
			if(smallest > i){
				nextSmallest = smallest;
				smallest = i;
			}else if(nextSmallest > i){
				nextSmallest = i;
			}
			
			if(highest < i){
				nextHighest = highest;
				highest = i;
			}else if(nextHighest < i){
				nextHighest =  i;
			}
		}
		
		return new int[]{nextSmallest,nextHighest};
  }
}