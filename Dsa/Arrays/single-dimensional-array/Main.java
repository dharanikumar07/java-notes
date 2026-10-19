
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int[] arr = new int[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int nums : arr) {
            System.out.println(nums);
        }

        System.out.println(Arrays.toString(arr)); // it convert the array to string and print it

        changeArray(arr, 2);

        System.out.println(Arrays.toString(arr));
    }

    static void changeArray(int [] nums, int index) {
      nums[index] = 07;
    }
  // Java is always pass-by-value. When we pass an array to a method, the
  //  reference to the array is passed by value, meaning a copy of the reference is passed. 
  //  Both references point to the same array object."
    //-> java always pass by value 

//     Java copies the reference value:

// main()                  changeArray()

// arr ─────────────┐
//                  │
//                  ↓
//              ┌─────────────┐
//              │ 0 │ 0 │ 0   │
//              └─────────────┘
//                  ↑
//                  │
// nums ────────────┘
}
