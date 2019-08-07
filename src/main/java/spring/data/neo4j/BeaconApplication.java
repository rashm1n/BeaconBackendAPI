package spring.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("spring.data.neo4j.repositories")
public class BeaconApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeaconApplication.class,args);
    }
}
