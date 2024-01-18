package july04;

public class Fibonacci {

    public static int fibonacci(int n) {

        if(n <= 2)
            return 1;

        return fibonacci(n-2) + fibonacci(n-1);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fibonacci(5));
    }
}
