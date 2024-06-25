public class ReverseStrings {

    public static String reverseString(String s) {

        StringBuilder sb = new StringBuilder(s);

        return sb.reverse().toString();
    }

    public static String reverse2(String s){

        char[] word = s.toCharArray();
        int n = word.length;

        for(int i = 0, j=n-1; i < n/2; i++, j--) {
            char left = word[i];
            char right = word[j];

            word[i] = right;
            word[j] = left;
        }

        return new String(word);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Christianow1234"));
        System.out.println(reverse2("Christianow1234"));
    }
}
