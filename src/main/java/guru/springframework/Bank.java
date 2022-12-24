package guru.springframework;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair,Integer> rates = new HashMap<>();

    public Money reduce(Expression expression, String currency) {
        return expression.reduce(this, currency);
    }

    public void addRate(String from, String to, int rate) {
        Pair pair = new Pair(from,to);
        rates.put(pair,rate);
    }

    public int rate(String from, String to) {
        if(from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from,to));
    }
}
