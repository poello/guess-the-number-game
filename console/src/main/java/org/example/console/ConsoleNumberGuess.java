package org.example.console;

import lombok.extern.slf4j.Slf4j;
import org.example.Game;
import org.example.MessageGenerator;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == constructors ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == events ==
    @EventListener(ContextRefreshedEvent.class) // instead of adding start() method parameter ContextRefreshedEvent contextRefreshedEvent
    public void start() {
        log.info("start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            System.out.println("\nEnter your guess number: \r");
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
    }

















}
