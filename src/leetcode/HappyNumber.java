package leetcode;

public class HappyNumber {

    public static boolean isHappy(int n) {

        if (n == 1)
            return true;
        else if (n >= 2 && n <= 9)
            return false;

        long sum = 0l;
        long aux = n;

        while (sum != 1) {

            String s = String.valueOf(aux);

            for (int i = 0; i < s.length(); i++)
                sum += Math.pow((Integer.valueOf(s.charAt(i))-48), 2);

            if(sum == 1)
                return true;

            aux = sum;
            sum = 0;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }
}
