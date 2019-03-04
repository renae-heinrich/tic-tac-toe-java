import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGameHasEmptyBoard() {

        //new game takes in board
        //get board
        //check empty
        Game game1 = new Game();
        Board board = game1.getBoard();
        String result = board.showBoard();

        Assert.assertEquals(". . .\n. . .\n. . .", result);

    }

    @Test
    public void whenPlayer1PlacesXOnBoardShouldShowPieceOnBoard() {

        //new game
        Game game = new Game();
        game.takeTurn(1, 1);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. . .\n. . .", result);

    }

    @Test
    public void whenPlayerTriesToPlacePieceOnOccupiedSpaceShouldThrowError() {
        Game game = new Game();
        game.takeTurn(1, 1);
        game.takeTurn(1,1);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. . .\n. . .", result);
    }

    @Test
    public void whenPlayerForfeitsOtherPlayerWins() {
    }

    @Test
    public void whenPlayerGetsThreeInARowHorizontallyPlayerWins() {
    }

    @Test
    public void  whenPlayerGetsThreeInARowVerticallyPlayerWins() {
    }

    @Test
    public void  whenPlayerGetsThreeInARowDiagonallyBottomLeftToTopRightPlayerWins() {
    }

    @Test
    public void whenPlayerGetsThreeInARowDiagonallyTopLeftToBottomRightPlayerWins() {
    }

    @Test
    public void whenAllPositionsFilledButNoPlayerWinsItsADraw() {
    }

}