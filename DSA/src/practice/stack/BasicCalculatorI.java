package practice.stack;

import java.util.Stack;

/*
1+2 -> 1 + 2
1+(2+3)+1; -> 1 + (5) -> 5

nos = 1
+ res = 1
( res = 1  -> steps (1,1) -> res=0
2
+ = res+2
3
res = 5
) res = 5 ,res=sign*res, res+=1;


 */
public class BasicCalculatorI {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        return    calculator(s) ;
    }

    public static int calculator(String s){
        Stack<Integer> steps = new Stack<>();
        int nos =0;
        int result = 0;
        int sign = 1;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                nos = nos*10 + (int)(c-'0');
            }else{
                if(c=='+'){
                    result += (sign) *nos;
                    nos=0;
                    sign=1;
                }else if(c=='-'){
                    result += (sign) * nos;
                    nos=0;
                    sign=-1;
                }else if(c=='('){
                    steps.push(sign);
                    steps.push(result);
                    sign = 1;
                    result=0;
                }else if(c==')'){
                    result += sign*nos;
                    nos = 0;
                    result *= steps.pop();
                    result += steps.pop();
                }
            }
        }

        if(nos != 0){
            result += sign * nos;
        }
            return result;
    }

}
