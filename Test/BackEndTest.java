import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Repeatable;

public class BackEndTest {
    BackEnd dTest = new BackEnd();

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
    public void checkGameOverAfterAddScore100Points() {
        dTest.setP1Score(99);
        dTest.setP2Score(99);
        dTest.addScore();
        boolean gameOver = dTest.gameOver();
        System.out.println(gameOver);
        Assert.assertTrue(gameOver);
    }


}