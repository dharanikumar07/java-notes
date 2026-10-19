class Calculator {
  public int add(int n1, int n2) 
  {
    return n1 + n2;
  }
}


public class ClassAndObjects {
  public static void main(String[] args) {
      int num1 = 5;
      int num2 = 6;

      //calculator -> reference
      // calc -> reference variable 
      // new calculator() ->  creates an object
      Calculator calc = new Calculator();

      int result = calc.add(num1, num2);

      System.out.println(result);

  }
}