package am.s_mukhamedzhanov.sd.service;

import am.s_mukhamedzhanov.sd.model.Account;
import am.s_mukhamedzhanov.sd.model.Currency;
import am.s_mukhamedzhanov.sd.repository.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> create(String username, Currency currency) {
        Account account = new Account(currency, username);
        return accountRepository.save(account);
    }
}
