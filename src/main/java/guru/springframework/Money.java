package guru.springframework;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    protected String currency() {
        return currency;
    }
    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount == money.amount && currency.equals(money.currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
       int rate =  bank.rate(currency, to);
       return new Money(amount / rate, to);
    }
    @Override
    public int hashCode() {
        return amount;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
