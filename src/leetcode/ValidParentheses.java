package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;

        if (n % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;

                char last = stack.pop();

                if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{'))
                    return false;
            }

        }

        if (stack.isEmpty())
            return true;


        return false;
    }

}
