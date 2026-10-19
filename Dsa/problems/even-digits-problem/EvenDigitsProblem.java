
class EvenDigitsProblem {
    // given array of elements we need find the no of elements which digits count is sum of even
    // 123, 34 56
    // 2 (34 and 56 have 2 digits which is even)
    public static void main(String[] args) {
        int[] arr = {1, 234, 5, 45, 7686, 23};
        System.out.print("Even digits present in array are : " + eventDigitsCount(arr));
    }


    static int eventDigitsCount(int[] arr) {
        int evenDigits = 0;
        for (int i = 0; i < arr.length; i++) {
            if (even(arr[i]) == true) {
                evenDigits++;
            }
        }
        return evenDigits;
    }

    static boolean even(int num) {
        if (getDigitsSimpleSolution(num) % 2 == 0) {
            return true;
        }
        return false;
    }

    static int digits(int num) {
        if(num<0)
        {
            num *= -1;
        }
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }

        return count;
    }

    static int getDigitsSimpleSolution(int num)
    {
        if(num<0)
        {
            num *= -1;
        }
        return (int) (Math.log10(num));
    }
}
