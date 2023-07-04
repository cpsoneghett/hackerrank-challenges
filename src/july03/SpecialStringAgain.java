package july03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpecialStringAgain {

    static long substrCount(int n, String s) {

        if (s.isEmpty())
            return 0l;

        long result = n;
        char[] arr = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) result++;
                if (arr[i] != arr[j]) {
                    int lastIndex = j * 2 - i;
                    if (lastIndex < n && s.substring(i, j).equals(s.substring(j + 1, lastIndex + 1)))
                        result++;
                    break;
                }
            }

        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(new File("src/inputs/special-string.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);

        scanner.close();
    }
}
