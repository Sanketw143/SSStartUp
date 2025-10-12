package org.ssupstart.datastructure.hashmap.validanagram242;


//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

import java.util.HashMap;

public class ValidAnagram242 {

    public static void main(String[] args) {
        //boolean result = isAnagram();
    }

//    Example 1:
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//
//    Example 2:
//    Input: s = "rat", t = "car"
//    Output: false
    public static boolean isAnagram(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArrayTwo = t.toCharArray();
        HashMap<Character,Integer> charAndCount = new HashMap<>();

        for (char c : charArray) {
            if(charAndCount.containsKey(c)) {
                charAndCount.put(c, charAndCount.getOrDefault(c,0)+1);
            } else {
                charAndCount.put(c, 1);
            }
        }
        for (char c : charArrayTwo) {
            if(!charAndCount.containsKey(c))
                return false;
            else if (charAndCount.containsKey(c)) {
                charAndCount.put(c, charAndCount.getOrDefault(c,0)-1);
                if(charAndCount.get(c) == 0) {
                    charAndCount.remove(c);
                }
            }
        }

        return charAndCount.isEmpty();
    }
}
