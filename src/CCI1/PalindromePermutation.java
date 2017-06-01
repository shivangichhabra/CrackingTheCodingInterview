package CCI1;

import java.util.Scanner;

/**
 * Created by Shivangi on 12/18/2016.
 */
public class PalindromePermutation {

    /*
    Number of odd char can be at max = 1
    Using hashTable
    Time O(n)
    Space O(n)
     */
    public static boolean isPermutationOfPalindromeHash(String s){
        int countOdd = 0;
        int[] hash = new int[128];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                int x = s.toLowerCase().charAt(i);
                hash[x]++;
                if(hash[x] % 2 == 1) {
                    countOdd++;
                }else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    /*
    Using bitVector
    Space O(1)
    Time O(n)
     */
    public static boolean isPermutationOfPalindromeBitVector(String s){
        int bit = 0;
        int countOdd = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                int x = s.toLowerCase().charAt(i);
                if((bit & (1 << x)) == 0){
                    bit |= (1 << x);
                }else {
                   bit &= ~(1 << x);
                }
            }
        }
        return (bit & (bit-1)) == 0 ;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPermutationOfPalindromeHash(s));
        System.out.println(isPermutationOfPalindromeBitVector(s));
    }
}
