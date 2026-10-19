
import java.util.Arrays;

class SwapReverse
{
  public static void main(String[] args) {
      int [] arr = {2,3,4,9,6,10};
      swap(arr, 2, 4);
      System.out.println("After Swaping two number: " + Arrays.toString(arr));
      reverse(arr);
      System.out.println("After reversing: " + Arrays.toString(arr));
  }

  static void swap(int [] arr, int index1, int index2)
  {
    arr[index1] = arr[index1] + arr[index2];
    arr[index2] = arr[index1] - arr[index2];
    arr[index1] = arr[index1] - arr[index2];
  }

  static void reverse(int [] arr)
  {
    int start = 0;
    int end = arr.length - 1;

    while(start<=end)
    {
      swap(arr, start, end);
      start++;
      end--;
    }
  }
}