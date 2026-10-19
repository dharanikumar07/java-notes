import advcalc.AdvanceCalc;
import calc.SimpleCalc;

public class Package{
  public static void main(String[] args) {
      AdvanceCalc ac = new AdvanceCalc();
      SimpleCalc sc = new SimpleCalc();
      ac.show();
      sc.display();
  }
}