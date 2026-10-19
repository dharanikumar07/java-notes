class Sample {

    public Sample() {
      System.out.println("Object is created");
    }

    
    public void display() {
      System.out.println("Object is displayed");
    }
}


public class Anonymous {
  public static void main(String[] args) {
      new Sample();
      new Sample().display();
  }
}