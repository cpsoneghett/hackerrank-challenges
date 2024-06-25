package leetcode;

public class GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {

        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);

        sb1.append(str2);
        sb2.append(str1);

        if (!sb1.toString().equals(sb2.toString()))
            return "";

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }

    public static void main(String[] args) {

        //Case1
        String s1 = "ABABAB";
        String s2 = "ABA";

        System.out.println(gcdOfStrings(s1, s2));

        //Case1
        String s3 = "JAVA";
        String s4 = "TEST";

        System.out.println(gcdOfStrings(s3, s4));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
