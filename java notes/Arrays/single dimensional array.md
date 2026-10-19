## 1. What is an Array?

An **array** is a collection of values of the **same data type**, stored under one variable name.

## single dimensional array

int[] nums = {10, 20, 30};

### Why use an array?

When you need to store **multiple values of the same type**.

nums
 ↓
┌────┬────┬────┐
│ 10 │ 20 │ 30 │
└────┴────┴────┘
  0    1    2     ← index

## 2. Creating an Array

### Direct initialization

```
int[] nums = {10, 20, 30, 40};
```

### Specify size

```
int[] nums = new int[5];
```

This creates space for **5 integers**.