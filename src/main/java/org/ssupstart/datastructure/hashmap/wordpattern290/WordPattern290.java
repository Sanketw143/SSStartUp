package org.ssupstart.datastructure.hashmap.wordpattern290;

//Given a pattern and a string s, find if s follows the same pattern.
//Here follow means a full match, such that there is a
//bijection between a letter in pattern and a non-empty word in s. Specifically:
//
//Each letter in pattern maps to exactly one unique word in s.
//Each unique word in s maps to exactly one letter in pattern.
//No two letters map to the same word, and no two words map to the same letter.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordPattern290 {
    public static void main(String[] args) {
        boolean result = wordPattern("abba", "dog cat cat dog");
        System.out.println(result);
    }

//    Input: pattern = "abba", s = "dog cat cat dog"
//    Output: true
//    Explanation:
//    The bijection can be established as:
//            'a' maps to "dog".
//            'b' maps to "cat".

//    Input: pattern = "abba", s = "dog cat cat fish"
//    Output: false

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charStringMap = new HashMap<>();
        String[] split = s.split(" ");
        char[] charArray = pattern.toCharArray();
        if(charArray.length != split.length) {
            return false;
        }

        for(int i=0; i<charArray.length; i++) {
            if(charStringMap.containsKey(charArray[i])) {
                if(!charStringMap.get(charArray[i]).equals(split[i])){
                    return false;
                }
            } else if(charStringMap.containsValue(split[i])) {
                return false;
            } else {
                charStringMap.put(charArray[i], split[i]);
            }
        }
        return true;
    }



//    String[] splitWords = s.split(" ");
//    char[] charArray = pattern.toCharArray();
//        if(splitWords.length != charArray.length) {
//        return false;
//    }
//    long count = Arrays.stream(splitWords).distinct().count();
//    HashSet<Character> charSet = new HashSet<>();
//        for(char c : charArray) {
//        charSet.add(c);
//    }
//        if(charSet.size() == count)
//            return true;
//        return false;
}
