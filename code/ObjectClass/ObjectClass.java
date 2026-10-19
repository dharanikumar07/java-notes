class Simple
{
  public int age;
  public String name;
  public void display()
  {
    System.out.print("In Simple CLass");
  }
}

class ObjectClass
{
  public static void main(String[] args) {
      Simple obj = new Simple();
      obj.age=22;
      obj.name="dharani";

      Simple obj2 = obj;
      obj2.age=23;
      
      System.out.println(obj.equals(obj2)); //same object 23 
      System.out.println(obj.age);
      System.out.println(obj2.age);

      System.out.println(obj2.toString());
  }
}