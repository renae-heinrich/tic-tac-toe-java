public class Game {

    public Game(){


    };
    public Board getBoard(){
        return new Board();
    }


    //public method to allow game to set new position of X or O

    // getting position from game.takeTurn(1, 1)

    // now mean character.get(0,0) will now equal "X"

    // need to affect original board and when showBoard is called, it will display the new changes
    public void takeTurn(int x, int y){

        character.get(x).set((y), 'X');


    }



}
