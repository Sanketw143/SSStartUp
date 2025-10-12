package org.ssupstart.datastructure.stack.simplifypath71;

import java.util.Stack;

public class SimplifyPath71 {
    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        String result = simplifyPath(path);
        System.out.println(result);
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String components : split) {
            if(components.equals(".") || components.equals("")) {
                continue;
            } else if(components.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(components);
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}
