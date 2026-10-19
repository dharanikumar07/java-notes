public class MultiLevelInheritance 
{
  public static void main(String[] args) {
      ScientificCalc sh = new ScientificCalc();
      int add = sh.add(3,4);
      int sub = sh.sub(3,4);
      int multiple = sh.multiple(3,4);
      int div = sh.div(3,4);
      double pow = sh.power(3,4);
      double floorDiv = sh.floorDiv(3,4);

      System.out.println("Addition: " + add);
      System.out.println("Subtraction: " + sub);
      System.out.println("Multiple: " + multiple);
      System.out.println("Division: " + div);
      System.out.println("Power: " + pow);
      System.out.println("Floor Division: " + floorDiv);

  }
}