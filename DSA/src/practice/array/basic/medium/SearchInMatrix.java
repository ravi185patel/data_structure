package practice.array.basic.medium;

public class SearchInMatrix {
    public static void main(String[] args) {
        System.out.println(findInMatrix(new int[][]{
                {1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}
        },8));

        System.out.println(findInMatrix(new int[][]{
                {1, 2, 4},{6, 7, 8},{9, 10, 34}
        },78));
    }

    public static boolean findInMatrix(int nums[][],int target) {


//        return findInMatrixOpt(nums,target);
        return findInMatrix1(nums,target);

    }
    public static boolean findInMatrixOpt(int nums[][],int target){
        int m = nums.length;
        int n = nums[0].length;
        int left = 0,right = m*n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int x= mid / n;
            int y = mid % n;
            if(nums[x][y] == target){
                return true;
            }else if(nums[x][y] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean findInMatrix1(int nums[][],int target){
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0;i<m;i++){
            if(nums[i][0] <= target && target <= nums[i][n-1] ){
                return binarySearch(0,n,nums[i],target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int left,int right,int row[],int target){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(row[mid] == target){
                return true;
            }else if(row[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
