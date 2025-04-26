package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if (s.length() <= 1)
            return s;

        char[] chars = s.toCharArray();
        char[] ans = new char[chars.length];

        if (numRows == 2) {

            for (int i = 0; i < s.length() / 2; i++)
                ans[i] = chars[i * 2];


            for (int i = 0; i < s.length(); i++)
                ans[i + (s.length() / 2)] = chars[i + 1];


        } else {
            ans[0] = chars[0];

            for (int i = 1; i < chars.length; i++) {

            }
        }

        return new String(ans);
    }

    public static String convert2(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        HashMap<Integer, StringBuilder> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int ref = 0;
        boolean back = false;

        for (int i = 0; i < numRows; i++)
            map.put(i, new StringBuilder());

        for (int i = 0; i < s.length(); i++) {

            map.get(ref).append(s.charAt(i));

            if (back)
                ref--;
            else
                ref++;

            if (ref == numRows - 1)
                back = true;
            else if (ref == 0 && back)
                back = false;
        }

        for (StringBuilder ss : map.values())
            sb.append(ss);

        return sb.toString();
    }

    public static String convert3(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            if (currentRow == 0 || currentRow == numRows - 1)
                goingDown = !goingDown;

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        //System.out.println(convert2(s, 3));
        System.out.println(convert3(s, 2));
    }
}
