package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class URLify {

    public static void insertMod20(char[] url, int n){
        int count = 0;
        for(int i=0; i<n; i++){
            if(url[i] == ' '){
                count++;
            }
        }
        int len = n + count*2;

        System.out.print(n+ "  " +count + "  " +len + "  ");

        //inserting %20 in place of spaces
        for(int i = n-1; i>=0; i--) {
            if (url[i] == ' ') {
                url[len-1] = '0';
                url[len-2] = '2';
                url[len-3] = '%';
                len = len-3;
            } else {
                url[len-1] = url[i];
                len = len-1;
            }
        }
        System.out.println(url);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = "happy birthday to you      ";
        char[] charArray = s.toCharArray();
        insertMod20(charArray, 21);
    }
}
