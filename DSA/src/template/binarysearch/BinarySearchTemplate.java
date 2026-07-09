package template.binarysearch;


/*
Finding First and Last Occurrence

Given:

1 2 2 2 2 3 4

Target = 2

lowerBound = 1
upperBound = 5

Therefore:

First occurrence = lowerBound
Last occurrence = upperBound - 1
1 [2 2 2 2] 3 4
 ↑         ↑
 LB      UB-1

 */
public class BinarySearchTemplate {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5,5,6,7,8,8};
        System.out.println(lowerBond(nums,5));
        System.out.println(upperBond(nums,5));
        System.out.println(classBinarySearch(nums,5));
        findFirstAndLastOccurrenceOfGivenNumber(nums,5);
        System.out.println(searchInRotateArray(new int[]{3,4,5,1,2},2));
        System.out.println(searchInRotateArray(new int[]{3,4,5,1,2},5));
        System.out.println(searchInRotateArray(new int[]{3,4,5,1,2},3));

        System.out.println(searchInMatrix(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        },6));

        System.out.println(searchInMatrixDifferentSorting(new int[][]{
                {1,4,7},
                {2,5,8},
                {3,6,9}
        },3));

    }

    public static int lowerBond(int nums[],int k){
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < k)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static int upperBond(int nums[],int k){
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= k)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static int classBinarySearch(int nums[],int k){
        int start=0,end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == k){
                return mid;
            }else if(nums[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static void findFirstAndLastOccurrenceOfGivenNumber(int nums[],int k){
        int firsIndex=lowerBond(nums,k);
        int lastIndex=upperBond(nums,k)-1;
        System.out.println(firsIndex+" <> "+lastIndex);
    }

    public static int searchInRotateArray(int nums[],int k){
        int start=0,end=nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == k){
                return mid;
            }else if(nums[start] <= nums[mid]){
                if(nums[start] <= k && k <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] <= k && k <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchInMatrix(int nums[][],int k){
        int m = nums.length;
        int n = nums[0].length;
        int start=0,end = n*m-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int row = mid / m;
            int col = mid % m;
            if(nums[col][row]== k){
                System.out.println(col+" <> "+row);
                return col;
            }else if(nums[col][row] > k){
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int searchInMatrixDifferentSorting(int nums[][],int k){
        int m = nums.length;
        int n = nums[0].length;
        int row = 0,col = n-1;
        /*

        row => 0 to M -> find which row contains it
        col => 0 to N -> find place

         */
        while(row < m && col >= 0){
            if(nums[row][col] == k){
                System.out.println(row+" <> "+col);
                return col;
            }else if(nums[row][col] > k){ // when < K which means it is in higher row
                col--;
            }else{
                row++;
            }
        }
        return -1;
    }

    public static int findPick(int nums[],int k){
        return -1;
    }

    public static int takeDecisionBasedOnGreedyBS(int nums[],int k){
        return -1;
    }
}
