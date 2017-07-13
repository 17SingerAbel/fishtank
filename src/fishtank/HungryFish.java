package fishtank;

import java.awt.Color;

/**
 * A fish.
 */
public class HungryFish extends Fish {

  /**
   * Constructs a new hungry fish.
   */
  HungryFish() {
    super();
    color = Color.cyan.darker().darker().darker();
    appearance = "><MEHUNGRY>";
    goingRight = true;
  }


}
