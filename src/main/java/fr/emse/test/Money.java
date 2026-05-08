package fr.emse.test;

public class Money implements IMoney {

    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {return fAmount;}
    public String currency() {return fCurrency;}

    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency()))
            return new Money(amount() + m.amount(), currency());
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        return mb.addMoney(this);
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