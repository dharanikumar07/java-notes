
class MaxElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        System.err.println("Max Value: " + max(arr));
        System.err.println("Max Value in range: " + maxValueInRange(arr, 1, 3));
    }

    //if array is empty then maxval -> Integer.MIN_VALUE
    static int max(int[] arr) {
        int maxVal = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        return maxVal;
    }

    static int maxValueInRange(int[] arr, int start, int end) {
        int maxVal = arr[start];
        while (start <= end) {
            if (maxVal < arr[start]) {
                maxVal = arr[start];
            }
            start++;
        }
        return maxVal;
    }
}
