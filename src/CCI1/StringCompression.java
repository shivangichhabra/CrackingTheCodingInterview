package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class StringCompression {

    public static String compressor(String s){
        StringBuilder str = new StringBuilder();
        int count = 0;

        for(int i=0; i<s.length(); i++){
            count++;
            if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                str.append(s.charAt(i)).append(count);
                count = 0;
            }
        }
        return s.length() < str.length() ? s : str.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(compressor(s));
    }
}
