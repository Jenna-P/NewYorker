package NewYorkerApp;

import org.junit.Test;

import Logic.CalculateOffer;

import static org.junit.Assert.*;

public class CalculateOfferTest {

   public CalculateOffer cal = new CalculateOffer();


    @Test
    public void calculatePrice() {

        assertEquals(9855.0, cal.calculatePrice(8), 5.0);
        // the maximum delta between expecteds and actuals for which both numbers are still considered equal.
    }

    @Test
    public void calculateDoor() {
        assertEquals(9888, cal.calculateDoor(6, "Enkeltdør uden låsekasse"), 0.5);

    }
}