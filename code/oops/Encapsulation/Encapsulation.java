class Student {
  private String name;
  private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

public class Encapsulation {
  public static void main(String[] args) {
      Student stud = new Student();

      stud.setName("Dharanikumar");
      stud.setAge(22);

      //where we restrict the data only used via the methods
      System.out.println("Student Name: " + stud.getName());
      System.out.println("Student Age: " + stud.getAge());
  }
}