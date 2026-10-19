class ArrayLinearSearch
{
  public static void main(String[] args) {
      int [] arr = {1, 2, 3, 4, 5, 6, 9};
      System.out.println("Element found in: " + findElement(arr, 9));
      System.out.println("Element found in: " + findElement(arr, 100));
      System.out.println("Element found in: " + findElementInRange(arr, 4, 1, 5));
      System.out.println("Element found in: " + findElementInRange(arr, 9, 0, 3));
  }

  static int findElement(int [] arr, int target)
  {
    for (int i = 0 ; i < arr.length ; i++)
    {
      if(target == arr[i])
      {
        return i;
      }
    }

    return -1;
  }

  static int findElementInRange(int [] arr, int target, int start, int end)
  {
    while(start<=end)
    {
      if(arr[start] == target)
      {
        return start;
      }
      start++;
    }

    return -1;
  }
}