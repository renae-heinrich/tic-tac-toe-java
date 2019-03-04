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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Character c = character.get(j).get(i);
                sb.append(c);               
                if(j == 2){
                    sb.append('\n');
                } else sb.append(' ');
            }
        }
        


        return sb.substring(0, sb.length() -1);
    }

    //public method to allow game to set new position of X or O

   
   


}
