if        → one condition
if-else   → two choices
else-if   → multiple conditions
switch    → multiple fixed values
ternary   → short if-else

### 1. `if`

Executes code when a condition is `true`.

```
if (age >= 18) {
    System.out.println("Adult");
}
```

### 2. `if-else`

Chooses between **two conditions**.

```
if (age >= 18)
    System.out.println("Adult");
else
    System.out.println("Minor");
```

### 3. `else-if`

Checks **multiple conditions**.

```
if (mark >= 90)
    grade = 'A';
else if (mark >= 60)
    grade = 'B';
else
    grade = 'C';
```

### 4. `switch`

Used when choosing between **multiple fixed values/cases**.

```
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Invalid");
}
```

### 5. Ternary Operator `?:`

Short form of `if-else`.

```
String result = age >= 18 ? "Adult" : "Minor";
```
