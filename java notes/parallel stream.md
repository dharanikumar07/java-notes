
Processes stream data concurrently using multiple worker threads.

```java
list.parallelStream()
```

or

```java
list.stream().parallel()
```

### Flow

```text
Collection
    ↓
Split into tasks
    ↓
Multiple worker threads
    ↓
Process
    ↓
Combine result
```

### Important

- Uses **ForkJoinPool.commonPool()** by default.
    
- Does **NOT** create one thread per element.
    
- Uses `Spliterator` to split the source.
    
- `forEach()` → order NOT guaranteed.
    
- `forEachOrdered()` → maintains encounter order.
    
- Parallel ≠ always faster.
    
- Avoid shared mutable data.
    

### Good for

```text
Large data
+ Independent operations
+ CPU-intensive work
```

### Avoid when

```text
Small data
I/O / blocking work
Order is very important
Shared mutable state
```

### Interview Answer

> **Parallel Stream divides stream processing into tasks and executes those tasks concurrently using multiple worker threads, usually through the ForkJoin common pool.**

### Remember

```text
Sequential:
ONE FLOW → PROCESS

Parallel:
SPLIT → MULTIPLE TASKS → PROCESS → COMBINE
```