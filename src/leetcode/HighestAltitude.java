package leetcode;

public class HighestAltitude {

    public static int largestAltitude(int[] gain) {

        int result = 0;
        int currentHeight = 0;

        for (int v : gain) {
            currentHeight += v;
            if(currentHeight >= result)
                result = currentHeight;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] gain = {-5,1,5,0,-7};

        System.out.println(largestAltitude(gain));
    }
}
