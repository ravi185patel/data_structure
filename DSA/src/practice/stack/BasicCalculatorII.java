package practice.stack;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        Stack<Integer> steps = new Stack<>();
        int nos=0;
        int sign =1;
        char op='+';
        int result=0,index=0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                nos = nos*10+(int)(c-'0');
            }
            if(!Character.isDigit(c) || s.length()-1 == index ){
                if(op == '+') steps.add(nos);
                if(op == '-') steps.add(-1*nos);
                if(op == '*') steps.add(steps.pop()*nos);
                if(op == '/') steps.add(steps.pop()/nos);

                nos = 0;
                op = c;
            }
        }

        while(!steps.isEmpty()){
            result +=steps.pop();
        }
        return result;
    }
}
