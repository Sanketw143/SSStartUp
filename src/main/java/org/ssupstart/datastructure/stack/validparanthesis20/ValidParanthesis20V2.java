package org.ssupstart.datastructure.stack.validparanthesis20;

import java.util.Stack;

public class ValidParanthesis20V2 {
    public static void main(String[] args) {
        String s = "]";
        boolean result = isValidParanthesis(s);
        System.out.println(result);
    }

    private static boolean isValidParanthesis(String s) {
        Stack<Character> stack = new Stack<>();

        // stackValue => )
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push('}');
            } else if(!stack.isEmpty() && stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
