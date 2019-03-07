//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Game game = new Game();
//        Scanner scanner = new Scanner(System.in);
//        boolean playerOneTurn = true;
//        System.out.println("Welcome to Tic Tac Toe!\n");
//        System.out.println("Here's the current board\n");
//        System.out.println(game.showBoard());
//        Character playerOneToken = 'X';
//        Character playerTwoToken = 'O';
//        while (!game.hasEnded()) {
//            Character token = playerOneTurn ? playerOneToken : playerTwoToken;
//
//            boolean turnPlayed = false;
//            do {
//
//                System.out.print("\nPlayer " + (playerOneTurn ? "1" : "2") + " enter a coordinate x,y to place your " + (playerOneTurn ? "X" : "O" ) + " or enter 'q' to give up: ");
//                String userInput  = scanner.next();
//                if(userInput.equalsIgnoreCase("q")){
//                    playerOneTurn = !playerOneTurn;
//                    game.setPlayerForfeitedGame(true);
//                    System.out.println("Player " + (!playerOneTurn ? "1" : "2") + " gives up.");
//                    break;
//                }
//
//                String[] userToken = userInput.split(",");
//
//                int x = 0;
//                int y = 0;
//                if (userToken[0].matches("[0-9]+") && userToken[1].matches("[0-9]+")){
//                    x = Integer.parseInt(userToken[0]);
//                    y = Integer.parseInt(userToken[1]);
//                }
//
//                if (x < 1 || x > 3 || y < 1 || y > 3) {
//                    System.out.println("Not a valid coordinate");
//                    continue;
//                }
//
//                turnPlayed = game.takeTurn(x, y, token);
//                if (!turnPlayed) {
//                    System.out.println("Position occupied");
//                }
//            } while (!turnPlayed);
//            System.out.println(game.showBoard());
//            playerOneTurn = !playerOneTurn;
//        }
//        if (game.playerWins()) {
//            playerOneTurn = !playerOneTurn;
//            System.out.println("Player " + (playerOneTurn ? "1" : "2") + " wins!");
//        } else {
//            System.out.println("Game ended in draw");
//        }
//    }
//}
