package guru.springframework;

public interface Expression {
    public Money reduce(Bank bank, String currency);
}
