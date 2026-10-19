
public class JaggedArray {

    public static void main(String[] args) {
        int arr[][] = new int[3][]; //jagged dynamic inner array
        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int[] nums : arr) {
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
