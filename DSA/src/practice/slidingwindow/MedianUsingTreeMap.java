package practice.slidingwindow;

import java.util.Arrays;
import java.util.TreeMap;

class MedianUsingTreeMap{
	
	public TreeMap<Integer,Integer> left = new TreeMap<>();
	public TreeMap<Integer,Integer> right = new TreeMap<>();
	
	int leftSize=0;
	int rightSize=0;

	/*
		add on left side => if left is empty or element <= left.lastKey();
		add on right side => if above both failed
	*/
	public void insert(int element){
		if(leftSize == 0 || element <= left.lastKey()){
			add(left,element);
			leftSize++;
		}else{
			add(right,element);
			rightSize++;
		}
		balance();
		// possible any one of side got in balanced or size difference more than 1
	}
	
	public void remove(int element){
		if(left.containsKey(element)){
			remove(left,element);
			leftSize--;
		}else{
			remove(right,element);
			rightSize--;
		}
		
		balance();
	}
	
	// balance
	/* 
		left side should have one more element compare to right side.
	*/
	
	public void balance(){
		
		while(leftSize > rightSize+1){
			int element = left.lastKey();
			remove(left,element);
			leftSize--;
			
			add(right,element);
			rightSize++;
		}
		
		
		while(leftSize < rightSize){
			int element = right.firstKey();
			remove(right,element);
			rightSize--;
			
			add(left,element);
			leftSize++;	
		}
	}
	
	public void add(TreeMap<Integer,Integer> map,int element){
		map.put(element,map.getOrDefault(element,0)+1);
	}
	
	public void remove(TreeMap<Integer,Integer> map, int element){
		int freq = map.get(element);
		if(freq == 1){
			map.remove(element);
		}else{
			map.put(element,map.getOrDefault(element,0)-1);
		}
	}
	
	public int findMedian(){
		return left.lastKey();
	}
	
	public static void main(String args[]){
		int nums[]={1,2,1,4,3,2,5,7};
		int k=3;
		MedianUsingTreeMap obj = new MedianUsingTreeMap();
		for(int i=0;i<k;i++){
			obj.insert(nums[i]);
		}
		int ans[]=new int[nums.length-k+1];
		ans[0]=obj.findMedian();
		for(int i=k;i<nums.length;i++){
			obj.remove(nums[i-k]);
			obj.insert(nums[i]);
			ans[i-k+1] = obj.findMedian();
		}
		System.out.println(Arrays.toString(ans));
	}
}