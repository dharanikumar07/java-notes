**Method overloading** means having **multiple methods with the same name but different parameters** in the same class.

It is also called **compile-time polymorphism**.

### Example

```
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

# Real-World Example: Payment System 💳

Imagine you're building an e-commerce application.

You have a `PaymentService` that needs to support different ways of making a payment.

You could have:

```
class PaymentService {

    void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " made with cash");
    }

    void pay(double amount, String cardNumber) {
        System.out.println("Payment of ₹" + amount + " made using card");
    }

    void pay(double amount, String cardNumber, String cvv) {
        System.out.println("Payment of ₹" + amount + " made using card + CVV");
    }
}
```

All three methods are called: