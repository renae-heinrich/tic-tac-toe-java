import java.util.Scanner;

public class Game {

    private final Board board;

    private boolean playerForfeitedGame;

    private Player player1;
    private Player player2;


    int turnCount = 0;


    public Game() {
        board = new Board();
        playerForfeitedGame = false;
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
    }

    public Board getBoard() {
        return board;
    }

    public boolean takeTurn(int x, int y, char playerToken) {
        boolean turn = board.setPosition(x, y, playerToken);
        if (turn && !playerWins()) {
            turnCount++;
        }

        return turn;
    }

//    public boolean forfeit(){
//        System.out.println(getCurrentPlayer().getName() + " gives up.");
//        turnCount++;
//        return playerForfeitedGame = true;
//    }

    public boolean hasEnded() {

        return !board.inPlay() || board.playerWins() || playerForfeitedGame;
    }

    public boolean playerWins() {

        return board.playerWins() || playerForfeitedGame;
    }

    public String showBoard() {
        return board.showBoard();
    }

    public Player getCurrentPlayer() {
        if (turnCount % 2 == 0) {
            return player1;
        }
        return player2;

    }

    public void gameState(GameState state) {
        switch (state) {
            case FORFEIT:
                System.out.println(getCurrentPlayer().getName() + " gives up.");
                turnCount++;
                playerForfeitedGame = true;
            case WIN:
                if (playerWins()) {
                    System.out.println(getCurrentPlayer().getName() + " wins!");
                } else {
                    System.out.println("Game ended in draw");
                }

        }
    }
}
