package am.s_mukhamedzhanov.sd.controller;

import am.s_mukhamedzhanov.sd.model.Account;
import am.s_mukhamedzhanov.sd.model.Currency;
import am.s_mukhamedzhanov.sd.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/account/")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private static class CreateAccountRequest {
        public String name;
        public Currency currency;
    }

    @PostMapping("/create")
    public Mono<Account> create(@RequestBody CreateAccountRequest request) {
        return accountService.create(request.name, request.currency);
    }
}
