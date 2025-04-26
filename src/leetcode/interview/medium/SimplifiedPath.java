package leetcode.interview.medium;

import java.util.Stack;

public class SimplifiedPath {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("/");

        String[] ss = path.split("/");

        for (String s : ss) {
            if ("..".equals(s))
                if (!stack.isEmpty())
                    stack.pop();
            if (!"".equals(s) && !"..".equals(s) && !".".equals(s))
                    stack.push(s);
        }

        if (stack.isEmpty())
            return sb.toString();

        for (String s : stack.stream().toList())
            sb.append(s).append('/');

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {

        String path1 = "/home/user/Documents/../Pictures//test/";
        String path2 = "/home/";

        System.out.println(simplifyPath(path2));

    }
}
