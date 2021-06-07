package NewYorkerApp;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateOfferTest {


    @Test
    public void calculatePrice() {
        CalculateOffer cal = new CalculateOffer();
        assertEquals(9855.0, cal.calculatePrice(8), 5.0);
        // the maximum delta between expecteds and actuals for which both numbers are still considered equal.
    }
}