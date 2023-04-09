package am.s_mukhamedzhanov.sd.repository;

import am.s_mukhamedzhanov.sd.model.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, Long> {
}
