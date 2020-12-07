import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class IqStringHandlerTestClass {
    public String testString102Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrstuvwxyzåäö 0123456789 !#¤%&/()=?`´^¨'-_.,;:+*********"; //Complete test string to check for all possible scenarios at 102 chars long.

    @Test
    public void countVowelsTest() {
        int numberOfVowels = Iqh.countVowels(testString102Chars);
        Assert.assertEquals(18, numberOfVowels); //Asserts the number of vowels in the string.
        //TODO Doesn't count uppercase letters.
    }

    @Test
    public void countConsonantsTest() {
        int numberOfConsonants = Iqh.countConsonants(testString102Chars);
        Assert.assertEquals(40, numberOfConsonants); //Asserts the number of consonants in the string.
        //TODO Seems to count all input instead of just vowels.
    }

    @Test
    public void sizeTestOver100Chars(){
        int sizeOfString = Iqh.size(testString102Chars);
        String  testString102CharsUnEven = testString102Chars + "*";
        int sizeOfStringOver100AndUnEven = Iqh.size(testString102CharsUnEven);

        Assert.assertEquals(102, sizeOfString); //Asserts testString102Chars is correctly counted.
        Assert.assertEquals(103, sizeOfStringOver100AndUnEven); //Asserts testString102Chars is correctly counted uneven and over 100 chars.
        //TODO inverts when the count is over 100 chars.
    }

    @Test
    public void sizeTestUnder100Chars(){
        int sizeOfString = Iqh.size("12345678");
        int sizeOfStringUnEven = Iqh.size("1234567");

        Assert.assertEquals(8, sizeOfString); //Asserts testString102Chars is correctly counted.
        Assert.assertEquals(7, sizeOfStringUnEven); //Asserts testString102Chars is correctly counted uneven and over 100 chars.
        //Works
    }

    @Test
    public void invertTest(){
        String output = Iqh.invert(testString102Chars);
        System.out.println(output);
        Assert.assertEquals("*********+:;,._-'¨^´`?=)(/&%¤#! 9876543210 öäåzyxwvutsrqponmlkjihgfedcba,ÖÄÅZYXWVUTSRQPONMLKJIHGFEDCBA", output); //Asserts testString102Chars i inverted.
        //Works
    }

    @Test
    public void lowerHalfTest() {
        String testStringUnEven = testString102Chars+ "*";
        String testStringEven = testString102Chars;
        String outputShouldBeNull = Iqh.lowerHalf(testStringUnEven);
        String outputShouldReturnHalf = Iqh.lowerHalf(testStringEven);
        System.out.println(outputShouldBeNull);
        Assert.assertNull(outputShouldBeNull);
        Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrst", outputShouldReturnHalf);
        //TODO Can't handle more then 50 chars.
    }

    @Test
    public void upperHalfTest(){
        String testStringUnEven = testString102Chars + "*";
        String testStringEven = "0123456789";
        String outputShouldBeNull = Iqh.upperHalf(testStringUnEven);
        String outputShouldReturnHalf = Iqh.upperHalf(testStringEven);
        System.out.println(outputShouldBeNull);
        Assert.assertNull(outputShouldBeNull);
        Assert.assertEquals("56789", outputShouldReturnHalf);
        //TODO Can't handle more then 50 chars.
    }

    @Test
    public void readStringTest() {
        PrintWriter out;
        Scanner fileScanner;
        String s = "";
        try {
            File temp = File.createTempFile("temp", ".txt");
            out = new PrintWriter(temp);
            fileScanner = new Scanner(temp);
            out.print("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrstu");
            out.println("vwxyzåäö 0123456789 !#¤%&/()=?`´^¨'-_.,;:+*********");
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

    @Test
    public void scatterStringTest() {
        String scatteredOutput = Iqh.scatterString(testString102Chars);
        System.out.println(scatteredOutput);

        Assert.assertNotEquals(scatteredOutput,testString102Chars); //Checking the initial testString102Chars is not equal to the expected scattered string.
        char[] charsTest = testString102Chars.toCharArray(); //Puts testString102Chars in an array.
        Arrays.sort(charsTest); //Sorts the testString102Chars Alphabetically
        String sortedTest = new String(charsTest); //Creates new sorted test string.

        char[] charsScattered = scatteredOutput.toCharArray(); //Puts charsScattered in an array.
        Arrays.sort(charsScattered); //Sorts the charsScattered Alphabetically
        String sortedScattered = new String(charsTest); //Creates new sorted string out of scattered.

        Assert.assertEquals(sortedTest, sortedScattered); //Asserts that both the initial string and scattered string is the same when sorted Alphabetically.
        //Works!
    }

    @Test
    public void zipTestEvenLines() {
        String firstHalf = "AbCdE";
        String secondHalf = "123/&";
        String shouldBe = "A1b2C3d/E&";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
        //TODO doesn't work. Removes the last char if uneven.
    }

    @Test
    public void zipTestUnEvenLines() {
        String firstHalf = "AbCdE";
        String secondHalf = "123/&%";
        String shouldBe = "A1b2C3d/E&%";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
        //TODO doesn't work. Removes the last char if uneven.
    }


    @Test
    public void zipTest102Chars() {
        String firstHalf = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrstu";
        String secondHalf = "vwxyzåäö 0123456789 !#¤%&/()=?`´^¨'-_.,;:+*********";
        String shouldBe = "AvBwCxDyEzFåGäHöI J0K1L2M3N4O5P6Q7R8S9T U!V#W¤X%Y&Z/Å(Ä)Ö=,?a`b´c^d¨e'f-g_h.i,j;k:l+m*n*o*p*q*r*s*t*u*";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
    }

    @Test
    public void unzipTest(){
        //Iqh.unzip
        //TODO doesn't work. Method doesn't seem to exist.
    }

    @Test
    public void removeVowels() {
        //String vowelLessString = Iqh.
        //TODO method doesn't seem to exist.

    }

}
