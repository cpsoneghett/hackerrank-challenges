public class Tribonacci {

    public static int tribonacci(int n) {

        if (n < 2)
            return n;
        else if (n == 2)
            return 1;

        int a = 0;
        int b = 1;
        int c = 1;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(tribonacci(7)); // 0 1 1 2 3 5 8 13
    }
}
