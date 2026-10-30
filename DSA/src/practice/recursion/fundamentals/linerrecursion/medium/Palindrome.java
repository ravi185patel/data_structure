package practice.recursion.fundamentals.linerrecursion.medium;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("xyzy"));
        System.out.println(isPalindrome("yzyx"));
        System.out.println(isPalindrome("xx"));
        System.out.println(isPalindrome("x"));
    }

    public static boolean isPalindrome(String word){
        return helper(0,word.length()-1,word.toCharArray());
    }

    public static boolean helper(int start,int end,char[] wChar){
        if(start > end ) return true;
        if(wChar[start] != wChar[end]){
            return false;
        }
        return helper(start+1,end-1,wChar);

    }

}
