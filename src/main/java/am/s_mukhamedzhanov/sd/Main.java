package am.s_mukhamedzhanov.sd;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableReactiveMongoRepositories
@SpringBootApplication
public class Main extends AbstractReactiveMongoConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return "mongo";
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
}
