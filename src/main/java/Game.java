public class Game {

    private final Board board;

    public Game(){
        board = new Board();

    };
    public Board getBoard(){
        return board;
    }


    public void takeTurn(int x, int y){
        board.setPosition(x,y);

    }

}
