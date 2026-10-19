
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student
{
  public int age;
  public String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("age=").append(age);
        sb.append(", name=").append(name);
        sb.append('}');
        return sb.toString();
    }




}

class ConstructorReference
{
  public static void main(String[] args) {
      List<String> names = Arrays.asList("Dharani", "Kumar", "Raja");

      List<Student> students = new ArrayList<>();

      students = names.stream()
                  .map(Student::new)
                  .toList();

                  System.out.println(students);
  }
}