package practice.array.basic;

public class CheckArrayIsSorted{

	public static void main(String args[]){
		System.out.println(isArraySortedBf(new int[]{1,2,3,4,5}));
		System.out.println(isArraySortedBf(new int[]{1,2,3,5,4}));
		System.out.println(isArraySortedBf(new int[]{1,5,8,9}));
		
		System.out.println(isArraySorted(new int[]{1,2,3,4,5}));
		System.out.println(isArraySorted(new int[]{1,2,3,5,4}));
		System.out.println(isArraySorted(new int[]{1,5,8,9}));
	}
	
	public static boolean isArraySortedBf(int nums[]){
		int n = nums.length;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
			
				if(nums[i] > nums[j]){
						return false;
				}
				
			}
		}
		return true;
	}
	
	public static boolean isArraySorted(int nums[]){
		int n = nums.length;
		for(int i=1;i<n;i++){
			
			if(nums[i-1] > nums[i]){
				return false;
			}
		}
		return true;
	}
}