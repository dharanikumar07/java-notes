
class Task1 implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hiii");
        }
    }
}

class Task2 implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}

class SampleRunnable {

    public static void main(String[] args) {
        Runnable task1 = new Task1();
        Runnable task2 = new Task2();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        //using lambda expression
        Runnable tasklambda1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("From Lambda hiii");
            }
        };

        Runnable tasklambda2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("From Lambda hello");
            }
        };

        Thread t3 = new Thread(tasklambda1);
        Thread t4 = new Thread(tasklambda2);

        t3.start();
        t4.start();
    }
}
