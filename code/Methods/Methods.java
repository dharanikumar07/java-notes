
class Calculator {

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    //method overloading
    public int add(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}

public class Methods {

    public static void main(String[] args) {
      Calculator calc = new Calculator();

      int resultTwoNumbers = calc.add(10, 5);
      int resultThreeNumbers = calc.add(resultTwoNumbers, 1, 1);

      System.out.println(resultTwoNumbers);
      System.out.println(resultThreeNumbers);
    }
}
