
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        //int [][] arr = new int[3][]; // cols are not mandatory to mention the size

        int[][] arr = {
            {1, 2, 3},
            {4, 5},
            {6, 7}
        };

        for (int[] nums : arr) {
            System.out.println(Arrays.toString(nums));
        }

        int[][] arr1 = new int[3][3]; // we also mentioned the column also
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                arr1[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                System.err.print(arr1[row][col] + " ");
            }
            System.err.println();
        }

    }
}
