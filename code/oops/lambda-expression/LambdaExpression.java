
@FunctionalInterface
interface Template {

    public void show();
}

@FunctionalInterface
interface Template1 {

    public void show(int i);
}


@FunctionalInterface
interface Template2 {

    public int show(int i, int j);
}

class LambdaExpression {

    public static void main(String[] args) {
        Template obj = new Template() {
            @Override
            public void show() {
                System.out.println("In Show");
            }
        };

        obj.show();

        //using lambda expression when single statement is there we did not want curly braces

        Template obj1 = () ->  System.out.println("In Lambda Show");
        obj1.show();

        //if the function has parameters and if parameter  = 1 then no bracket is needed

        Template1 obj2 = i -> System.out.println("In lambda show: " + i);
        obj2.show(5);

        // if the function has two parameters and it return some statement (if the logic is one line then we no need to write the return statement)
        Template2 obj3 = (i,j) -> i + j;
        System.out.println(obj3.show(5, 7));

        //multiple line logic 
        Template2 obj4 = (i,j) -> {
            System.out.println("Using lambda expression add multiple numbers");
            return i * j;
        };
        System.out.println(obj4.show(2, 3));
    }
}
