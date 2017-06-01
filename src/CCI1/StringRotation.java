package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class StringRotation {

    public static boolean isSubstring(String s1, String s2){
        //return s1.contains(s2); //method1
        //return s1.indexOf(s2) > 0; //method2
        //method3
        if(s1.length() >= s2.length()){
            if(s1.equals(s2)){
                return true;
            }

            for(int i=0; i<s1.length(); i++){
                if((s1.substring(i, (i+s2.length()))).equals(s2)){
                    return true;
                }
            }
        }
        return false;
    }


    /*
    Not considering isSubtring in this
    Space O(1)
    Time O(n)
     */
    public static boolean checkRotation(String s1, String s2){
        if(s1.length() == s2.length() && s1.length() > 0){
            String str = s1+s1;
            return isSubstring(str, s2);
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(checkRotation(s1,s2));
    }
}
