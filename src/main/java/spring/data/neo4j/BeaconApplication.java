package spring.data.neo4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
@EnableNeo4jRepositories("spring.data.neo4j.repositories")
public class BeaconApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeaconApplication.class,args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("spring.data.neo4j"))
                .build()

                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "BLE Beacon API",
                "API to be used in Final Year Project Group 18 - Indoor Navigation for the Visually Impaired",
                "2.0",
                "Free to Use",
                new Contact("Ravindu Rashmin","https://www.linkedin.com/in/ravindu-rashmin-2aa634a8/","rashmin.ravindu@gmail.com"),
                "API Licence",
                "https://www.linkedin.com/in/ravindu-rashmin-2aa634a8/",
                Collections.emptyList());
    }
}
