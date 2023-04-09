package am.s_mukhamedzhanov.sd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    @Id
    public Long id;
    public String name;
    public double price;
    public Currency currency;

    public Item(String name, double price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
}
