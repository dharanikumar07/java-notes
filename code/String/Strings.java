
public class Strings {

    public static void main(String[] args) {
        String name = "dharani";
        String n1 = new String("dharani");

        System.out.println(name);
        System.out.println(n1);

        //string builder not thread safe
        StringBuilder sb = new StringBuilder("dharanikumar");

        sb.append(" good");

        //string buffer thread safe 
        StringBuffer sb1 = new StringBuffer("raja");

        sb1.append(" good");

        System.out.println("String Buffer: " + sb1);
        System.out.println("String Builder: " + sb);
    }
}
