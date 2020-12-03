import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;

import java.security.spec.ECField;

public class IqStringHandlerTest extends TestCase {

    public void testCountVowels1() {
        //fixme funkar ej med versaler
        Assert.assertEquals(2, Iqh.countVowels("ZOO"));
    }

    public void testCountVowels2() {
        Assert.assertEquals(0,Iqh.countVowels("qwrt134214p"));
    }

    public void testCountVowels3() {
        Assert.assertEquals(6,Iqh.countVowels("Three little monkeys"));
    }

    public void testCountConsonants() {
        Assert.assertEquals(3,Iqh.countConsonants("Three"));
    }

    public void testCountConsonants2() {
        //fixme registrerar versaler som konsonanter
        Assert.assertEquals(5,Iqh.countConsonants("Assimilate"));
    }

    public void testSize1() {
        Assert.assertEquals(4,Iqh.size("Four"));
    }

    public void testSize2() {
        Assert.assertEquals(11,Iqh.size("1Aa_2Bb 3Cc"));
    }

    public void testSize3() {
        Assert.assertEquals(0,Iqh.size(""));
    }

    public void testInvert1() {
        Assert.assertEquals("!cinap t'noD", Iqh.invert("Don't panic!"));
    }

    public void testInvert2() {
        Assert.assertEquals("OLLEH", Iqh.invert("HELLO"));
    }

    public void testInvert3() {
        Assert.assertEquals("10000100 10000110 00110110 11110010 00000100 01010110 10100110 00010010",
                Iqh.invert("01001000 01100101 01101010 00100000 01001111 01101100 01100001 00100001"));
    }
    @After
    public void tD() throws Exception {
        tearDown();
    }
}
