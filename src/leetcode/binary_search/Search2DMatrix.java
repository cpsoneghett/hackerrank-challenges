package leetcode.binary_search;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col > -1) {
            int curr = matrix[row][col];
            if (curr == target)
                return true;
            if (target > curr)
                row++;
            else
                col--;
        }

        return false;
    }

}
