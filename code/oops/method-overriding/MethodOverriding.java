
class Calc {

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}

class AdvCalc {

    public int add(int n1, int n2) {
        return n1 + n2 + 1;
    }
}

public class MethodOverriding {

    public static void main(String[] args) {
        AdvCalc obj = new AdvCalc();
        int result = obj.add(5, 6);

        System.out.print(result);
    }
}
