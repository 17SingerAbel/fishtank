package fishtank;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Seaweed.
 */
public class Seaweed extends Item {

  /** The number of weed segments. */
  int len;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /**
   * Constructs a new seaweed item at the specified cursor location (col, row),l segments tall.
   */
  public Seaweed(int len) {
    super();
    this.len = len;
    color = Color.green.darker().darker();
  
  }
  
  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param graphy the graphics context in which to draw this item.
   */
  @Override
  public void draw(Graphics graphy) {

    // WWhich way does the first segment lean?
    boolean leanR = leanRight;
    // Draw a "/" seaweed segment: even numbered and leaning to the
    // right.
    for (int i = 0; i < len; i++) {
      if ((i % 2 == 0)) { 
        if (leanR) {
          // Draw the string
          drawString(graphy, "/", row, (-i + col));
        } else  {
          drawString(graphy,"\\", row, (-i + col));
        }
      }
      // Draw a "/" seaweed segment: odd numbered and leaning to the right.
      if (i % 2 == 1) { 
        if (leanR) {
          // Draw the string
          drawString(graphy, "\\", row, (-i + col));
        } else {
          drawString(graphy,"/",row, (-i + col));
        }
      }
    }
  }
    
  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param g the graphics context in which to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location, col.
   * @param y the y-coordinate of the string's cursor location, row.
   */
  void drawString(Graphics g, String s, int x, int y) {
    g.setColor(color);
    g.setFont(FONT);
    FontMetrics fm = g.getFontMetrics(FONT);
    // Override because the different coordinates.
    g.drawString(s, x * fm.charWidth('W'), y * fm.getAscent());
  }



  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  @Override
  public void move() {
    leanRight = !leanRight;
  }




}
