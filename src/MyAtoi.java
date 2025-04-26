public class MyAtoi {

    public static int myAtoi(String s) {
        s = s.trim();

        int sign = 1;
        int i = 0;
        long res = 0;

        if (s.isEmpty()) return 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < s.length()) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)) break;

            res = res * 10 + (c - '0');
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * res);
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("1337c0d3"));
    }
}
