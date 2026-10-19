abstract class Car
{
  public abstract void color();

  public void wheelsCount()
  {
    System.out.println("4 wheels");
  }
}

class BMW extends Car
{
    public void color() {
        System.out.println("Red color");
    }  
}
public class Abstract
{
  public static void main(String[] args) {
      BMW bmw = new BMW();
      bmw.color();
      bmw.wheelsCount();

      Car car = new BMW();
      car.color();
      car.wheelsCount();
  }
}