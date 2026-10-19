
Meaning:
One thing → many forms.

Types:
1. Compile-time polymorphism
   → Method Overloading

2. Runtime polymorphism
   → Method Overriding
   → Dynamic Method Dispatch

Overloading:
Same method name + different parameters
Decision happens at compile time.

Overriding:
Child provides its own implementation
of parent's method.
Decision happens at runtime.

Example:
Animal a = new Dog();

Reference type → Animal
Object type    → Dog

Reference type → decides accessible members
Object type    → decides overridden method execution

Upcasting:
Child object → Parent reference

Animal a = new Dog();