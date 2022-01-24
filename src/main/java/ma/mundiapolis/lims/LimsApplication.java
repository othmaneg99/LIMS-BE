package ma.mundiapolis.lims;

import ma.mundiapolis.lims.service.LimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LimsApplication.class, args);
    }
    @Autowired
    private LimsService limsService;
    @Override
    public void run(String... args) throws Exception {
        limsService.initArticles();
    }
}
