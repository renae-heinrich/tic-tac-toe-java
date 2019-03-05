import org.junit.Assert;
import org.junit.Ignore;
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
        Game game = new Game();
        game.takeTurn(1, 1);
        game.takeTurn(1,2);
        game.takeTurn(1,3);
        Board board = game.getBoard();
        String result = board.showBoard();


        Assert.assertEquals("X X X\n. . .\n. . .", result);
    }

    @Test
    public void  whenPlayerGetsThreeInARowVerticallyPlayerWins() {
        Game game = new Game();
        game.takeTurn(1, 1);
        game.takeTurn(2, 1);
        game.takeTurn(3, 1);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\nX . .\nX . .", result);
    }

    @Test
    public void  whenPlayerGetsThreeInARowDiagonallyBottomLeftToTopRightPlayerWins() {
        Game game = new Game();
        game.takeTurn(3, 1);
        game.takeTurn(2, 2);
        game.takeTurn(1, 3);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals(". . X\n. X .\nX . .", result);
    }

    @Test
    public void whenPlayerGetsThreeInARowDiagonallyTopLeftToBottomRightPlayerWins() {
        Game game = new Game();
        game.takeTurn(1, 1);
        game.takeTurn(2, 2);
        game.takeTurn(3,3);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. X .\n. . X", result);
    }

    @Test
    public void whenAllPositionsFilledButNoPlayerWinsItsADraw() {
        Game game = new Game();
        game.takeTurn(1, 1);
        game.takeTurn(1, 2);
        game.takeTurn(1, 3);
        game.takeTurn(2,1);
        game.takeTurn(2, 2);
        game.takeTurn(2, 3);
        game.takeTurn(3, 1);
        game.takeTurn(3, 2);
        game.takeTurn(3, 3);
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X X X\nX X X\nX X X", result);
    }

}