package common;

import java.util.Arrays;

public class PrintUtil {
    public static void print(int value[]){
        System.out.println(Arrays.toString(value));
    }
    public static void print(long value[]){
        System.out.println(Arrays.toString(value));
    }
    public static void print(boolean value[]){
        System.out.println(Arrays.toString(value));
    }
    public static void print(float value[]){
        System.out.println(Arrays.toString(value));
    }
    public static void print(double value[]){
        System.out.println(Arrays.toString(value));
    }

    public static void print(int [][]matrix){
        for(int row[]:matrix){
            print(row);
        }
    }

}
