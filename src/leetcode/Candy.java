package leetcode;

public class Candy {
    //TODO: INCOMPLETE
    public int candy(int[] ratings) {

        int candies = ratings.length;

        for (int i = 1; i < ratings.length - 1; i++) {
            candies++;

        }

        return candies;
    }

    public static void main(String[] args) {

    }
}
