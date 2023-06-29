package june28;

public class DrawingBook {

    public static int pageCount(int n, int p) {

        int count = n / 2 + 1;
        int numberOfPage = p / 2 + 1;

        return count - numberOfPage > numberOfPage - 1 ? numberOfPage - 1 : count - numberOfPage;

    }

    public static void main(String[] args) {

        int n = 5;
        int p = 3;

        System.out.println(pageCount(5, 3));
    }
}
