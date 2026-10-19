
import java.util.ArrayList;

class Employee
{
  public int age;
  public String name;
  public int salary;

    public Employee(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("age=").append(age);
        sb.append(", name=").append(name);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }



}

class SampleArrayList
{
  public static void main(String[] args) {
      ArrayList<Integer> arr = new ArrayList<Integer>(3);
      arr.add(2);
      arr.add(5);
      arr.add(6);
      arr.add(7);
      arr.add(29);

      System.out.println(arr);

      ArrayList<Employee> studs = new ArrayList<Employee>();

      studs.add(new Employee(22,"Dharanikumar", 10000));
      studs.add(new Employee(50,"Raja", 20000));
      studs.add(new Employee(23,"Naveen", 15000));

      System.out.println(studs);
  }
}   