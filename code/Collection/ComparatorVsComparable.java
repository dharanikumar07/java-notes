
import java.util.Comparator;

class ComparatorVsComparable
{
  public static void main(String[] args) {
      // Comparator<Integer> com = new Comparator<Integer>() {
      //   public int compare(Integer i,  Integer j)
      //   {
      //       return i % 10 > j % 10 ? 1 : -1;
      //   }
      // };

      Comparator<Integer> com = (i, j) -> i % 10 > j % 10 ? 1 : -1;

      
  }
}