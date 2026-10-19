class Student {
  public String name;
  public int age;
  public static String college;

    //call once when the class is loaded
    static {
        college = "GHT college";
    }

    public Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

    //under the object
    public void display() {
      System.out.println("Name: " + this.name + "Age: " + this.age);
    }

    //under the class

    public static void getCollege() {
      System.out.print(college);
    }

  
}


public class ThisStaticMethodsAndVariables{
  public static void main(String[] args) {
      Student stud = new Student("Dharanikumar", 20);
      stud.display();

      Student.getCollege();


  } 
}