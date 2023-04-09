package am.s_mukhamedzhanov.sd.repository;

import am.s_mukhamedzhanov.sd.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, Long> {
}
