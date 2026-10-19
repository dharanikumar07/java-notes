
import java.util.Arrays;

class FindLastandFirstindexOfTarget {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 40, 40, 40, 50, 100};
        int[] ans = {-1, -1};

        ans[0] = binarySearch(arr, 40, true);
        ans[1] = binarySearch(arr, 40, false);

        System.out.println("Element start and index are: " + Arrays.toString(ans));
    }

    static int binarySearch(int[] arr, int target, boolean isFindStart) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                if (isFindStart) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    ans = mid;
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
