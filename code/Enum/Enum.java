
enum Status {
    PENDING, SUCCESS, FAILED;
}

enum Laptop {
    MacBook(100000), Dell(50000), Hp(45000), Lenovo(50000), Acer; // constructor variables

    private int price;

    Laptop() // default parameters constructor which takes the when the price is not defined
    {
        this.price = 35000;
    }

    Laptop(int price) // takes price 
    {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

}

class Enum {

    public static void main(String[] args) {
        Status failed = Status.FAILED;
        Status[] status = Status.values();

        for (Status s : status) {
            System.out.println("Status: " + s);
        }

        System.out.println("Failed Status: " + failed);

        switch (failed) {
            case Status.PENDING:
                System.out.println("In progress");
                break;
            case Status.FAILED:
                System.out.println("Operation failed");
                break;
            default:
                System.out.println("Unknown status type");
                break;
        }

        Laptop lap = Laptop.MacBook;
        System.out.println(lap + " " + lap.getPrice());
    }
}
