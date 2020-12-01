import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Repeatable;

public class BackEndTest {
    BackEnd dTest = new BackEnd();

    @Test()
    public void throwDiceTest() {
        for(int i = 0; i<100; i++) {
            dTest.throwDice();
            int diceNumber = dTest.getDice();
            System.out.println(diceNumber);
            Assert.assertTrue(diceNumber >= 1 && diceNumber <= 20);
        }
    }

    @Test
    public void checkRoundCounterAfterDiceThrow() {
        dTest.throwDice();
        int roundCounter = dTest.getRoundCounter();
        System.out.println(roundCounter);
        Assert.assertTrue(roundCounter != 0 && roundCounter <=3);
    }


}