package org.ssupstart.datastructure.stack.validparanthesis20;

import java.util.Stack;

public class ValidParanthesis20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result);
    }

    //()[]{}
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                charStack.push(')');
            } else if(c == '[') {
                charStack.push(']');
            } else if(c == '{') {
                charStack.push('}');
            } else if(charStack.isEmpty() || charStack.pop() != c) {
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
