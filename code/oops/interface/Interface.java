interface Computer {

    public void ram();

    public void cpu();
}

@FunctionalInterface
interface Monitor {

    public void monitorSpecs();
}



class Dell implements Computer, Monitor {

    public void ram() {
        System.out.println("8 gb ram");
    }

    public void cpu() {
        System.out.println("Intel core i5");
    }

    public void monitorSpecs()
    {
      System.out.println("40 inch lcd display");
    }
}

class Interface {

    public static void main(String[] args) {
      Computer obj = new Dell();
      obj.cpu();
      obj.ram();

      Monitor obj1 = new Dell();
      obj1.monitorSpecs();

      Dell dell = new Dell();
      dell.cpu();
      dell.ram();
      dell.monitorSpecs();;
    }
}
