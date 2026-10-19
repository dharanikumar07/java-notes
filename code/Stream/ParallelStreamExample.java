
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ParallelStreamExample {

    public static void main(String[] args) {
        int size = 10_000;
        List<Integer> list = new ArrayList<>();
        Random ran = new Random();

        for (int i = 0; i < size; i++) {
            list.add(ran.nextInt(10));
        }

        long startseq = System.currentTimeMillis();
        int sum1 = list.stream()
                .map(i -> i * 2)
                //also we do with thread sleep also
                /*
                .map(i-> {
                try{
                Thread.sleep(1);
                } catch(Exception e)
                })
                */ 
                .mapToInt(i -> i)
                .sum();

        long endseq = System.currentTimeMillis();

        long startpara = System.currentTimeMillis();
        
        int sum2 = list.stream()
                .map(i -> i * 2)
                //also we do with thread sleep also
                /*
                .map(i-> {
                try{
                Thread.sleep(1);
                } catch(Exception e)
                })
                */ 
                .mapToInt(i -> i)
                .sum();

        long endpara = System.currentTimeMillis();

        System.out.println("Para: " + (endpara - startpara));
        System.out.println("Seq: " + (endseq - startseq));

        System.out.println("parallel: " + sum2 + " sequential: " + sum1);

    }
}
