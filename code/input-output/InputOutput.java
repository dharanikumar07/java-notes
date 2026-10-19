
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class InputOutput {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int scn = in.nextInt();
        System.out.println("Integer: " + scn);

        // BufferedReader
        BufferedReader bf
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter another number:");
        int bfn = Integer.parseInt(bf.readLine());

        System.out.println("Using BufferedReader: " + bfn);
    }
}
