
import java.util.HashMap;
import java.util.Map;

class ExampleMap
{
  public static void main(String[] args) {
      Map<String, Integer> maps = new HashMap<String, Integer>();

      maps.put("Dharani", 20000);
      maps.put("Kumar", 25000);
      maps.put("Raj", 30000);
      maps.put("Diana", 22400);

      System.out.println(maps);
  }
}