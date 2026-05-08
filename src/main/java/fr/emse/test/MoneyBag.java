package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {

    private Vector<Money> fMonies = new Vector<>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money[] bag) {
        for (Money m : bag) {
            appendMoney(m);
        }
    }

    private void appendMoney(Money m) {

        if (fMonies.isEmpty()) {
            fMonies.add(m);
            return;
        }

        int i = 0;

        while (i < fMonies.size()
                && !fMonies.get(i).currency().equals(m.currency())) {
            i++;
        }

        if (i >= fMonies.size()) {

            fMonies.add(m);

        } else {

            Money existing = fMonies.get(i);

            fMonies.set(i,
                    new Money(
                            existing.amount() + m.amount(),
                            m.currency()));
        }
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof MoneyBag)) {
            return false;
        }

        MoneyBag other = (MoneyBag) o;

        return fMonies.equals(other.fMonies);
    }

    @Override
    public int hashCode() {
        return fMonies.hashCode();
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }

    @Override
    public IMoney addMoney(Money m) {

        Money[] bag = new Money[fMonies.size() + 1];

        for (int i = 0; i < fMonies.size(); i++) {
            bag[i] = fMonies.get(i);
        }

        bag[fMonies.size()] = m;

        return new MoneyBag(bag);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag mb) {

        Vector<Money> all = new Vector<>();

        all.addAll(fMonies);
        all.addAll(mb.fMonies);

        Money[] bag = all.toArray(new Money[0]);

        return new MoneyBag(bag);
    }
}