
class Leetcode744 {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'f', 'x'};
        System.out.println(binarySearch(arr, 'z'));
    }

    static char binarySearch(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // int range exceed for that we have this formula
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return arr[start % arr.length];
    }
}
