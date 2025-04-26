public class StringCompression {

    public static int compress(char[] chars) {
        int n = chars.length;

        if (n < 2)
            return n;

        char ref = chars[0];
        int count = 0, i = 0;

        StringBuilder s = new StringBuilder();

        while (i < n) {
            char c = chars[i];

            if (chars[i] == ref) {
                count++;
            } else {
                s.append(ref);
                if (count > 1) s.append(count);
                count = 0;
                ref = c;
                i--;
            }
            i++;
        }
        s.append(ref);
        if (count > 1) s.append(count);

        return s.length();
    }

    public static int compress2(char[] chars) {

        int n = chars.length;

        if (n < 2)
            return n;

        char ref = chars[0];
        int count = 0, i = 0, index = 0;

        while (i < n) {
            char c = chars[i];

            if (chars[i] == ref) {
                count++;
            } else {
                char[] counts = String.valueOf(count).toCharArray();

                for (char cc : counts) {
                    index++;
                    chars[index] = cc;
                }

                count = 0;
                ref = c;
                i--;
                index++;
            }
            i++;
        }

        char[] counts = String.valueOf(count).toCharArray();
        for (char cc : counts) {
            index++;
            chars[index] = cc;
        }

        return index + 1;
    }

    public static int compress3(char[] chars) {
        int n = chars.length;
        if (n < 2)
            return n;

        int writeIndex = 0, readIndex = 0;

        while (readIndex < n) {
            char currentChar = chars[readIndex];
            int count = 0;

            while (readIndex < n && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            chars[writeIndex++] = currentChar;

            if (count > 1) {
                char[] countChars = String.valueOf(count).toCharArray();
                for (char c : countChars)
                    chars[writeIndex++] = c;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        System.out.println(compress3(chars));
    }
}
