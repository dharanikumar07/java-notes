
public class Loops {

    public static void main(String[] args) {
        int num1 = 1;

        //while loop
        while (num1 <= 5) {
            System.out.println("While loop running ...." + num1);
            num1++;
        }

        //do while loop
        do {
            System.out.println("Do While loop running ...." + num1);
        } while (num1 == 1);

        for (int i = 1; i < 10; i++) {
            System.out.println("for loop running ... " + i);
        }

        //nested loop
        for (int k = 1; k <= 5; k++) {
            System.out.println("Day --- " + k);

            for (int j = 1; j <= 9; j++) {
                System.out.println("   " + (j + 8) + " - " + (j + 9));
            }

        }

    }
}
