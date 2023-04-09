package am.s_mukhamedzhanov.sd.controller;

import am.s_mukhamedzhanov.sd.model.Currency;
import am.s_mukhamedzhanov.sd.model.Item;
import am.s_mukhamedzhanov.sd.service.ItemService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/item/")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    private static class CreateItemRequest {
        public String name;
        public double price;
        public Currency currency;
    }

    @PostMapping("/create")
    public Mono<Item> create(@RequestBody CreateItemRequest request) {
        return itemService.create(request.name, request.price, request.currency);
    }

    @GetMapping("loadAll")
    public Flux<Item> loadAllForUser(@RequestParam long userId) {
        return itemService.showProductsForUser(userId);
    }
}
