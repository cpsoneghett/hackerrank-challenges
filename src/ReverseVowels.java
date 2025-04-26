public class ReverseVowels {

    public String reverseVowels(String s) {

        char[] word = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while(i < j) {

            if(isVowel(word[i]) && isVowel(word[j])) {
                char aux = word[i];
                word[i] = word[j];
                word[j] = aux;

                i++;
                j--;
            }
            if(!isVowel(word[i]))
                i++;
            if(!isVowel(word[j]))
                j--;
        }

        return new String(word);
    }

    public boolean isVowel2(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(c) != -1;
    }

    public static void main(String[] args) {

    }
}
