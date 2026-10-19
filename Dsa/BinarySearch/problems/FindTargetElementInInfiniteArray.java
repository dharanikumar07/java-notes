
class FindTargetElementInInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9, 10, 23, 45, 67, 89, 100, 120, 130};
        System.out.println("Element founded in index: " + answer(arr, 120));
    }

    static int answer(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
