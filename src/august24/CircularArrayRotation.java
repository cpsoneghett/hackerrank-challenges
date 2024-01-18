package august24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();

        int[] arr = new int[a.size()];

        for (int i = 0; i < a.size(); i++)
            arr[i] = i;

        rotateIndexArray(k, arr);

        for (int q : queries)
            result.add(a.get(arr[q]));

        return result;
    }

    private static void rotateIndexArray(int k, int[] arr) {
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length - 1];

            for (int j = arr.length - 1; j > 0; j--)
                arr[j] = arr[j - 1];

            arr[0] = temp;
        }
    }

    public static List<Integer> circularArrayRotation2(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        int n = a.size();

        k %= n; // To handle cases where k > n

        for (int q : queries) {
            int newIndex = (n + q - k) % n; // Calculate the new index after rotation
            result.add(a.get(newIndex));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/circularRotation.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<Integer> result = circularArrayRotation2(a, k, queries);

        System.out.println(result);

        bufferedReader.close();
    }
}
