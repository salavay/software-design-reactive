package am.s_mukhamedzhanov.sd.service;

import am.s_mukhamedzhanov.sd.model.Account;
import am.s_mukhamedzhanov.sd.model.Currency;
import am.s_mukhamedzhanov.sd.model.Item;
import am.s_mukhamedzhanov.sd.repository.AccountRepository;
import am.s_mukhamedzhanov.sd.repository.ItemRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final CurrencyExchangeService currencyExchangeService;

    public ItemService(ItemRepository itemRepository, AccountRepository accountRepository, CurrencyExchangeService currencyExchangeService) {
        this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;
        this.currencyExchangeService = currencyExchangeService;
    }

    public Mono<Item> create(String name, double price, Currency currency) {
        Item item = new Item(name, price, currency);
        return itemRepository.save(item);
    }

    public Flux<Item> showProductsForUser(long userId) {
        Flux<Item> items = itemRepository.findAll();
        Mono<Account> userMono = accountRepository.findById(userId);

        return items.flatMap(item -> userMono.map(user -> {
            item.currency = user.currency;
            item.price = currencyExchangeService.convert(item.price, item.currency, user.currency);
            return item;
        }));
    }


}
