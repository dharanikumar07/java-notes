
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

public class Main {

    public static void main(String[] args) {
        //up Casting 
        Animal a = new Dog();
        a.eat();

        //we cannot acess
        //a.bark
        //Down casting
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.eat();
            d.bark();
        }

//       a ─────────→ Dog Object
//              ├── Animal part
//              └── Dog part
// d ──────────┘
// Now you can access Dog-specific methods through d.
// d.eat();   // ✅
// d.bark();  // ✅
    }
}
