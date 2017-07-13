package fishtank;

import java.awt.Color;

/**
 * A crab is always stay at bottom of the fish tank.
 * @author Yeqi Sang
 *
 */
public class Crab extends Item {
  /** Indicates whether this crab is moving right. */
  boolean goingRight;
  
  /**
   * Constructs a new crab.
   */
  @SuppressWarnings("static-access")
  Crab() {
    super();
    color = Color.cyan.brighter().brighter().red;
    appearance = ">(ii)<";
    goingRight = true;
    // A crab is always at the bottom of the fish tank.
    this.row = FishTank.maxRow;
  }
  
  /**
   * Causes this crab to blow a bubble.
   */
  protected void blowBubble() {
    Bubble bub = new Bubble();
    bub.setLocation(row, col);
    FishTank.bubbles.add(bub);
  }
  
  
  /**
   * Turns this crab around, causing it to reverse direction.
   */
  protected void turnAround() {
    goingRight = !goingRight;
  }
  
  /**
   * Eat the seaweed.
   * 
   * @param sw One seaweed.
   */
  public void eatSeaweed(Seaweed sw) {
    if (col == sw.row) {
      sw.len = sw.len - 1;    
    }
  }
  
  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {
    if (goingRight) {
      if (col < FishTank.maxCol) {
        col = col + 1;
      } else {
        turnAround();
      }
    } else {
      if (col > FishTank.charWidth) {
        col -= 1;
      } else {
        turnAround();
      }
    }

    // Figure out whether I blow a bubble.
    doub = Math.random();
    if (doub < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    doub = Math.random();
    if (doub < 0.1) {
      turnAround();
    }    
  }
}
