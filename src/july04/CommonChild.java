package july04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonChild {

    public static int commonChild(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int[][] matrix = new int[n+1][m+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                matrix[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i -1);
            for (int j = 1; j <= m; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2)
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }

        return matrix[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/common-child.txt"));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = commonChild(s1, s2);

        System.out.println(result);
        bufferedReader.close();
    }
}
