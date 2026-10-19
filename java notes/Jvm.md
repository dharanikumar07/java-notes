-> java virtual machine
-> JVM is a program/software that **runs Java bytecode**.
-> JVM is the runtime environment that executes Java bytecode.

steps 

Hello.java
   ↓
Java Compiler (javac)
   ↓
Hello.class
   ↓
Bytecode
   ↓
JVM
   ↓
Machine Code
   ↓
CPU


-> The **Java bytecode is platform independent**, but the **JVM is platform dependent**.

-> JVM is platform dependent because a JVM is implemented specifically for the underlying operating system and hardware. However, Java bytecode is platform independent because the same bytecode can run on different platforms using their respective JVMs.

              Hello.class
             (Bytecode)
                   │
       ┌───────────┼───────────┐
       ↓           ↓           ↓
 Windows JVM   Linux JVM   macOS JVM
       ↓                 ↓                             ↓
   Windows             Linux                   macOS


**-> refer handwritten notes for the diagram**