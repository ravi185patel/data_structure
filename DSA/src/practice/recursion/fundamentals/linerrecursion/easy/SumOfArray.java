package practice.recursion.fundamentals.linerrecursion.easy;

public class SumOfArray {
    public static void main(String[] args) {
        System.out.println(sumOfArray(0,new int[]{1,2,3,4,5}));
    }

    public static int sumOfArray(int index,int arr[]){
        if(index == arr.length){
            return 0;
        }
        return arr[index] + sumOfArray(index+1,arr);
    }
}
