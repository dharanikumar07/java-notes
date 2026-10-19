public class SingleInheritance 
{
  public static void main(String[] args) {
      AdvCalc sh = new AdvCalc();
      int add = sh.add(3,4);
      int sub = sh.sub(3,4);
      int multiple = sh.multiple(3,4);
      int div = sh.div(3,4);

      System.out.println("Addition: " + add);
      System.out.println("Subtraction: " + sub);
      System.out.println("Multiple: " + multiple);
      System.out.println("Division: " + div);
  }
}