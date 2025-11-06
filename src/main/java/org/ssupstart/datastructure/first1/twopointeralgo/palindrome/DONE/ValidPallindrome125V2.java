package org.ssupstart.datastructure.first1.twopointeralgo.palindrome.DONE;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
//Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
public class ValidPallindrome125V2 {
    public static void main(String[] args) {
        String formattedString = formattedString("race a car");
        boolean isPalindrome = validPalindrome(formattedString);
        System.out.println(isPalindrome);
    }

    private static boolean validPalindrome(String formattedString) {
        int start = 0;
        int end = formattedString.length()-1;

        while(start<=end) {
            char [] charArr = formattedString.toCharArray();
            if(charArr[start] != charArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static String formattedString(String input) {
        String loweCase = input.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char c : loweCase.toCharArray()) {
            if(Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
