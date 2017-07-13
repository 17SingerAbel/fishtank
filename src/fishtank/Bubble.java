package fishtank;

import java.awt.Color;

/**
 * A bubble.
 */
public class Bubble extends Item {
  
  /**
   * Constructs a new bubble at the specified cursor location (row, col).
   *
   * @param row the x coordinate of the bubble's cursor location.
   * @param col the y coordinate of the bubble's cursor location.
   */
  Bubble() {
    super();
    // Get a nice-looking grey for the bubble
    color = Color.gray.darker().darker().darker();
    // start off with . as the appearance
    appearance = ".";
  }
  
  /**
   * Let the bubble grow up.
   */
  public void grow() {
    // Figure out whether to grow, if at all.
    doub = Math.random();
    // Occasionally change a . to a o or a o to a O
    if (doub < 0.05) {
      // If the appearance is a ., change it to an o
      if (appearance.equals(".")) {
        appearance = "o";
      } else if (appearance.equals("o")) {
        appearance = "O";
      }
    }
  }
  
  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  @Override
  public void move() {
    doub = Math.random();
    if (doub < 0.33) {
      floatStraightUp();
    } else if (doub < 0.66) {
      floatRightUp();
    } else {
      /* heybub.d >= 0.66 */ 
      floatLeftUp();
    }
  }
   
  /**
   * Causes this item to take its turn in the fish-tank simulation, moving straight up.
   */
  public void floatStraightUp() {
    // Move upwards.
    row--;
    // Move the bubble.
    grow();
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation, moving up and left.
   */
  public void floatLeftUp() {

    // Move upwards.
    row--;
    // Prevent the bubble over left bound.
    if (col >= FishTank.charWidth) {
      // Left
      col -= 1;
    }
    // Move the bubble.
    grow();
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void floatRightUp() {

    // Move upwards.
    row--;
    // Prevent the bubble over right bound.
    if ( col <= FishTank.maxCol) {
      // Right
      col += 1;
    }
    // Move the bubble.
    grow();
  }

}
