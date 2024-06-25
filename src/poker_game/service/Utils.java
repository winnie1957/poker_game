package poker_game.service;

import java.util.Scanner;

public class Utils {

    /** 判斷是否進行下一步? */
    public static boolean keep(Scanner scanner, String massage){
        System.out.print(massage + "(Y/N): ");

        String input = scanner.next().toUpperCase();
        if (input.equals("Y")) {
            return true;
        } else if (input.equals("N")) {
            return false;
        } else {
            System.out.println("請輸入有效的選項(Y/N)!");
            return keep(scanner, massage);
        }
    }
}
