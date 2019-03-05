import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean playerOneTurn = true;
        Character playerOneToken = 'X';
        Character playerTwoToken = 'O';
        while (true) {
            if (game.hasEnded()) {
                break;
            }
            Character token = playerOneTurn ? playerOneToken : playerTwoToken;
            boolean turnPlayed;
            do {
                System.out.println("Enter X:");
                int x = scanner.nextInt();
                System.out.println("Enter Y:");
                int y = scanner.nextInt();
                turnPlayed = game.takeTurn(x, y, token);
                if (!turnPlayed) {
                    System.out.println("Position occupied");
                }
            } while (!turnPlayed);
            System.out.println(game.showBoard());
            playerOneTurn = !playerOneTurn;
        }
        if (game.playerWins()) {
            System.out.println("Player " + (playerOneTurn ? "1" : "2") + " wins");
        } else {
            System.out.println("Game ended in draw");
        }
    }
}
