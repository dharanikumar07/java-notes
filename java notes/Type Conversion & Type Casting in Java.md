
Both are about **converting a value from one data type to another**.

```
int a = 10;
double b = a;
```

Here, an `int` value is converted into a `double`.

Type Conversion
│
├── Widening Conversion  → Automatic
│
└── Narrowing Conversion → Manual (Casting)

## 1. Widening Conversion

Converting a **smaller type → larger type**.

Java does this **automatically** because there is generally no risk of losing the value.

```
int a = 10;
double b = a;
```

Here:

```
int → double
```

# 2. Narrowing Conversion / Type Casting

Converting a **larger type → smaller type**.

Java does **not** do this automatically because there may be **data loss**.

Example:

```
double price = 99.99;
int value = (int) price;
```

## Casting Syntax

```
targetType variable = (targetType) value;
```

## What is Type Promotion?

**Type promotion** means Java automatically converts a value of a **smaller data type into a larger compatible type**

char a = 'A'; 
char b = 'B'; 
int result = a + b;
System.out.println(result);

