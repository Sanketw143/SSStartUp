package org.ssupstart.datastructure.twopointeralgo.palindrome;


import com.ctc.wstx.util.StringUtil;
import org.springframework.util.StringUtils;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
//Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
public class ValidPallindrome125 {
    public static void main(String[] args) {
        String s = "madams";
        String stringWithoutSpaces = StringUtils.trimAllWhitespace(s);
        StringBuilder sb = new StringBuilder();
        for(char c : stringWithoutSpaces.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        String finalString = sb.toString();
        boolean isValidPalindrome = checkPallindrome(finalString) ;
        System.out.println(isValidPalindrome);
    }

    private static boolean checkPallindrome(String finalString) {
        finalString.trim();
        String stringWithoutSpaces = StringUtils.trimAllWhitespace(finalString);
        StringBuilder sb = new StringBuilder();
        for(char c : stringWithoutSpaces.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        char[] chars = sb.toString().toLowerCase().toCharArray();

        int i=0;
        int j=chars.length-1;

        while(i<j) {
            if(chars[i] != chars[j])
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
