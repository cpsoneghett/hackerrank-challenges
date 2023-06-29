import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class BeautifulPairs {


    public static int beautifulPairs(int[] A, int[] B) {
        int[] countA = new int[1001]; // Count of elements in array A
        int[] countB = new int[1001]; // Count of elements in array B

        // Count the occurrences of elements in array A
        for (int num : A) {
            countA[num]++;
        }

        // Count the occurrences of elements in array B
        for (int num : B) {
            countB[num]++;
        }

        int pairs = 0;
        boolean foundMismatch = false;

        // Count the number of beautiful pairs
        for (int i = 1; i <= 1000; i++) {
            pairs += Math.min(countA[i], countB[i]);

            // Check if there is a mismatch in counts
            if (countA[i] != countB[i]) {
                foundMismatch = true;
            }
        }

        // If there is a mismatch, increment pairs by 1
        if (foundMismatch) {
            pairs++;
        } else {
            pairs--; // Decrement pairs by 1 to change one element in B
        }

        return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/bpairs.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = beautifulPairs(A, B);

        System.out.println(result);

        bufferedReader.close();

    }

    /**

     void decentNumber(int n) {

         // 3*a + 5*b = n

         int a, b;
         int m = n / 5;
         for (int i = 0; i <= m; i++) if ((n - 5*i) % 3 == 0){
         b = i;
         a = (n - 5*i)/3;
         for (int i = 1; i <= 3 * a; i++) cout << "5";
         for (int i = 1; i <= 5 * b; i++) cout << "3";
         cout << endl;
         return;
         }
         cout << -1 << endl;
     }
     * */

}
