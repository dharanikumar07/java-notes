
class A {

    public A() {
        super();
        System.out.println("A default contructor");
    }

    public A(int n1) {
        super();
        System.out.println("A  contructor with:  " + n1);
    }
}

class B extends A {

    public B() {
        super();
        System.out.println("B default contructor");
    }

    public B(int n1) {
        super(n1);
        System.out.println("B  contructor with:  " + n1);
    }
}

public class Super {

    public static void main(String[] args) {
        B obj = new B(5);
    }

}
