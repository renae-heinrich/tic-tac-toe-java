import org.junit.Assert;
import org.junit.Ignore;
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
    public void newGameHasCurrentPlayerSetTo1() {

        //new game takes in board
        //get board
        //check empty
        Game game1 = new Game();

        Assert.assertEquals(game1.getCurrentPlayer().getName(), "Player 1");
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
    public void whenPlayer1PlacesXOnBoardShouldSwitchPlayer() {

        //new game
        Game game = new Game();
        game.takeTurn(1, 1, 'X');

        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 2");
    }

    @Test
    public void whenPlayer2TriesToPlacePieceOnOccupiedSpaceShouldThrowError() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(1,1, 'O');

        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals("X . .\n. . .\n. . .", result);
    }

    @Test
    public void whenPlayer2TriesToPlacePieceThatsOccupiedStillPlayerTwosTurn() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(1,1, 'O');

        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 2");
    }


    @Test
    public void whenPlayer1ForfeitsOtherPlayerWins() {
        Game game = new Game();
        game.forfeit();

        Assert.assertTrue(game.hasEnded());
        Assert.assertTrue(game.playerWins());
//        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 2");
    }


    @Test
    public void whenPlayer1ForfeitsShouldSwitchPlayer() {
        Game game = new Game();
        game.forfeit();

        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 2");
    }

    @Test
    public void playerCoordinatesEnteredOutOfBounds() {
        Game game = new Game();
        game.takeTurn(5,7, 'X');

        Board board = game.getBoard();
        String result = board.showBoard();

        Assert.assertEquals(". . .\n. . .\n. . .", result);
    }

    @Test
    public void whenPlayer1GetsThreeInARowHorizontallyPlayerWins() {
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
//        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 1");
    }

    @Test
    public void whenPlayer1GetsThreeInARowHorizontallyPlayer1Wins() {
        Game game = new Game();
        game.takeTurn(1,1, 'X');
        game.takeTurn(2,1, 'O');
        game.takeTurn(1,2, 'X');
        game.takeTurn(2,2, 'O');
        game.takeTurn(1,3, 'X');

        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 1");
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
//        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 1");
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
        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 1");
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
//        Assert.assertEquals(game.getCurrentPlayer().getName(), "Player 1");
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