import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean playerOneTurn = true;
        System.out.println("Welcome to Tic Tac Toe!\n");
        System.out.println("Here's the current board\n");
        System.out.println(game.showBoard());
        while (!game.hasEnded()) {


            boolean turnPlayed = false;
            do {

                System.out.print(game.getCurrentPlayer().getName() + " enter a coordinate x,y to place your " + game.getCurrentPlayer().getToken() + " or enter 'q' to give up: ");
                String userInput  = scanner.next();
                if(userInput.equalsIgnoreCase("q")){
                    game.forfeit();
                    break;
                }

                String[] userToken = userInput.split(",");

                int x = 0;
                int y = 0;
                if (userToken[0].matches("[0-9]+") && userToken[1].matches("[0-9]+")){
                    x = Integer.parseInt(userToken[0]);
                    y = Integer.parseInt(userToken[1]);
                }

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Not a valid coordinate");
                    continue;
                }

                turnPlayed = game.takeTurn(x, y, game.getCurrentPlayer().getToken());
                if (!turnPlayed) {
                    System.out.println("Position occupied");
                }
            } while (!turnPlayed);
            System.out.println(game.showBoard());
        }
        if (game.playerWins()) {

            System.out.println(game.getCurrentPlayer().getName() + " wins!");
        } else {
            System.out.println("Game ended in draw");
        }
    }
}
