
class A {

    public void displayInA() {
        System.out.println("Display in A");
    }

    class B {

        public void displayInB() {
            System.out.println("Display in B");
        }
    }
}

class StaticExample
{
  public void displayInStaticExample()
  {
    System.out.println("Display in Static example");
  }

  static class Example
  {
    public void displayInExample()
    {
      System.out.println("Display in example");
    }
  }
}

class InnerClass {

    public static void main(String[] args) {
      A obj = new A();

      A.B obj1 = obj.new B();
      obj1.displayInB(); // it cannot acess the outer class methods
      obj.displayInA();

      StaticExample staticObj = new StaticExample();
    }
}
