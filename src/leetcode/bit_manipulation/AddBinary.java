package leetcode.bit_manipulation;

public class AddBinary {

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int overflow = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || overflow == 1) {
            if (i >= 0)
                overflow += a.charAt(i--) - '0';
            if (j >= 0)
                overflow += b.charAt(j--) - '0';

            sb.append(overflow % 2);
            overflow /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1101";

        System.out.println(addBinary(a, b));
    }
}
