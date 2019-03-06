public class Game {

    private final Board board;

    private boolean playerForfeitedGame;


    public Game(){
        board = new Board();
        playerForfeitedGame = false;
    }
    public void setPlayerForfeitedGame(boolean playerForfeitedGame) {
        this.playerForfeitedGame = playerForfeitedGame;
    }

    public Board getBoard(){
        return board;
    }

    public boolean takeTurn(int x, int y, char playerToken) {
        return board.setPosition(x, y, playerToken);
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

}
