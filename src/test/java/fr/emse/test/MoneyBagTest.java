package fr.emse.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyBagTest {
    private Money    f12CHF, f14CHF, f7USD, f21USD;
    private MoneyBag fMB1, fMB2;

    @BeforeEach
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD  = new Money(7,  "USD");
        f21USD = new Money(21, "USD");
        fMB1   = new MoneyBag(f12CHF, f7USD);
        fMB2   = new MoneyBag(f14CHF, f21USD);
    }
    
    @Test
    public void testSimplification() {

        Money minus12CHF = new Money(-12, "CHF");
        IMoney result = minus12CHF.add(fMB1); 


        if (result instanceof MoneyBag) {
            result = ((MoneyBag) result).simplify();
        }

        assertEquals(new Money(7, "USD"), result);
    }


}
