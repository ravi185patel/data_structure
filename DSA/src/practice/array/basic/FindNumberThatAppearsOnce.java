package practice.array.basic;

public class FindNumberThatAppearsOnce {
    public static void main(String[] args) {
        System.out.println(findNumberAppearsOnce(new int[]{2,2,1}));
        System.out.println(findNumberAppearsOnce(new int[]{4,1,2,1,2}));
    }

    public static int findNumberAppearsOnce(int nums[]){
        int xor = 0;
        for(int no:nums){
            xor ^= no;
        }
        return xor;
    }
}
