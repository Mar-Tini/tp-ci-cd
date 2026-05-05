import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestExample {

    @Test
    void testAddition() {
        assertEquals(4,+ 2 + 2);
    }
   
    @Test
    void testMoney() {
        Money m1 = new Money(10, "USD");
        Money m2 = new Money(15, "USD");
        Money m3 = m1.add(m2);
        assertEquals(25, m3.amount());
        assertEquals("USD", m3.currency());
    }
}

class Money {
        private int fAmount;

        private String fCurrency;

        public Money(int amount, String currency) { 
                fAmount = amount;
                fCurrency = currency;
        }

        public int amount() {
            return fAmount;
        }
        
        public String currency() {
            return fCurrency;
        }

        public Money add(Money m) {
                 return new Money(amount() + m.amount(), currency());
        }
}