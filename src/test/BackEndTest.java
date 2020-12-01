

import junit.framework.TestCase;
import org.junit.Assert;

public class BackEndTest extends TestCase {

    BackEnd backEnd = new BackEnd();

    public void testGetWinner() throws Exception{
        backEnd.setPlayer1("P1");
        backEnd.setPlayer2("P2");
        backEnd.setP1Score(99);
        backEnd.setP2Score(123);
        Assert.assertEquals("And the winner is P2 with 123 points!", backEnd.getWinner());
        backEnd.setP1Score(100);
        backEnd.setP2Score(99);
        Assert.assertEquals("And the winner is P1 with 100 points!", backEnd.getWinner());
        backEnd.setP1Score(0);
        backEnd.setP2Score(0);
        Assert.assertEquals("And the winner is P2 with 0 points!", backEnd.getWinner());
        tearDown();
    }
    public void testCurrentPlayerName() throws Exception {
        backEnd.setPlayer2("P1");
        backEnd.setPlayer2("P2");
        backEnd.randomStarter();
        if (backEnd.getCurrentPlayer()==1) {
            Assert.assertEquals("P1",backEnd.currentPlayerName());
        }
        else if (backEnd.getCurrentPlayer()==2) {
            Assert.assertEquals("P2", backEnd.currentPlayerName());
        }
    }
}
