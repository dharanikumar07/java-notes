class Counter
{
  public int count;
  public synchronized  void increment()
  {
    for (int i = 1; i <= 100; i++) {
        count++;
    }
  }
}

class RaceCondition
{
  public static void main(String[] args) throws InterruptedException {
    Counter count = new Counter();
      Runnable task1 = () -> {
        for (int i = 0; i < 1000; i++) {
          count.increment();
        }
      };

      Runnable task2 = () -> {
        for (int i = 0; i < 1000; i++) {
          count.increment();
        }
      };

      Thread t1 = new Thread(task1);
      Thread t2 = new Thread(task2);

      t1.start();
      t2.start();

      t1.join();
      t2.join();


      System.out.print("Final count value is: " + count.count);
  }
}

//to avoid this we use synchronized

// Conceptually it is:

// read count
//    ↓
// add 1
//    ↓
// write count

// Suppose:

// count = 50

// Then this can happen:

// Thread 1              Thread 2

// read 50
//                       read 50
// add 1 → 51
//                       add 1 → 51
// write 51
//                       write 51