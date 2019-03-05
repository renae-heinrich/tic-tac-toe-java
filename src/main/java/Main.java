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
                System.out.println("Enter a coordinate x,y to place your " + (playerOneTurn ? "X" : "O" ) + " or enter 'q' to give up: ");
                String userInput  = scanner.next();
                if(userInput.equalsIgnoreCase("q")){
                    game.playerWins();
                    game.hasEnded();
                    System.out.println("Player " + (playerOneTurn ? "1" : "2") + " gives up. Player " + (!playerOneTurn ? "1" : "2") + " wins!");
                    break;
                }

                String[] userToken = userInput.split(",");



                int x = Integer.parseInt(userToken[0]);
                int y = Integer.parseInt(userToken[1]);


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
