public class Game {

    private final Board board;

    private boolean playerForfeitedGame;

    private Player player1;
    private Player player2;

    int turnCount = 0;


    public Game(){
        board = new Board();
        playerForfeitedGame = false;
         player1 = new Player("Player 1", 'X');
         player2 = new Player("Player 2", 'O');

    }

    public Board getBoard(){
        return board;
    }

    public void takeTurn(int x, int y, char playerToken) {
        boolean turn = board.setPosition(x,y,playerToken);
        if(turn){
            turnCount++;
        }

    }

    public boolean forfeit(){
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
        if(turnCount % 2 == 0){
            return player1;
        }
        return player2;

    }




}
