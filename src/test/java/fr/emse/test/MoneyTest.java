package fr.emse.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    
    private Money f12CHF;
    private Money f14CHF;

    @BeforeEach
    public void setUp() {
        f12CHF = new Money(13, "CHF");
        f14CHF = new Money(14, "CHF");
    }


    @Test
    public void testEquals() {
        assertTrue(!f12CHF.equals(null));
        assertEquals(f12CHF, f12CHF);
        assertEquals(f12CHF, new Money(13, "CHF"));
        assertTrue(!f12CHF.equals(f14CHF));

    }

}
