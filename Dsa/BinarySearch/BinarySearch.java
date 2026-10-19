
class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9, 60, 70, 80, 81};
        System.out.println("Target element found at the index: " + binarySearch(arr, 100));
    }

    // search array and return the targeted element index
    // if not found return -1
    // consider the as in ascending order
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // int range exceed for that we have this formula
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }
}
