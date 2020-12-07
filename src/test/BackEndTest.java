
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class BackEndTest {
    BackEnd dTest = new BackEnd();

    @Test
    public void player1ScoreTest() {
        dTest.setPlayer1("P1");
        dTest.setP1Score(49);
        Assert.assertEquals("P1 score is: 49", dTest.player1Score());
        dTest.setP1Score(-99);
        Assert.assertEquals("P1 score is: -99", dTest.player1Score());
    }

    @Test
    public void player2ScoreTest() {
        dTest.setPlayer2("P2");
        dTest.setP2Score(999);
        Assert.assertEquals("P2 score is: 999", dTest.player2Score());
    }

    @Test
    public void throwDiceTest() {
        for(int i = 0; i<1000; i++) {
            dTest.throwDice();
            int diceNumber = dTest.getDice();
            System.out.println(diceNumber);
            Assert.assertTrue(diceNumber >= 1 && diceNumber <= 20);
        }
    }

    @Test
    public void checkRoundCounterAfterDiceThrow() {
        dTest.throwDice();
        dTest.throwDice();
        int roundCounter = dTest.getRoundCounter();
        System.out.println(roundCounter);
        Assert.assertTrue(roundCounter != 0 && roundCounter <=3);
        dTest.addScore();
    }
    @Test
    public void checkRoundCounterAfterAddScore() {
        dTest.throwDice();
        dTest.throwDice();
        dTest.addScore();
        int roundCounter = dTest.getRoundCounter();
        System.out.println(roundCounter);
        Assert.assertTrue(roundCounter == 0);
    }
    @Test
    public void checkDiceAfterAddScore() {
        dTest.throwDice();
        dTest.addScore();
        int dice = dTest.getDice();
        System.out.println(dice);
        Assert.assertTrue(dice == 0);
    }
    @Test
    public void checkGameOverAfterAddScore100PointsP1() {
        dTest.setP1Score(100);
        dTest.setP2Score(99);
        dTest.addScore();
        boolean gameOver = dTest.gameOver();
        System.out.println(gameOver);
        Assert.assertTrue(gameOver);
    }

    @Test
    public void checkGameOverAfterAddScore100PointsP2() {
        dTest.setP1Score(99);
        dTest.setP2Score(100);
        dTest.addScore();
        boolean gameOver = dTest.gameOver();
        System.out.println(gameOver);
        Assert.assertTrue(gameOver);
    }

    @Test
    public void checkGameOverAfterAddScoreLessThen100Points() {
        dTest.setP1Score(99);
        dTest.setP2Score(99);
        dTest.addScore();
        boolean gameOver = dTest.gameOver();
        System.out.println(gameOver);
        Assert.assertFalse(gameOver);
    }
    @Test
    public void testGetWinner() throws Exception{
        dTest.setPlayer1("P1");
        dTest.setPlayer2("P2");
        dTest.setP1Score(99);
        dTest.setP2Score(123);
        Assert.assertEquals("And the winner is P2 with 123 points!", dTest.getWinner());
        dTest.setP1Score(100);
        dTest.setP2Score(99);
        Assert.assertEquals("And the winner is P1 with 100 points!", dTest.getWinner());
        dTest.setP1Score(4000);
        dTest.setP2Score(2000);
        Assert.assertEquals("And the winner is P1 with 4000 points!", dTest.getWinner());
        dTest.setP1Score(400);
        dTest.setP2Score(2000);
        Assert.assertEquals("And the winner is P1 with 400 points!", dTest.getWinner());
        dTest.setP1Score(-100);
        dTest.setP2Score(2038);
        Assert.assertEquals("And the winner is P2 with 2038 points!", dTest.getWinner());
        dTest.setP1Score(0);
        dTest.setP2Score(0);
        Assert.assertEquals("And the winner is P2 with 0 points!", dTest.getWinner());
    }

    @Test
    public void testCurrentPlayerNameAndRandomStarter() {
        for (int i = 0; i < 50; i++) {
            dTest.setPlayer1("P1");
            dTest.setPlayer2("P2");
            dTest.randomStarter();
            if (dTest.getCurrentPlayer() == 1) {
                Assert.assertEquals("P1", dTest.currentPlayerName());
                System.out.println(dTest.currentPlayerName());
            } else if (dTest.getCurrentPlayer() == 2) {
                Assert.assertEquals("P2", dTest.currentPlayerName());
                System.out.println(dTest.currentPlayerName());
            }
        }
    }



}