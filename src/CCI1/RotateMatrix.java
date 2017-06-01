package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class RotateMatrix {

    public static int[][] getInputArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter size of matrix");
        int n = sc.nextInt();
        int count=0;
        int[][] array = new int[n][n];
        System.out.println("\nInput elements of matrix");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = count++;
            }
        }
        return array;
    }

    /*
    Prints matrix
     */
    public static void printArray(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " " );
            }
            System.out.println("");
        }
    }

    /*
    Transpose of matrix
     */
    public static void transpose(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=i; j<array[0].length; j++){
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        //printArray(array);
    }

    /*
    In-place clockwise rotation of matrix according to cracking the coding interview
    O(n^2)
     */
    public static void rotateClockWise(int[][] array){
        int n = array.length;
        for(int i=0; i< n/2; i++){
            int first = i;
            int last = n-1-i;
            for( int j = first; j<last; j++){
                int offset = j-first;
                int top = array[first][j];
                array[first][j] = array[last-offset][first];
                array[last-offset][first] = array[last][last-offset];
                array[last][last-offset] = array[j][last];
                array[j][last] = top;
            }
        }
        printArray(array);
    }

    /*
   In-place anti-clockwise rotation of matrix according to cracking the coding interview
   O(n^2)
    */
    public static void rotateAntiClockWise(int[][] array){
        int n = array.length;
        for(int i=0; i< n/2; i++){
            int first = i;
            int last = n-1-i;
            for( int j = first; j<last; j++){
                int offset = j-first;
                int top = array[j][last] ;
                array[j][last] = array[last][last-offset];
                array[last][last-offset] = array[last-offset][first];
                array[last-offset][first] =  array[first][j];
                array[first][j] = top;
            }
        }
        printArray(array);
    }

    public static void swapRows(int[][] array){

        for(int i=0 , k = array.length-1; i< k; i++, k--){
            int[] temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }


//         Method 2
//        for(int i=0; i<array.length/2; i++){
//            for(int j=0; j<array[0].length; j++){
//                int temp = array[i][j];
//                array[i][j] = array[array.length-1-i][j];
//                array[array.length-1-i][j] = temp;
//            }
//        }
    }

    /*
    Another way of clockwise rotation of matrix
     */
    public static void rotateBy90ToRight(int[][] array){
        swapRows(array);
        transpose(array);
        printArray(array);
    }

    /*
    Another way of anti-clockwise rotation of matrix
     */
    public static void rotateBy90ToLeft(int[][] array){
        transpose(array);
        swapRows(array);
        printArray(array);
    }

    public static void main(String args[]){
        int[][] array = getInputArray();
        System.out.println("\nInput matrix:");
        printArray(array);

        System.out.println("\n");
        transpose(array);
        printArray(array);

        System.out.println("\n");
        swapRows(array);
        printArray(array);
//        System.out.println("\nTranspose matrix:");
//        transpose(array);
//
//        System.out.println("\nIn-place Clockwise Rotated Matrix:");
//        rotateClockWise(array);
//
//        //Gives original array on clockwise rotated array
//        System.out.println("\nAnti-Clockwise Rotated Matrix:");
//        rotateAntiClockWise(array);
//
//        System.out.println("\nClockwise rotation by swapping rows:");
//        rotateBy90ToRight(array);
//
//        System.out.println("\nClockwise rotation by swapping rows:");
//        rotateBy90ToLeft(array);
    }
}
