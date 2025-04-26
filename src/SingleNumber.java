public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for(int n : nums)
            ans ^= n;

        return ans;
    }

    public static void main(String[] args) {

        int v[] = {4,1,2,1,2};

        System.out.println(singleNumber(v));
    }
}
