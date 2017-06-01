package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 * check if second string is one step away from first string.
 * Step could be 1. Insert 2. Replace 3. Delete.
 */

public class OneAway {
    /*
    My way
     */
    public static boolean InsertReplaceDelete(String s1, String s2){
        boolean foundOne = false;
        for(int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundOne) {
                    return false;
                }
                foundOne = true;
                if(s1.length() != s2.length()){
                    i++;
                }
            }
        }
        return true;
    }

    public static boolean TestStringOneAway(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1){
            System.out.println("\nDifference in length > 1.\n");
            return false;
        }

        if(s1.length() > s2.length()){
            return InsertReplaceDelete(s2,s1);
        }
        return InsertReplaceDelete(s1,s2);
    }

    public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(TestStringOneAway(s1, s2));
    }
}
