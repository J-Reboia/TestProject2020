import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


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

    public void testSize1() { //fixme Efter 102 tecken blir talen negativa
        Assert.assertEquals(103,Iqh.size("2223333333333444444444455555555556666666666777777777788888888889999999999000000000010101010101010101010"));
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

    public void testLowerHalf1() {
        Assert.assertEquals("One", Iqh.lowerHalf("OneTwo"));
    }

    public void testLowerHalf2() {
        Assert.assertNull(Iqh.lowerHalf("One Two"));
    }

    public void testLowerHalf3() {
        Assert.assertEquals("@F_1",Iqh.lowerHalf("@F_1337!"));
    }

    public void testUpperHalf1() {
        Assert.assertEquals("Two",Iqh.upperHalf("OneTwo"));
    }

    public void testUpperHalf2() {
        Assert.assertNull(Iqh.upperHalf("Seven"));
    }

    public void testReadString1() {
        PrintWriter out;
        Scanner fileScanner;
        String s = "";
        try {
            File temp = File.createTempFile("temp", ".txt");
            out = new PrintWriter(temp);
            fileScanner = new Scanner(temp);
            out.print("Lorem ipsum");
            out.println("dolor sit amet.");
            out.close();
            while (fileScanner.hasNextLine()) {
                s = fileScanner.nextLine();
            }
            Assert.assertEquals(s,Iqh.readString(temp.getAbsolutePath()));//fixme fungerar nu men behöver ordna att filen alltid raderas
            temp.deleteOnExit();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void testReadString2() {
        File temp = new File("temp.txt");
        Assert.assertEquals(".txt",Iqh.readString("temp.txt"));//om ingen sökväg hittas, och argumentet är av jämn längd, returneras sista halvan i filepath
        Assert.assertEquals(null,Iqh.readString("temp.jpeg")); //om argumentet är av ojämn längd returneras null
    }

    public void testScatterString1() {
        for (int i = 0; i<1000000; i++) {
            Assert.assertNotEquals("123456789", Iqh.scatterString("123456789")); //fixme metoden verkar ej ha validering för att return blir annorlunda än input
        }
    }

    public void testZip1() {
        Assert.assertEquals("adbecf", Iqh.zip("abc","def"));
    }
    public void testZip2() {
        Assert.assertEquals("\\/\\/\\/", Iqh.zip("\\\\\\", "///"));
    }
    public void testZip3() {
        Assert.assertEquals("HOellalo", Iqh.zip("Hello","Ola")); //fixme olika längder på argumenten fungerar ej
    }

    public void testUnZip1() {
        /*
        String[] arr = Iqh.unzip("abcdef");//fixme metod verkar ej finnas
        Assert.assertEquals("abc", arr[0]);
        Assert.assertEquals("def",arr[1]);
         */
    }

    public void testRemoveVowels1() {

        //Assert.assertEquals("zbr",Iqh.removeVowels("zebra"));//fixme metod verkar ej finnas
    }


    @After
    public void tD() throws Exception {
        tearDown();
    }
}
