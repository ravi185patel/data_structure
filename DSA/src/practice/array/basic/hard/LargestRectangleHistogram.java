package practice.array.basic.hard;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        System.out.println(findLargestHistogram(new int[]{2,1,5,6,2,3}));
    }

    /*

    2,1,5,6,2,3

     */

    public static int findLargestHistogram(int hieghts[]){
        return findLargestHistogramBf(hieghts);
    }

    public static int findLargestHistogramBf(int hieghts[]){
        int maxArea = 0;
        int length= hieghts.length;
        for(int i=0;i<length;i++){
            int minHeight=hieghts[i];
            for(int j=i+1;j<length;j++){
                minHeight = Math.min(minHeight,hieghts[j]);
                int area = minHeight*(j-i+1);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    public static int findLargestHistogramPrefix(int heights[]){
        int length = heights.length;
        int leftMinHeight[]=new int[length];
        int rightMinHeight[]=new int[length];

        for(int i=0;i<length;i++){

        }
        return -1;
    }

    public static int findLargestHistogramMonotonic(int heights[]){
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        for(int i=0;i<length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int start = stack.peek();
                int end = i;

            }
        }
        return -1;
    }
}
