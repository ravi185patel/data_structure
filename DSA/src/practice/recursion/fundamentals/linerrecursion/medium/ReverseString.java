package practice.recursion.fundamentals.linerrecursion.medium;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("ravi"));
    }

    public static String reverseString(String word){
        char ch[]=word.toCharArray();
        helper(0,word.length()-1,ch);
        return String.valueOf(ch);
    }

    public static void helper(int start,int end,char ch[]){
        if(start >= end) return;
        /*char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;*/
        helper(start+1,end-1,ch);
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }
}
