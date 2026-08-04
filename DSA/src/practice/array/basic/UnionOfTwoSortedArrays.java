package practice.array.basic;

import common.PrintUtil;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        PrintUtil.print(unionOfTwoSortedArray(new int[]{1,2,3,4,5}, new int[]{2,3,4,4,5}));
        PrintUtil.print(unionOfTwoSortedArray(new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{2,3,4,4,5,11,12}));
    }

    public static int[] unionOfTwoSortedArray(int arr1[],int arr2[]){
        int length = arr1.length + arr2.length;
        int res[]=new int[length];
        int index1 = 0,index2=0,resIndex=0;
        while(index1 < arr1.length && index2 < arr2.length){
            if(arr1[index1] <= arr2[index2]){
                res[resIndex]=arr1[index1];
                index1++;
            }else{
                res[resIndex]=arr2[index2];
                index2++;
            }
            resIndex++;
        }
        while(index1 < arr1.length){
            res[resIndex]=arr1[index1];
            index1++;
            resIndex++;
        }

        while(index2 < arr2.length){
            res[resIndex]=arr2[index2];
            index2++;
            resIndex++;
        }
        return res;
    }
}
