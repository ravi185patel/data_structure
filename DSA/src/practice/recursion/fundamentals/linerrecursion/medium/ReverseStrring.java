package practice.recursion.fundamentals.linerrecursion.medium;

public class ReverseStrring {
    public static void main(String[] args) {
        System.out.println(reverseString("XYZ"));
        System.out.println(reverseString("X"));
    }

    public static String reverseString(String str){
        char chStr[] = str.toCharArray();
        reverseString(0,chStr.length-1,chStr);
        return String.valueOf(chStr);
    }

    public static void reverseString(int left,int right,char chStr[]){
        if(left >= right){
            return;
        }

        char c = chStr[left];
        chStr[left] = chStr[right];
        chStr[right]=c;
        reverseString(left+1,right-1,chStr);
    }
}
