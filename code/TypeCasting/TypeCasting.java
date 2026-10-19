public class TypeCasting {
  public static void main(String[] args) {

      //implicit conversion
      byte a = 10;
      int b = a;
      System.out.println(a);

      //excplicit conversion
      float num1 = 100.5f;
      int num2 = (int) num1;
      System.out.println(num2);

      //type promotion
      byte b1 = 100;
      byte b2 = 120;

      int result = b1 * b2;

      System.out.println(result);


  }
}