import java.util.ArrayList;
import java.util.List;


public class Board {

    private final List<List<Character>> character;
//    private static boolean inPlay = true;

    public Board() {

        character = new ArrayList();
        character.add(new ArrayList());
        character.add(new ArrayList());
        character.add(new ArrayList());

        character.get(0).add('.');
        character.get(0).add('.');
        character.get(0).add('.');
        character.get(1).add('.');
        character.get(1).add('.');
        character.get(1).add('.');
        character.get(2).add('.');
        character.get(2).add('.');
        character.get(2).add('.');

    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Character c = character.get(column).get(row);
                sb.append(c);
                if(column == 2 && row == 2){
                    break;
                } else if(column == 2){
                    sb.append('\n');
                } else sb.append(' ');
            }
        }
        
        return sb.toString();
    }

    public boolean setPosition(int x, int y, char playerToken) {
        int row = y - 1;
        int col = x - 1;

        if (character.get(row).get(col).equals('.')) {
            // do I want to do this action here, then return true?? or just return true?
            character.get(row).set(col, playerToken);
            return true;
        } else {
            return false;
        }
    }

    public boolean inPlay() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (character.get(column).get(row).equals('.')) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean playerWins() {
       if(checkWin()){
           return true;
       }

       return false;

    }

    private boolean callPlayingSquare(char playerToken){
        if((character.get(0).get(0).equals(playerToken) && character.get(0).get(1).equals(playerToken) && character.get(0).get(2).equals(playerToken))
                || (character.get(1).get(0).equals(playerToken) && character.get(1).get(1).equals(playerToken) && character.get(1).get(2).equals(playerToken))
                || (character.get(2).get(0).equals(playerToken) && character.get(2).get(1).equals(playerToken) && character.get(2).get(2).equals(playerToken))
                || (character.get(0).get(0).equals(playerToken) && character.get(1).get(0).equals(playerToken) && character.get(2).get(0).equals(playerToken))
                || (character.get(0).get(1).equals(playerToken) && character.get(1).get(1).equals(playerToken) && character.get(2).get(1).equals(playerToken))
                || (character.get(0).get(2).equals(playerToken) && character.get(1).get(2).equals(playerToken) && character.get(2).get(2).equals(playerToken))
                || (character.get(2).get(0).equals(playerToken) && character.get(1).get(1).equals(playerToken) && character.get(0).get(2).equals(playerToken))
                || (character.get(2).get(2).equals(playerToken) && character.get(1).get(1).equals(playerToken) && character.get(0).get(0).equals(playerToken)))
        {
            return true;
        }
        return false;
    }

    //use that on checkHorizontally etc
    private boolean checkWin() {
        if(callPlayingSquare('X') || callPlayingSquare('O')){
            return true;
        } return false;
    }




















}
