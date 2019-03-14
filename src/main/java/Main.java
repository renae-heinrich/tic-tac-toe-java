import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        game.gameState(GameState.START);

        while (!game.hasEnded()) {


            boolean turnPlayed = false;
            do {
                game.gameState(GameState.INSTRUCT);
                String userInput  = scanner.next();
                if(userInput.equalsIgnoreCase("q")){
                    game.gameState(GameState.FORFEIT);

                    break;
                }

                String[] coordinates = userInput.split(",");

                int x = 0;
                int y = 0;
                if (coordinates[0].matches("[0-9]+") && coordinates[1].matches("[0-9]+")){
                    x = Integer.parseInt(coordinates[0]);
                    y = Integer.parseInt(coordinates[1]);
                }


//                if (checkBoundary(game, x, y)) continue;

                turnPlayed = game.takeTurn(x, y, game.getCurrentPlayer().getToken());
                if (!turnPlayed) {
                    game.gameState(GameState.POSITION_OCCUPIED);
                }
            } while (!turnPlayed);
            game.gameState(GameState.SHOW_BOARD);
        }
        game.gameState(GameState.WIN_DRAW);
    }
//
//    private static boolean checkBoundary(Game game, int x, int y) {
//        if (x < 1 || x > 3 || y < 1 || y > 3) {
//           game.gameState(GameState.INVALID_POSITION);
//            return true;
//        }
//        return false;
//    }
}
