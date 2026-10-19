
public class MultiDimensionalArray {

    public static void main(String[] args) {
        //normal static array
        int arr[][] = {{1, 2, 3}, {4, 5, 6}};

        //dynamic array 
        int arr1[][] = new int[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
              arr1[i][j] = (int)(Math.random()*10);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
              System.out.print(arr1[i][j] + " ");
            }
            System.err.println();
        }

        //using enhanced for loop

        for(int [] nums : arr1) {
          for(int num : nums) {
            System.out.print(num + " ");
          }

          System.out.println();
        }

    }
}
