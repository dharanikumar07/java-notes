class Counter implements  Runnable
{
  public int count;
  public void run()
  {
    for (int i = 1; i <= 100; i++) {
        count++;
    }
  }
}
class ThreadJoin
{
  public static void main(String[] args) throws InterruptedException {
      Counter counter = new Counter();
      Thread t1 = new Thread(counter);
      Thread t2 = new Thread(counter);

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println("Counter value is: " + counter.count);
  }
}