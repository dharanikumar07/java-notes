
class MaxWealth {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3, 4},
            {10, 60},
            {70, 80},
            {100, 120}
        };

        System.out.println("Maximum Wealth of the array is : " + findMaxWealth(arr));
    }

    static int findMaxWealth(int[][] arr) {
        int sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                if (maxVal < sum) {
                    maxVal = sum;
                }
            }
            sum = 0;
        }

        return maxVal;
    }

}
