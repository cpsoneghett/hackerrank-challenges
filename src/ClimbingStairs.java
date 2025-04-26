public class ClimbingStairs {

    public static int climbStairs(int n) {

        if(n == 0 || n == 1)
            return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static long climbStairs2(int n) {

        if (n <= 1)
            return 1;

        int a = 0, b = 1, result = n;

        for (int i = 1; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(climbStairs2(5));
    }

}
