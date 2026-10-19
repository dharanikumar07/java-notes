class Student {
    String name;
    int age;
}

public class ArrayOfObject {
  public static void main(String [] args) {

      Student s1[] = new Student[3];

      s1[0] = new Student();
      s1[0].name="dharani";
      s1[0].age=22;

      s1[1] = new Student();
      s1[1].name="kumar";
      s1[1].age=22;

      s1[2] = new Student();
      s1[2].name="Raja";
      s1[2].age=50;

      for (Student stud : s1) {
        System.out.println(stud.name + " : " + stud.age);
      }
  }
}