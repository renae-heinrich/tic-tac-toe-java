import java.util.ArrayList;
import java.util.List;


public class Board {

    private final List<List<Character>> character;

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
                if(column == 2 && row ==2){
                    break;
                } else if(column == 2){
                    sb.append('\n');
                } else sb.append(' ');
            }
        }
        
        return sb.toString();
    }

    public void setPosition(int x, int y) {
        int row = x -1;
        int col = y - 1;

        if(character.get(row).get(col).equals('.')) {
            character.get(row).set((col), 'X');
        } else{System.out.println("Oh no, a piece is already at this place! Try again...");}

    }















}
