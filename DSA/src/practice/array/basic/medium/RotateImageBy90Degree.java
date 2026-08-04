package practice.array.basic.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImageBy90Degree {
    public static void main(String[] args) {
        rotate(new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        });
        rotate(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        });

    }

    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n/2;i++){
            for(int j=0;j<m;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
        for(int row[]:matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
