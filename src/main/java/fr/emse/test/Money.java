package fr.emse.test;

public class Money {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money)) return false;
        Money other = (Money) o;
        return fAmount == other.fAmount
            && fCurrency.equals(other.fCurrency);
    }

    @Override
    public int hashCode() {
        return fCurrency.hashCode() + fAmount;
    }

}
