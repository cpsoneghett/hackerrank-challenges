import java.util.Random;

public class RandomNumbers {

    public static void main(String[] args) {

        int n = 10; // Change this to the desired size of the array
        Random random = new Random();

        System.out.println(n);

        for (int i = 0; i < n; i++) {
            int randomNum = random.nextInt(200000) - 100000;
            System.out.printf("%d ", randomNum);
        }
    }
}