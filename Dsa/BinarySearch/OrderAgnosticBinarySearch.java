
class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        int[] arrd = {100, 30, 20, 10, 9, 8, 5, 4, 3, 2};
        int[] arra = {1, 2, 3, 4, 5, 10, 20, 50};
        System.out.println("Target found in ascending array: " + binarySearchInOrderAgnositicArray(arra, 5));
        System.out.println("Target found in descending array: " + binarySearchInOrderAgnositicArray(arrd, -2));
    }

    // we cannot known the orde of the array (des or asc)
    // find the order of the array 
    // return the index of the target not found return -1 
    static int binarySearchInOrderAgnositicArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } 
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }
}
