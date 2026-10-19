
import java.util.HashSet;

class HashSetExample
{
  public static void main(String[] args) {
    HashSet<Integer> sets = new HashSet<Integer>();
    // Set<Integer> sets = new HashSet<Integer>(); also wirte like this 
    sets.add(9);
    sets.add(99);
    sets.add(88);
    sets.add(9);

    System.out.print(sets);
  }
}