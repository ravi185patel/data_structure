package practice.recursion.fundamentals.linerrecursion.medium;

public class RemoveAdjDuplicate {
    public static void main(String[] args) {
        System.out.println(removeAdjDuplicate("abbbdcdd"));
        System.out.println(removeAdjDuplicate("acc"));
        System.out.println(removeAdjDuplicate("aac"));
        System.out.println(removeAdjDuplicate("aadnnc"));
    }

    public static String removeAdjDuplicate(String word){
        char chStr[] = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        removeAdjDuplicate(0,chStr,sb);
        return sb.toString();
    }

    public static void removeAdjDuplicate(int index,char chStr[],StringBuilder sb){
        if(index == chStr.length){
            return ;
        }

        /*int next = index;
        while(next+1 < chStr.length && chStr[index] == chStr[next+1]){
            next++;
        }
        if(next < chStr.length) {
            sb.append(chStr[next]);
        }*/
        sb.append(chStr[index]);
        int next = index+1;
        while(next < chStr.length && chStr[index] == chStr[next]){
            next++;
        }
        removeAdjDuplicate(next,chStr,sb);
    }
}
