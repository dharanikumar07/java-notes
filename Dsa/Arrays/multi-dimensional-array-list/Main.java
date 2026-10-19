
import java.util.ArrayList;
import java.util.Scanner;

class Main
{
  public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();

      for(int i = 0; i<3; i++)
      {
        list.add(new ArrayList<>());
      }
      Scanner sc = new Scanner(System.in);
      for(int row = 0; row < 3; row++)
      {
        for (int col = 0; col < 3; col++)
        {
          
          list.get(row).add(sc.nextInt());
        }
      }

      System.err.println("List: " + list);
  }
}