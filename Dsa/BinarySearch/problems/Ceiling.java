
class Ceiling {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9, 60, 70, 80, 81};
        System.out.println("Ceiling of the array: " + floorOnSortedArray(arr, 8));
    }

    static int floorOnSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // if the target element is gerater than array of all elements
        if(target>arr[arr.length-1])
        {
          return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }
}
