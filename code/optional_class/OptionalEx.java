
import java.util.Arrays;
import java.util.List;

class OptionalEx {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dharani", "kumar", "raja", "laxmi");

        // Optional<String> name = names.stream()
        //                     .filter(n -> n.contains("x"))
        //                     .findFirst();
        // System.out.print(name.orElse("Not Found"));
        String name = names.stream()
                .filter(n -> n.contains("a"))
                .findFirst()
                .orElse("Not found");

        System.out.print(name);
    }
}
