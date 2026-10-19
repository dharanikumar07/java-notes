
## 1. What is Encapsulation?

Encapsulation is bundling data and methods into a single class and restricting direct access to the data.

In Java, encapsulation is mainly achieved using:

- `private` variables
- `public` methods (`getter` / `setter`)

### Simple idea

```
Class
│
├── Data          → private
│
└── Methods       → public
       │
       └── Controlled access to data
```

---

# 2. Why do we need Encapsulation?

Without encapsulation:

```
class BankAccount {

    public double balance;
}
```

Anyone can directly modify the balance:

```
BankAccount account = new BankAccount();

account.balance = -50000;
```

❌ There is no control.

With encapsulation:

```
class BankAccount {

    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

Now:

```
BankAccount account = new BankAccount();

account.deposit(5000);

System.out.println(account.getBalance());
```

Direct access is prevented:

```
account.balance = -50000;  // ❌ Compile-time error
```

---

# 3. How Encapsulation works

```
                 BankAccount
        ┌─────────────────────────┐
        │                         │
        │ private balance         │
        │                         │
        │        🔒                │
        │                         │
        │ public deposit()        │
        │ public getBalance()     │
        │                         │
        └────────────┬────────────┘
                     │
              Controlled access
                     │
                     ▼
                  Outside
```

The data is protected inside the class.

The outside world interacts through **controlled methods**.

---

# 4. Real-world example — ATM

Think about an ATM.

You don't directly access the bank's database and change:

```
balance = ₹1,00,000
```

Instead, you interact through operations:

```
             ATM
              │
       ┌──────┴──────┐
       │             │
    Withdraw      Deposit
       │             │
       └──────┬──────┘
              ▼
        Bank Account
              │
              │
        🔒 balance
```

The balance is protected.

You can perform operations like:

```
deposit()
withdraw()
getBalance()
```

But you cannot directly manipulate the balance.

This is the idea of **encapsulation**.

---

# 5. Getter and Setter

A common way to implement encapsulation is using getters and setters.


