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
                String[] userToken = userInput.split(",");
                // if userToken array length is one, assuming user is typing q
                if(userToken.length == 1){
                    for(String input : userToken){
                        // checking if input is q, if its not: need to prompt them to start again
                        if(input.equalsIgnoreCase("q")){
                            System.out.println("Give up!");
                            break;

                        } else {break;}
                    }
                }else {
                    for(String input : userToken){
                        int x = Integer.parseInt(input.valueOf(0));
                        int y = Integer.parseInt(input.valueOf(1));
                        //make sure input[i] is a number between 1, 3 and assign to x and y respectively
                    } return x, y;
                }
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
