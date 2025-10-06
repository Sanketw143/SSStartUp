package org.ssupstart.datastructure.slidingwindow.substring3;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;


//Given a string s, find the length of the longest substring without duplicate characters.
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
@Slf4j
public class LongestSubString3 {
    public static void main(String[] args) {
        int subStringLength = longestSubString("qrsvbspk");
        System.out.println(subStringLength);
    }

    private static int longestSubString(String string) {
        int left = 0;
        int right =0;

        char[] chars = string.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxDistinct = 0;
        while(right<chars.length) {
            while(set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            maxDistinct = Math.max(maxDistinct,set.size());
            right++;
        }
        return maxDistinct;
    }
}
