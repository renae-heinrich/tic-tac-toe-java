public class Game {

    private final Board board;

    public Game(){
        board = new Board();

    };
    public Board getBoard(){
        return board;
    }


    public void takeTurn(int x, int y){

        int turnCount = 0;

        while(turnCount < 9) {
            if (turnCount % 2 == 0) {
                char playerToken = 'X';
                board.setPosition(x, y, playerToken);
                turnCount++;
            } else {
                char playerToken = 'O';
                board.setPosition(x, y, playerToken);
                turnCount++;
            }
        }



    }

}
