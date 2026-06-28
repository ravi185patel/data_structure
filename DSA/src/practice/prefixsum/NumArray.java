package practice.prefixsum;

class NumArray {
    int prefixSum[];
    int length=0;
    public NumArray(int[] nums) {
        length=nums.length;
        prefixSum=new int[length+1];
        for(int i=0;i<length;i++){
            prefixSum[i+1]=nums[i]+prefixSum[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right+1]-prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */