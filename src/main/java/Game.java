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
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            gameState(GameState.INVALID_POSITION);
            return true;
        }

        boolean turn = board.setPosition(x, y, playerToken);
        if (turn && !playerWins()) {
            turnCount++;
            }

            return turn;
        }


    public boolean forfeit(){
        System.out.println(getCurrentPlayer().getName() + " gives up.");
        turnCount++;
        return playerForfeitedGame = true;
    }

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

    public GameState getGameState(){
        if(forfeit()){
            return GameState.FORFEIT;
        } return GameState.CONTINUE;
    }
    // Main query the Game, instead of the Game query the Main. Switch responsibilities.


    public void gameState(GameState state) {
        switch (state) {
            case FORFEIT:
                System.out.println(getCurrentPlayer().getName() + " gives up.");
                turnCount++;
                playerForfeitedGame = true;
                break;
            case WIN_DRAW:
                if (playerWins()) {
                    System.out.println(getCurrentPlayer().getName() + " wins!");
                } else {
                    System.out.println("Game ended in draw");
                }
                break;
            case START:
                System.out.println("Welcome to Tic Tac Toe!\n");
                System.out.println("Here's the current board\n");
                System.out.println(showBoard() + "\n");
                break;
            case POSITION_OCCUPIED:
                System.out.println("Position occupied");
                break;
            case INVALID_POSITION:
                System.out.println("Not a valid coordinate");
                break;
            case SHOW_BOARD:
                System.out.println(showBoard());
                break;
            case INSTRUCT:
                System.out.print(getCurrentPlayer().getName() + " enter a coordinate x,y to place your " + getCurrentPlayer().getToken() + " or enter 'q' to give up: ");
                break;
        }
    }
}
