package CCI1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class CheckPermutation {

    public static String sort(String s){
        char[] strChar = s.toCharArray();
        Arrays.sort(strChar);
        return new String(strChar);
    }

    /*
    Sort and Compare
    Sort O(n log n)
    //Taking space into consideration in this
    // if they does not mater, remove them ascii value of space is 32
     */
    public static boolean permuatationSortCompare(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }
        return sort(s1.toLowerCase()).equals(sort(s2.toLowerCase()));
    }

    /*
    Using hash Map
    space O(n)
    Time O(n)
     */
    public static boolean permutationHash(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }

        int hash[] = new int[128];  //ascii unique chars
        for(int i=0; i<s1.length(); i++){
            hash[s1.toLowerCase().charAt(i)]++;
        }

        for(int i=0; i<s1.length(); i++){
            hash[s1.toLowerCase().charAt(i)]--;
            if(hash[s1.toLowerCase().charAt(i)] < 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(permuatationSortCompare(s1, s2));
        System.out.println(permutationHash(s1, s2));
    }
}
