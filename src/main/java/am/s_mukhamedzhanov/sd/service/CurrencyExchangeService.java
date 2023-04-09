package am.s_mukhamedzhanov.sd.service;

import am.s_mukhamedzhanov.sd.model.Currency;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyExchangeService {
    public final static Map<Currency, Double> rates = new HashMap<>();
    static {
        rates.put(Currency.RUB, 1.0);
        rates.put(Currency.AMD, 5d);
        rates.put(Currency.USD, 80d);
        rates.put(Currency.EUR, 90d);
    }

    public double convert(double amount, Currency curCur, Currency curToConvert) {
        return amount * (rates.get(curCur) / rates.get(curToConvert));
    }
}
