package leetcode;

public class GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int remainder = 0;

        while (n2 > 0) {
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
            remainder = n1;
        }

        return "";
    }

    public static void main(String[] args) {

        //Case1
        String s1 = "ABABAB";
        String s2 = "ABAB";

        System.out.println(gcdOfStrings(s1, s2));

        //Case1
        String s3 = "JAVA";
        String s4 = "TEST";

        System.out.println(gcdOfStrings(s3, s4));
    }
}
