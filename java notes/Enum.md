## 1. What is an `enum`?

`enum` means **enumeration**.

It is used when a variable should have a **fixed set of predefined values**.

Example:

```
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

Instead of allowing:

```
String day = "anything";
```

you can restrict it to:

```
Day day = Day.MONDAY;
```

So the main purpose is:

> **`enum` represents a fixed collection of constants.**

# 2. Enum is a special type

This is important.

```
enum Color {
    RED, GREEN, BLUE
}
```

`Color` becomes a **type**, just like:

```
int
String
Dog
```


# Enum has methods automatically

Every enum provides some useful built-in methods.

### `values()`


# Enum can have constructor + variables + methods

This is where enums become powerful.

```
enum Size {

    SMALL(10),
    MEDIUM(20),
    LARGE(30);

    private int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

### Enum — Short Notes

```
ENUM
────
• Enum = fixed set of constants.
• Used for limited/predefined values.
• Provides type safety.

Syntax:
enum Day { MON, TUE, WED }

Usage:
Day d = Day.MON;

Methods:
• values()   → all constants
• valueOf()  → String → enum
• ordinal()  → index (0-based)

• Enum can have variables, constructors & methods.
• Enum can implement interfaces.
• Enum cannot extend a class.
• Enum constants are objects.
```