package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * An item in fish tank.
 * @author yeqi sang
 *
 */
public class Item {
  /** How this item appears on the screen. */
  String appearance;
  /** This item's first coordinate, row. */
  int row;
  /** This item's second coordinate, column. */
  int col;
  /** The color of this item. */
  Color color;
  /** The font used to draw instances of this class. */
  static Font FONT = new Font("Monospaced", Font.PLAIN, 10);
  /** Use for random movement left and right. */
  double doub;

  Item(){
      
  }
  
  /**
   * Set this item's location.
   * 
   * @param a the first coordinate.
   * @param b the second coordinate.
   */
  void setLocation(int a, int b) {
    row = a;
    col = b;
  }
    
  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param g the graphics context in which to draw the string.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  void drawString(Graphics g, String s, int x, int y) {
    g.setColor(color);
    g.setFont(FONT);
    FontMetrics fm = g.getFontMetrics(FONT);
    g.drawString(s, y * fm.charWidth('W'), x * fm.getAscent());   
  }
    

  /**
   * Draws this item.
   *
   * @param g the graphics context in which to draw this item.
   */
  void draw(Graphics g) {
    drawString(g, appearance, row, col);
  }
    
  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move(){
    
  }
    
}
