package fishtank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * A fish tank simulation.
 */
public class FishTank {

  /** The width of a character. */
  public static final int charWidth = 6;
  /** The height of a character. */
  public static final int charHeight = 10;
  /** (int)(480/10) rows. */
  public static int maxRow = ((int) 480 / 10);
  /** (int) (640/6) column. */
  public static int maxCol = ((int) 640 / 6); 
  /** An obj is an Item. */
  static Item myLittleFishies = new Item();
  /** List of creatures. */
  static ArrayList<Item> creatures = new ArrayList<Item>();
  /** List of bubbles. */
  static ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
  /** List of seaweeds. */
  static ArrayList<Seaweed> seaweeds = new ArrayList<Seaweed>();
  /** List of crabs. */
  static ArrayList<Crab> crabs = new ArrayList<Crab>();
  
  /**
   * Start the fishies!
   * 
   * @param pars ignored. Why is this normally called args when the thing is called a parameter?
   */
  public static void main(String[] pars) {

    // The window in which the fish swim.
    FishFrame ff = new FishFrame();
    ff.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(23, 18);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(6, 12);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(17, 4);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(15, 28);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(15, 36);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(16, 35);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(16, 35);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(16, 18);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(23, 18);
    creatures.add(myLittleFishies);
    myLittleFishies = new Fish();
    ((Fish) myLittleFishies).setLocation(6, 12);
    creatures.add(myLittleFishies);
    myLittleFishies = new HungryFish();
    ((HungryFish) myLittleFishies).setLocation(10, 33);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(6);
    ((Seaweed) myLittleFishies).setLocation(24, 33);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(7);
    ((Seaweed) myLittleFishies).setLocation(32, 25);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(5);
    ((Seaweed) myLittleFishies).setLocation(13, 25);
    creatures.add(myLittleFishies);
    myLittleFishies = new Crab();
    ((Crab) myLittleFishies).setLocation(maxRow,6);
    creatures.add(myLittleFishies);
    myLittleFishies = new Crab();
    ((Crab) myLittleFishies).setLocation(maxRow,20);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(12);
    ((Seaweed) myLittleFishies).setLocation(24, maxRow);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(10);
    ((Seaweed) myLittleFishies).setLocation(40, maxRow);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(16);
    ((Seaweed) myLittleFishies).setLocation(60, maxRow);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(10);
    ((Seaweed) myLittleFishies).setLocation(90, maxRow);
    creatures.add(myLittleFishies);
    myLittleFishies = new Seaweed(10);
    ((Seaweed) myLittleFishies).setLocation(75, 26);
    creatures.add(myLittleFishies);

    

    // Show it all!
    ff.setSize(640, 480);
    ff.setLocation(10, 10);
    ff.setVisible(true);

    // Every .3 seconds, tell each item in the fishtank to take
    // a turn.
    while (true) {
      for (Item i : creatures) {
        if (i != null) {
          // HungryFish is also Fish, the only difference is the appearance.
          if (i instanceof Fish) {
            ((Fish) i).move();
          } else if (i instanceof Seaweed) {
            seaweeds.add((Seaweed) i);
            ((Seaweed) i).move();
          } else if (i instanceof Crab) {
            crabs.add((Crab) i);
            ((Crab) i).move();  
          }
        }
      }
      // Create the bubbles.
      for (Bubble heybub : bubbles) {
        if (heybub.row < 0) {
          heybub = null;
        } else {
          heybub.move();
        }
      }
      // Crab eating seaweed.
      for (Seaweed sw : seaweeds) {
        for (Crab crab : crabs) {
          if ((crab.col == sw.row) & (sw != null) & (crab != null) & (crab.row == sw.col)) {
            sw.len = 0;
          }
        }
      }

      // Tell the fishtank to redraw itself.
      ff.repaint();

      // Wait .3 seconds before redoing the queue.
      try {
        Thread.sleep(100);
      } catch (Exception exp) {
        System.exit(-1);
      }
     
    }
  }
}
