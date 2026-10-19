
class Floor {

    public static void main(String[] args) {
        int[] arra = {3, 4, 5, 6, 7, 10, 20, 50};
        //int[] arrd = {100, 30, 20, 10, 9, 8, 5, 4, 3, 2};

        System.out.println("Floor in ascending array: " + floorOnSortedArray(arra, 9));
        // System.out.println("Target found in descending array: " + floorOnSortedArray(arrd, 7));
    }

    static int floorOnSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // when target is less that first element 
        if(target<arr[0])
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

        return arr[end];
    }

    //work for both
    // static int floorOnSortedArray(int[] arr, int target) {
    //     int start = 0;
    //     int end = arr.length - 1;
    //     boolean isAsc = arr[start] < arr[end];
    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if (arr[mid] == target) {
    //             return arr[mid];
    //         }
    //         if (isAsc) {
    //             if (target < arr[mid]) {
    //                 end = mid - 1;
    //             } else {
    //                 start = mid + 1;
    //             }
    //         } else {
    //             if (target > arr[mid]) {
    //                 end = mid - 1;
    //             } else {
    //                 start = mid + 1;
    //             }
    //         }
    //     }
    //     if(isAsc)
    //     {
    //       return arr[end];
    //     }
    //     return arr[start];
    // }
}
