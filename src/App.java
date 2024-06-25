import java.util.Scanner;

import poker_game.service.BlackJack;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        BlackJack blackJack = new BlackJack();
        Scanner scanner = new Scanner(System.in);
        
        blackJack.start(scanner);

        scanner.close();
        System.out.println("game over ~ bye!");
    }
    
}
