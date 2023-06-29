import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Candies {

    public static int candies(int n, int[] v) {
        int sum = 0;
        List<Integer> values = new ArrayList<>();
        int currentValue = 1;

        values.add(currentValue); //adding the first value;

        for (int i = 1; i < v.length; i++) {
            if (v[i] > v[i - 1]) {
                currentValue++;
                values.add(currentValue);
            } else if (v[i] <= v[i - 1]) {

                if (currentValue > 3) currentValue = 2;
                else currentValue--;

                if (currentValue <= 0)
                    currentValue = 1;

                values.add(currentValue);

            }
        }

        System.out.println(values);
        for (int x : values)
            sum += x;

        return sum;
    }

    public static long candies2(int n, int[] v) {
        long sum = 0;
        int[] values = new int[n];

        for(int i = 0; i<n; i++)
            values[i] = 1;

        for(int i = 1; i<n; i++) {
            if (v[i] > v[i - 1]) {
                values[i] = values[i-1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(v[i] > v[i+1])
                values[i] = Math.max(values[i], values[i+1] + 1);
        }

        for(int x : values) {
            System.out.print(x + " ");
            sum += x;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/inputs/candies.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        long result = Candies.candies2(n, arr);

        System.out.println("\n" + result);
    }

}
