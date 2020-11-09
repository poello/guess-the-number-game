package org.example.console;

import lombok.extern.slf4j.Slf4j;
import org.example.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j // automatically declares Logger log variable
public class Main {
//    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class); // here listener is poked

        // close context (container)
        context.close();
    }
}
