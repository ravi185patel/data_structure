package practice.recursion.fundamentals.linerrecursion.easy;

public class WorkBeforeAfterRecursion {
    public static void main(String[] args) {
        print(2);
    }

    public static void print(int n){
        if(n ==0) {
            System.out.println("print(0)");
            return;
        }

        System.out.println("before "+n);
        print(n-1);
        System.out.println("after "+n);
    }
}
