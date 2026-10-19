
public class Conditionals {

    public static void main(String[] args) {
        //if -else

        int ie1 = 1;
        int ie2 = 2;
        int ie3 = 3;

        if (ie1 > ie2) {
            System.out.println("Ie2 is greater");
        } else if (ie3 > ie2) {
            System.out.println("Ie3 is greater");
        } else {
            System.out.println("Ie1 is greater");
        }

        //ternary operator
        int t1 = 9;
        int result = t1 % 2 == 0 ? 10 : 20;
        System.out.println(result);

        //switch statement 
        int n = 5;

        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Enter a valid number");
        }
    }
}
