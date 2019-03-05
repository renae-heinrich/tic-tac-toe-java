public class Game {

    private final Board board;

    public Game(){
        board = new Board();
    }

    public Board getBoard(){
        return board;
    }

    public boolean takeTurn(int x, int y, char playerToken) {
        return board.setPosition(x, y, playerToken);
    }

    public boolean hasEnded() {
        return !board.inPlay() && !board.playerWins();
    }

    public boolean playerWins() {
        return board.playerWins();
    }

    public String showBoard() {
        return board.showBoard();
    }

}
