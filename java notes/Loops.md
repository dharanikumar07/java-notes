A **loop** is used to execute the same block of code repeatedly while a condition is satisfied.

### When to use the loop

-> for loop -> You know the number of iterations or have a clear counter/range.
-> do while -> The code must execute at least once.
-> while -> You don't know exactly how many times the loop should run.

# 1. `while` Loop

A `while` loop checks the **condition first**, then executes the code.

while (condition) {
    // code
}
### How it works

```
i = 1
 ↓
Is i <= 5? → Yes → print 1 → i++
 ↓
Is i <= 5? → Yes → print 2 → i++
 ↓
...
 ↓
Is i <= 5? → No
 ↓
Stop
```

# 2. `do-while` Loop

A `do-while` loop executes the code **first** and checks the condition **afterward**.

### Syntax

```
do {
    // code
} while (condition);
```

### The important difference

Look at this:

```
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Output:

```
10
```

Even though:

```
10 < 5 → false
```

# 3. `for` Loop

The `for` loop is commonly used when you **know how many times** you want to repeat something.

There are three parts:

```
for (int i = 1; i <= 5; i++)
     ────────   ───────  ───
     initialize condition update
```

### How it works

```
1. int i = 1
       ↓
2. i <= 5 ?
       ↓
3. print i
       ↓
4. i++
       ↓
5. i <= 5 ?
       ↓
   repeat...
```

## Enhanced for Loop / for-each

The **enhanced for loop** (also called the **for-each loop**) is used to easily iterate through every element of an array or collection.

Syntax:

for (dataType variable : array) {
    // code
}

Example:

for (int n : nums) {
    System.out.println(n);
}

`n` = current element
`nums` = array

Meaning:
"Take each value from nums and put it into n."

Use:
Normal for → when index is needed
Enhanced for → when only values are needed