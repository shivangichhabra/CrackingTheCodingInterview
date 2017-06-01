package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class ZeroMatrix {

    public static int[][] getInputArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter size of matrix");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        System.out.println("\nInput elements of matrix");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    public static void printArray(int[][] array){
        System.out.println("\n");
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void setMatrixWithZero(int[][] array) {
        boolean[] row = new boolean[array.length];
        boolean[] col = new boolean[array[0].length];
        boolean colHasZero = false;

        //first column
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //nullify row based on first column
        for (int i = 0; i < array.length; i++) {
            if (row[i]) {
                nullifyRow(array, i);
            }
        }

        //nullify column based on first row
        for (int j = 0; j < array[0].length; j++) {
            if (col[j]) {
                nullifyColumn(array, j);
            }
        }
    }

    public static void nullifyColumn(int[][] array, int col){
        for(int i=0; i<array.length ; i++){
            array[i][col] = 0;
        }
    }

    public static void nullifyRow(int[][] array, int row){
        for(int i=0; i<array[0].length ; i++){
            array[row][i] = 0;
        }
    }


    public static void main(String args[]) {
        int[][] array = getInputArray();
        System.out.println("\nInput Matrix");
        printArray(array);
        setMatrixWithZero(array);
        System.out.println("\nOutput Matrix");
        printArray(array);
    }
}
