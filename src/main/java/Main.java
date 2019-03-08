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

                String[] userToken = userInput.split(",");

                int x = 0;
                int y = 0;
                if (userToken[0].matches("[0-9]+") && userToken[1].matches("[0-9]+")){
                    x = Integer.parseInt(userToken[0]);
                    y = Integer.parseInt(userToken[1]);
                }

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                   game.gameState(GameState.INVALID_POSITION);
                    continue;
                }

                turnPlayed = game.takeTurn(x, y, game.getCurrentPlayer().getToken());
                if (!turnPlayed) {
                    game.gameState(GameState.POSITION_OCCUPIED);
                }
            } while (!turnPlayed);
            game.gameState(GameState.SHOW_BOARD);
        }
        game.gameState(GameState.WIN_DRAW);
    }
}
