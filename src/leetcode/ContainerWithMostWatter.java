package leetcode;

public class ContainerWithMostWatter {

    public static int maxArea(int[] height) {

        int base = height.length;
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left <= right) {
            int min = Math.min(height[left], height[right]);
            int area = min * (right - left);
            if (area > maxArea)
                maxArea = area;

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }
}
