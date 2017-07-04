package line.bot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BotMain {

    public static void main(String[] args) {
        System.out.println("** Spring Boot application Start **");
        SpringApplication.run(BotMain.class, args);
    }
}
