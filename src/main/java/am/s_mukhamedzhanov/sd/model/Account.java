package am.s_mukhamedzhanov.sd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

    @Id
    public Long id;
    public Currency currency;
    public String username;

    public Account(Currency currency, String username) {
        this.currency = currency;
        this.username = username;
    }
}
