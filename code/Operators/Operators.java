
public class Operators {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 9;

        //arthimetic operation
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 / num2);
        int num3 = ++num1; //pre increment
        System.out.println(num3);
        int num4 = num1++;
        System.out.println(num3);

        int r1 = 10;
        int r2 = 11;
        System.out.println(r1 > r2);
        System.out.println(r1 < r2);
        System.out.println(r1 >= r2);

        int l1 = 11;
        int l2 = 12;
        boolean result = l1 >= l2;
        System.out.println(l1 > l2 || l1 == r2);
        System.out.println(r1 < r2 && l1 == r2);
        System.out.println(!result);

    }
}
