package june28;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CatsAndMouse {

    static String catAndMouse(int x, int y, int z) {

        int result = Integer.compare(Math.abs(x - z), Math.abs(y - z));

        if (result == -1)
            return "Cat A";
        else if (result == 1)
            return "Cat B";
        else
            return "Mouse C";
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/inputs/cats-and-mouse.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            System.out.println(result);

        }

        scanner.close();

    }
}
