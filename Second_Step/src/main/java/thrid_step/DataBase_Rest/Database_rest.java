package thrid_step.DataBase_Rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thrid_step.Model_Rest.Person_rest;
import thrid_step.Repositories_Rest.ProductRepository_Rest;

@Configuration

public class Database_rest {

    private static final Logger logger = LoggerFactory.getLogger(Database_rest.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository_Rest productRepository_rest) {


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Person_rest person1 = new Person_rest("nam");
                Person_rest person2 = new Person_rest("an");
                Person_rest person3 = new Person_rest("chau");
                logger.info("insert data : " + productRepository_rest.save(person1));
                logger.info("insert data : " + productRepository_rest.save(person2));
                logger.info("insert data : " + productRepository_rest.save(person3));

            }
        };
    }
}
