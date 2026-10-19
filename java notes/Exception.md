## 86. What is Exception?

An **exception** is an unwanted event that occurs during program execution and **interrupts the normal flow**.

Example:

```
int a = 10 / 0;
```

➡️ `ArithmeticException`

```
Program
  ↓
Exception occurs
  ↓
Normal flow stops
  ↓
Exception Handling
```

### Remember

> **Exception = Runtime problem that disrupts normal program execution.**

---

# 87. Exception Handling — `try-catch`

Used to **handle exceptions** so the program doesn't terminate abnormally.

```
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

### Flow

```
try
 ↓
Exception?
 ↓ YES
catch
 ↓
Program continues
```

### Keywords

|Keyword|Purpose|
|---|---|
|`try`|Code that may cause exception|
|`catch`|Handles exception|
|`finally`|Executes normally whether exception occurs or not|
|`throw`|Explicitly throws exception|
|`throws`|Declares possible exception|

---

# 88. Multiple `catch`

One `try` can have **multiple catch blocks** to handle different exceptions.

```
try {
    int a = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
}
catch (NullPointerException e) {
    System.out.println("Null error");
}
catch (Exception e) {
    System.out.println("Other error");
}
```

### Important Rule

**Specific exception → General exception**

✅ Correct:

```
catch (ArithmeticException e)
catch (Exception e)
```

❌ Wrong:

```
catch (Exception e)
catch (ArithmeticException e)
```

Because `Exception` can already catch `ArithmeticException`.

---

# 89. Exception Hierarchy

Java exceptions are organized in a hierarchy.

```
                Throwable
                   │
          ┌────────┴────────┐
          │                 │
        Error            Exception
                            │
                    ┌───────┴────────┐
                    │                │
              RuntimeException    Other Exceptions
                    │
          ┌─────────┼─────────┐
          │         │         │
 Arithmetic   NullPointer   ArrayIndexOutOfBounds
 Exception     Exception       Exception
```

### Two important categories

**Checked Exception**

➡️ Checked by compiler.

Example:

```
IOException
SQLException
```

**Unchecked Exception**

➡️ Runtime exceptions.

```
RuntimeException
   ↓
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
```

### Remember

> `Throwable` is the root of Java's exception/error hierarchy.

---

# 90. `throw` Keyword

`throw` is used to **explicitly throw an exception**.

```
throw new ArithmeticException("Invalid calculation");
```

Example:

```
int age = 15;

if (age < 18) {
    throw new ArithmeticException("Not eligible");
}
```

### Remember

```
throw
  ↓
Actually throws ONE exception
```

> **`throw` = throw an exception manually.**

---

# 91. Custom Exception

A **custom exception** is an exception created by the programmer for application-specific situations.

Create it by extending `Exception`:

```
class AgeException extends Exception {

    AgeException(String message) {
        super(message);
    }
}
```

Use it:

```
if (age < 18) {
    throw new AgeException("Age must be 18+");
}
```

### Structure

```
Custom Exception
       ↓
extends Exception
       ↓
Your own exception type
```

### Remember

> **Custom Exception = programmer-defined exception for business/application rules.**

---

# 92. Exception Ducking — `throws`

**Exception ducking** means a method does not handle a checked exception itself; instead, it **passes the responsibility to the caller** using `throws`.

```
static void readFile() throws IOException {
    // code
}
```

Caller:

```
try {
    readFile();
}
catch (IOException e) {
    System.out.println("File error");
}
```

### Flow

```
readFile()
    ↓
throws IOException
    ↓
Caller
    ↓
handles exception
```

### `throw` vs `throws`

|`throw`|`throws`|
|---|---|
|Actually throws exception|Declares possible exception|
|Used inside method|Used in method signature|
|Throws one exception at a time|Can declare multiple|
|`throw new Exception()`|`method() throws Exception`|

Example:

```
// throw
throw new IOException();
```

```
// throws
void test() throws IOException {
}
```

---

# 🧠 Final Revision — Remember This

```
Exception
   ↓
Runtime problem

try
   ↓
Risky code

catch
   ↓
Handle exception

throw
   ↓
Manually throw exception

throws
   ↓
Pass responsibility to caller

Custom Exception
   ↓
Our own exception class

Exception Hierarchy
   ↓
Throwable
   ├── Error
   └── Exception
        └── RuntimeException
```


# `finally` Keyword in Java

`finally` is a block used with `try-catch` to execute **important cleanup code**.

## When does `finally` execute?

Normally, `finally` executes **whether an exception occurs or not**.

-> every time when the program is run it executes the block 

