
## 1. What is a Class?

A **class** is a **blueprint/template** used to create objects.

### Example

```
class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println("Car is driving");
    }
}
```

Here `Car` is a **class**.

It describes what a car object should have:

```
Car
├── Data
│   ├── brand
│   └── speed
│
└── Behavior
    └── drive()
```

### Example

```
class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println("Car is driving");
    }
}
```

Here `Car` is a **class**.

It describes what a car object should have:

```
Car
├── Data
│   ├── brand
│   └── speed
│
└── Behavior
    └── drive()
```
# 2. What is an Object?

An **object** is a real instance created from a class.

We create an object using the `new` keyword.

```
Car car1 = new Car();
```

Here:

```
Car       → reference type
car1      → reference variable
new Car() → creates an object
```

We can give values to the object's variables:

```
car1.brand = "BMW";
car1.speed = 120;
```

And call its method:

```
car1.drive();
```

## Difference

Think about a **house blueprint**.

```
Blueprint → Class
Actual House → Object
```

The blueprint describes:

```
House
├── color
├── rooms
└── doors
```

But the blueprint itself isn't an actual house.

You can create multiple houses from the same blueprint:

```
             House Class
                 │
        ┌────────┼────────┐
        ↓        ↓        ↓
      House1   House2   House3
```

Each object can have different values.

# 4. Real-World Example — Employee

Suppose you're building a company application.

Every employee has:

- Name
- Salary
- Department

And employees can:

- Work
- Display their details

We can represent this using a class: