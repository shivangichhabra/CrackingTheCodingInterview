package CCI1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class IsUnique {

    /*
        ASCII unique chars 128
        Can be implement for Unicode as well with 65536 unique chars
        Space O(n)
        Time O(n)
     */

    public static boolean uniqueASCII(String str){
        boolean hash[] = new boolean[128];
        if(str.length() > 128){
            return false;
        }

        for(int i=0; i<str.length(); i++){
            int value = str.toLowerCase().charAt(i);
            if(hash[value]){
                //System.out.println(str.toLowerCase().charAt(i) + " is first repeated character in the string.");
                return false;
            }
            hash[value] = true;
        }
        return true;
    }

    /*
    Using bitvector
    Space O(1)
    Time O(n)
     */
    public static boolean uniqueBitvector(String str){
        int bit = 0;
        for(int i=0; i<str.length(); i++){
            int value = str.toLowerCase().charAt(i) - 'a';
            if ((bit &(1<<value)) > 0) {
                return false;
            }
            bit |= 1<<value;
        }
        return true;
    }

    /*
    Comparing chars
    Space O(1)
    Time O(n^2)
     */
    public static boolean uniqueCompareChars(String str){
        for(int i=0; i<str.length()-1; i++){
            for(int j = i+1; j< str.length(); j++){
                if(str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Using sort
    Space O(1)
    Time O(n log n)
     */
    public static boolean uniqueSortChars(String str){
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        System.out.println(strChars);
        for(int i=0; i<strChars.length-1; i++){
            System.out.println(strChars[i] + "  " + strChars [i+1] );
            if(strChars[i] == strChars [i+1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 0 to exit");
        String s = sc.next();
        System.out.println(uniqueASCII(s));
        System.out.println(uniqueBitvector(s));
        System.out.println(uniqueCompareChars(s));
        System.out.println(uniqueSortChars(s));
    }
}
