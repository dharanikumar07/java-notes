
import java.util.Arrays;
import java.util.List;

public class StreamPipeline {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

//    	Stream<Integer> s1=nums.stream();
//    	Stream<Integer> s2= s1.filter(n ->n%2==0);
//    	Stream<Integer> s3= s2.map(n->n*2);
//    	int result=s3.reduce(0,(c,e)->c+e);
//    	
//    	s2.forEach(n -> System.out.println(n));
//    	s3.forEach(n -> System.out.println(n));
//    	
//    	s1.forEach(n-> System.out.println(n));
//   	s1.forEach(n-> System.out.println(n));
        int result = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);
        System.out.println(result);

//filter --------------------------------------
        //    	Predicate<Integer> p= new Predicate<Integer>() {
//    		public boolean test(Integer n) {
//    			return n%2==0;
//    			if(n%2==0)
//    				return true;
//    			else
//    				return false;
//    		}
//    	};
//    	Predicate<Integer> p= n-> n%2==0;


//map ----------------------------------------------
//    	Function<Integer, Integer> fun= new Function<Integer,Integer>() {
//    		public Integer apply(Integer n) {
//    			return n*2;
//    		}
//    	};
//    	Function<Integer,Integer> fun= n-> n*2;


//    	int result=nums.stream()
//    					.filter(n-> n%2==0)
//    					.map(n->n*2)
//    					.reduce(0, (c,e)-> c+e);
//    	System.out.println(result);

//    	Stream<Integer> sortedValues = nums.stream()
//    			.filter(n-> n%2==0)
//    			.sorted();
    }
}
