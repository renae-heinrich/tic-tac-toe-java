import org.junit.Assert;
import org.junit.Test;


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
        game.takeTurn(1, 1, 'X');
        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. . .\n. . .", result);

    }

    @Test
    public void whenPlayerTriesToPlacePieceOnOccupiedSpaceShouldThrowError() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        boolean turnResult = game.takeTurn(1,1, 'O');

        Assert.assertFalse(turnResult);

        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. . .\n. . .", result);
     }

    @Test
    public void whenPlayerForfeitsOtherPlayerWins() {
        Game game = new Game();
        game.setPlayerForfeitedGame(true);

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());

    }



    @Test
    public void whenPlayerGetsThreeInARowHorizontallyPlayerWins() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(2,1, 'O');
        game.takeTurn(1,2, 'X');
        game.takeTurn(2,2, 'O');
        game.takeTurn(1,3, 'X');

//        Board board = game.getBoard();
//        String result = board.showBoard();
//
//        Assert.assertEquals("X X X\nO O .\n. . .", result);

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());
    }

    @Test
    public void  whenPlayerGetsThreeInARowVerticallyPlayerWins() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(1,2, 'O');
        game.takeTurn(2,1, 'X');
        game.takeTurn(2,2, 'O');
        game.takeTurn(3,1, 'X');

//        Board board = game.getBoard();
//        String result = board.showBoard();
//
//        Assert.assertEquals("X O .\nX O .\nX . .", result);

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());
    }

    @Test
    public void  whenPlayerGetsThreeInARowDiagonallyBottomLeftToTopRightPlayerWins() {
        Game game = new Game();
        game.takeTurn(3,1, 'X');
        game.takeTurn(1,2, 'O');
        game.takeTurn(2,2, 'X');
        game.takeTurn(1,1, 'O');
        game.takeTurn(1,3, 'X');

//        Board board = game.getBoard();
//        String result = board.showBoard();
//
//        Assert.assertEquals("O O X\n. X .\nX . .", result);

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());
    }

    @Test
    public void whenPlayerGetsThreeInARowDiagonallyTopLeftToBottomRightPlayerWins() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(1,2, 'O');
        game.takeTurn(2,2, 'X');
        game.takeTurn(2,1, 'O');
        game.takeTurn(3,3, 'X');

//        Board board = game.getBoard();
//        String result = board.showBoard();
//
//        Assert.assertEquals("X O .\nO X .\n. . X", result);

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());
    }

    @Test
    public void whenAllPositionsFilledButNoPlayerWinsItsADraw() {
        Game game = new Game();
        game.takeTurn(1,1, 'O');
        game.takeTurn(1,2, 'X');
        game.takeTurn(1,3, 'O');
        game.takeTurn(2,1, 'X');
        game.takeTurn(2,2, 'O');
        game.takeTurn(2,3, 'X');
        game.takeTurn(3,1, 'X');
        game.takeTurn(3,2, 'O');
        game.takeTurn(3,3, 'X');

//        Board board = game.getBoard();
//        String result = board.showBoard();
//
//        Assert.assertEquals("O X O\nX O X\nX O X", result);

        Assert.assertTrue(game.hasEnded());
        Assert.assertFalse(game.playerWins());
    }

}