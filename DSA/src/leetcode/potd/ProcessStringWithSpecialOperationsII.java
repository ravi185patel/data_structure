package leetcode.potd;

public class ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*",1));
        System.out.println(processStr("cd%#*#",3));
        System.out.println(processStr("z*#",0));
    }
    public static char processStr(String s, long k) {
//        return processStrBfs(s,k);
        return processStrGreedy(s,k);
    }

    public char processStrBfs(String s,long K){
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c == '*'){
                if(sb.length() >= 1){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(c == '#'){
                sb.append(sb.toString());
            }else if( c== '%'){
                String temp = sb.reverse().toString();
                sb.setLength(0);
                sb.append(temp);
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return sb.length() <= K ? '.':sb.charAt((int)K);
    }

    public static char processStrGreedy(String s,long K){
        long length=0;
        for(char c:s.toCharArray()){
            if(c == '*'){
                if(length > 0) {
                    length--;
                }
            }else if(c == '#'){
                length*=2;
            }else if( c== '%'){
                continue;
            }else{
                length++;
            }
        }

        if(K >= length){
            return '.';
        }

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c == '*'){
                length++;
            }else if(c == '#'){
                length = length/2;
                if(K >= length){
                    K = K - length;
                }
            }else if( c== '%'){
                K = length-K-1;
            }else{
                length--;
            }
            if(length == K){
                return c;
            }
        }
        return '.';

    }
}
