

class DharaniException extends Exception
{
  DharaniException(String message)
  {
    super(message);
  }
}

class Duck 
{
  public void show() throws ArithmeticException
  {
    int result = 1/0;
  }
}

class ExceptionExample {

    public static void main(String[] args) {
        int i = 18;
        int j = 0;
        int result = 0;

        try {
            result = i / j;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Bye 1..");

        //multiple catch block
        int[] arr = new int[5];
        try {
            result = i / 3;
            System.out.println(result);
            System.out.println("Array of index 5" + arr[5]);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero" + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stay your limit: " + e);
        }

        //custom exception and throwable keyword
        try {
            if (j == 0)
            {
              throw new DharaniException("dharani checks failed");
            }

        } catch (DharaniException e) {
            System.out.println("Custom exception message: " + e);
        } 

        // duck method exception handling

        Duck obj = new Duck();
        try{
          obj.show();
        } catch(ArithmeticException e)
        {
          System.out.println("Duck exception" + e);
        }
        

        System.out.println("by 2 .... all the execution completed");

        try {
            obj.show();
        } catch (ArithmeticException e) {
          System.out.println("Catch block is handled: ");
        } finally {
          System.out.println("Bye 3 ....... all execution completed");
        }
    }
}
