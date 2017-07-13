package fishtank;

import java.awt.Color;

/**
 * A fish.
 */
public class Fish extends Item {
  /** Indicates whether this fish is moving right. */
  protected boolean goingRight;
  
  /**
   * Constructs a new fish.
   */
  protected Fish() {
    super();
    color = Color.cyan.darker().darker().darker();
    appearance = "><>";
    goingRight = true;
  }

  /**
   * Causes this fish to blow a bubble.
   */
  protected void blowBubble() {
    Bubble bub = new Bubble();
    bub.setLocation(row, col);
    FishTank.bubbles.add(bub);
  }

  /**
   * Build and initialize this fish's forward and backward appearances.
   */
  private String reverseAppearance() {
    String reverse = "";
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case ')':
          reverse += '(';
          break;
        case '(':
          reverse += ')';
          break;
        case '>':
          reverse += '<';
          break;
        case '<':
          reverse += '>';
          break;
        case '}':
          reverse += '{';
          break;
        case '{':
          reverse += '}';
          break;
        case '[':
          reverse += ']';
          break;
        case ']':
          reverse += '[';
          break;
        default:
          reverse += appearance.charAt(i);
          break;
      }
    }
    //System.out.println("Turned around" + this.appearance);
    return reverse;
  }

  
  /**
   * Turns this fish around, causing it to reverse direction.
   */
  protected void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }
  

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  @Override
  public void move() {

    // Move one spot to the right or left.
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
    
    if (row > FishTank.maxRow) {
      row --;
    } else if (row < FishTank.charHeight) {
      row ++;
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

    // Figure out whether to move up or down, or neither.
    doub = Math.random();
    if (doub < 0.1) {
      row += 1;
    } else if (doub < 0.2) {
      row -= 1;
    }
  }
}
