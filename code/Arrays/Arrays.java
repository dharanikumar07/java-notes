public class Arrays
{
    public static void main(String[] args) {
      //normal static array
      int arr[] = {1,2,3};

      //dynamic array 
      int arr1[] = new int[3];

      arr1[0] = 1;
      arr1[1] = 2;
      arr1[2] = 3;

      for(int i=0; i<3; i++) {
        System.out.print(arr1[i] + " ");
      }

    }
}