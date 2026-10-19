
import java.util.Arrays;


class MultidimensionalArraySearch {

    public static void main(String[] args) {

      int [][] arr = {
        {1, 2, 3},
        {10, 78},
        {4, 5, 8},
        {50, 40, 180}
      };

      System.out.println("Element found in index: " + Arrays.toString(findInArray(arr, 5)));
      System.out.println("Maximum Element in an array is : " + findMaxElementInArray(arr));

    }

    static int[] findInArray(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }

    static int findMaxElementInArray(int[][] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > maxVal) {
                    maxVal = arr[row][col];
                }
            }
        }
        return maxVal;
    }
}
