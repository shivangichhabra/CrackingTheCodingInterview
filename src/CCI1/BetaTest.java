package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 3/4/2017.
 */
public class BetaTest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        int[][] array1 = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j] = count++;
                array1[i][j] = array[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n\n");

        for(int i=0; i<n; i++){
            for(int j=i; j<m; j++){
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}