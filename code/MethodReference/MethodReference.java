
import java.util.Arrays;
import java.util.List;

class MethodReference
{
  public static void main(String[] args) {
      List<String> names = Arrays.asList("Dharani", "Kumar", "Raja");

      List<String> uNames = names.stream()
                            .map(String::toUpperCase)
                            .toList();

      uNames.forEach(System.out::println);
      
  }
}