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
                System.out.print("enter a coord x,y to place your O or enter 'q' to give up: ");
                String userInput  = scanner.next();
                if(userInput.equalsIgnoreCase("q")){
                    System.out.println("Player " + (playerOneTurn ? "1" : "2") + " gives up. Player " + (!playerOneTurn ? "1" : "2") + " wins!");
                    game.playerWins();
                    game.hasEnded();
                }

                // if String equals q ignore case, "Player whatever wins, inPlay = false;
                // split string, if length is 1, and doesnt equal q, prompt user to enter valid input
                // otherwise, split the two strings and parse them as integers.
                // need to do a for loop and make the x the value of the first string, and y the value of the second string

                String[] userToken = userInput.split(",");



                int x = Integer.parseInt(userToken[0]);
                int y = Integer.parseInt(userToken[1]);
                // if userToken array length is one, assuming user is typing q

                //need to return the values of x y but says dont have return type

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
