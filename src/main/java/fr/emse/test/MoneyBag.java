package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<>();

    MoneyBag(Money m1, Money m2) {
        appendMoney(m1); appendMoney(m2);
    }

    MoneyBag(Money[] bag) {
        for (Money m : bag) appendMoney(m);
    }


    // Constructeur package-private pour addMoney()
    MoneyBag(MoneyBag mb, Money m) {
        for (Money x : mb.fMonies) appendMoney(x);
        appendMoney(m);
    }

    MoneyBag(MoneyBag mb1, MoneyBag mb2) {
        for (Money x : mb1.fMonies) appendMoney(x);
        for (Money x : mb2.fMonies) appendMoney(x);
    }

    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) { fMonies.add(m); return; }
        int i = 0;
        while (i < fMonies.size() &&
               !fMonies.get(i).currency().equals(m.currency())) i++;
        if (i >= fMonies.size()) {
            fMonies.add(m);
        } else {
            Money existing = fMonies.get(i);
            int newAmount  = existing.amount() + m.amount();
            if (newAmount == 0)
                fMonies.remove(i);        
            else
                fMonies.set(i, new Money(newAmount, m.currency()));
        }
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        return new MoneyBag(this, mb);
    }
    
    // Retourne un Money simple si un seul élément reste
    public IMoney simplify() {
        if (fMonies.size() == 1) return fMonies.get(0);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MoneyBag)) return false;
        MoneyBag other = (MoneyBag) o;
        return fMonies.equals(other.fMonies);
    }

    @Override
    public int hashCode() { return fMonies.hashCode(); }

}