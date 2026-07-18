package practice.binarysearch;

public class SqrtOfN {
    public static void main(String[] args) {
        int n =28;
        int ans=0;
        for(int i=1;i<n;i++){
            if(i*i <= n){
                ans=i;
            }
        }
        System.out.println(ans);
        ans=0;
        for(int i=1;i*i<n;i++){
            if(i <= n){
                ans=i;
            }
        }
        System.out.println(ans);
        System.out.println(bs(28));
        System.out.println(bs(16));

    }

    /*
      low-->         <--high
      p p p p p np np np np
      Low move towards not possible element and high move towards to possible
      so when condition got terminated high point to ans (possible)

     */
    public static int bs(int n){
        int start=1,end=n;
        int ans=0;
        while(start <= end){
            int mid= start + (end - start)/2;
            if(mid*mid <= n){
                ans = mid;//Math.max(ans,mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}
