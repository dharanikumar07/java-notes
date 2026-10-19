class A {
  public void needToDisplay()
  {
    System.out.println("In A display");
  }
}

class B extends A{
  @Override
  public void needToDisplay()
  {
    System.out.println("In B display");
  }
}
class Annotation
{
  public static void main(String[] args) {
      B obj = new B();
      obj.needToDisplay();
  }
}