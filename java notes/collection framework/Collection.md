# 1. What does Collection API mean?

The **Java Collections API** is a set of **interfaces and classes** provided by Java to store and manipulate groups of objects.

Instead of creating your own data structures every time, Java provides ready-made ones.

```
Java Collections API
        │
        ├── List
        │     ├── ArrayList
        │     ├── LinkedList
        │     └── Vector
        │
        ├── Set
        │     ├── HashSet
        │     ├── LinkedHashSet
        │     └── TreeSet
        │
        └── Queue
              ├── PriorityQueue
              └── Deque
```

There is also `Map`, which is part of the **Collections Framework**, but it does **not** extend `Collection`.

```
Map
├── HashMap
├── LinkedHashMap
└── TreeMap
```

### Simple meaning

> **Collections API = ready-made data structures + methods to store and manipulate data.**