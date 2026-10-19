
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(); // we also mentioned the capacity also clearly in written notes
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        System.err.println("Before removing element: " + list);
        list.remove(2);
        list.add(2, 99);
        System.err.println("after removing element and add: " + list);

        System.out.println(list.get(3));
        
    }
}
