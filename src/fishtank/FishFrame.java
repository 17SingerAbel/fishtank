package fishtank;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * Displays the fish tank.
 */
public class FishFrame extends JFrame {

  /** My Serializable id. */
  private static final long serialVersionUID = 1409191926708912242L;

  /**
   * Paints this fish tank.
   *
   * @param graphy the graphics context to use for painting.
   */
  public void paint(Graphics graphy) {

    // Get my width and height.
    int wid = getBounds().width;
    int hei = getBounds().height;

    // Paint the window white.
    graphy.setColor(Color.white);
    graphy.fillRect(0, 0, wid, hei);

    // Tell all the fishtank items to draw themselves.
    for (Item i : FishTank.creatures) {
      i.draw(graphy);
    }
    for (Bubble i: FishTank.bubbles) {
      if (i != null) {
        ((Bubble) i).draw(graphy);
      }

    }

  }
}
