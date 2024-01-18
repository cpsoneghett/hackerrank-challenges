package august24;

public class SaveThePrisioner {

    public static int saveThePrisoner(int n, int m, int s) {
        int result=(m%n+(s-1))%n;

        return result == 0 ? n : result;
    }

    public static void main(String[] args) {

        int prisoners = 7;
        int candies = 19;
        int start = 2;

        System.out.println(saveThePrisoner(prisoners, candies, start));

    }
}
