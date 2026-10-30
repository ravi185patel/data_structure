package template.recursion;

public class BinaryRecursionOrIncludeExclude {
    public static void main(String[] args) {

    }

    public static Object solve(Object object){
        if(object == null){ // baseCase;
            return null;// baseAns;
        }

        Object left = solve(object);
        Object right = solve(object);
        return left; // operation(left,right);
    }

}
