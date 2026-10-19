final class Calc
{
  final int a = 10;
  final int b = 12;

  final public void add()
  {
      System.out.println("Adding: " + (a+b));
  }
}

class AdvCalc{
    public void display()
    {
      System.out.println("Hiiii");
    }
}


class Final
{
  public static void main(String[] args) {
      Calc obj = new Calc();
      obj.add();
  }
}