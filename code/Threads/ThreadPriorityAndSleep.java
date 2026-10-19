
class MyThread1 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hiiii");
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                System.err.println("Exception occured");;
            }
        }
    }
}

class MyThread2 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                System.err.println("Exception occured");;
            }
        }
    }
}

class ThreadPriorityAndSleep {

    public static void main(String[] args) {
      MyThread1 t1 = new MyThread1();
      MyThread2 t2 = new MyThread2();

      t1.start();
      t2.start();
    }
}
