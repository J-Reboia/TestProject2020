import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.After;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class IqStringHandlerTest extends TestCase {

    // testString102Chars (not a test, used in tests)
    public String testString102Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrstuvwxyzåäö 0123456789 !#¤%&/()=?`´^¨'-_.,;:+*********"; //Complete test string to check for all possible scenarios at 102 chars long.

    // ALPHABET alphabetUpper (not a test, used in tests)
    private ArrayList alphabetUpper() {
        char[] abcUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ".toCharArray();
        ArrayList<String> alphabetUpper = new ArrayList<>();
        for (int i = 0; abcUpper.length > alphabetUpper.size(); i++) {
            String s = String.valueOf(abcUpper[i]);
            alphabetUpper.add(s);
        }
        return alphabetUpper;
    }

    // alphabet alphabetLower (not a test)
    private ArrayList alphabetLower() {
        char[] abcLower = "abcdefghijklmnopqrstuvxyzåäö".toCharArray();
        ArrayList<String> alphabetLower = new ArrayList<>();
        for (int i = 0; abcLower.length > alphabetLower.size(); i++) {
            String s = String.valueOf(abcLower[i]);
            alphabetLower.add(s);
        }
        return alphabetLower;
    }



    // Tests for countConsonsnats();
    //  "Y" may be a consonant in english.
    @Test
    public void testCountConsonantsTest() {
        int numberOfConsonants = Iqh.countConsonants(testString102Chars);
        Assert.assertEquals(40, numberOfConsonants); //Asserts the number of consonants in the string.
        //TODO Seems to count all input instead of just vowels.
    }

    @Test
    public void testCountConsonants() {
        Assert.assertEquals(3,Iqh.countConsonants("Three"));
    }

    @Test
    public void testCountConsonants2() {
        //fixme registrerar versaler som konsonanter
          Assert.assertEquals(5,Iqh.countConsonants("Assimilate"));
    }

    @Test
    public void testCountConsonantsAlphabetUpper() {

        String consonant = "testCountConsonantsAlphabetUpper Consonant: ";
        String notC = "testCountConsonantsAlphabetUpper notC: ";

        for ( int i = 0; alphabetUpper().size() > i; i++) {
            String s = alphabetUpper().get(i).toString();
            Iqh.countConsonants(s);
            if (Iqh.countConsonants(s) == 1) {
                consonant = consonant + s;
            }
            else {
                notC = notC + s;
            }
        }
        System.out.println(consonant);
        System.out.println(notC);

        Assert.assertEquals(Iqh.countConsonants("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),21); // "29"
        Assert.assertEquals(Iqh.countConsonants("abcdefghijklmnopqrstuvxyzåäö"),21); // "19"
        Assert.assertEquals(Iqh.countConsonants("BCDFGHJKLMNPQRSTVWXYZ"),21);
        Assert.assertEquals(Iqh.countConsonants("AEIOUÅÄÖ"),0); // "8"
        Assert.assertEquals(Iqh.countConsonants("aeiouåäö"),0);  // "-1" whoa?!?!
        Assert.assertEquals(Iqh.countConsonants("ä"),-1); // WHYYYYYY??????

    }

    @Test
    public void testCountConsonantsAlphabetLower() {

        String consonant = "testCountConsonantsAlphabetLower Consonant: ";
        String notc = "testCountConsonantsAlphabetLower notc: ";

        for ( int i = 0; alphabetLower().size() > i; i++) {
            String s = alphabetLower().get(i).toString();
            Iqh.countConsonants(s);
            if (Iqh.countConsonants(s) == 1) {
                consonant = consonant + s;
            }
            else {
                notc = notc + s;
            }
        }
        System.out.println(consonant);
        System.out.println(notc);

        Assert.assertEquals(Iqh.countConsonants("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),21); // "29"
        Assert.assertEquals(Iqh.countConsonants("abcdefghijklmnopqrstuvxyzåäö"),21); // "19"
        Assert.assertEquals(Iqh.countConsonants("BCDFGHJKLMNPQRSTVWXYZ"),21);
        Assert.assertEquals(Iqh.countConsonants("AEIOUÅÄÖ"),0); // "8"
        Assert.assertEquals(Iqh.countConsonants("aeiouåäö"),0); // "-1" whoa?!?!
        Assert.assertEquals(Iqh.countConsonants("ä"),-1); // WHYYYYYY??????
    }



    // Tests for countVowels();
    //  "Y" may be a consonant in english.
    @Test
    public void testCountVowelsTest() {
        int numberOfVowels = Iqh.countVowels(testString102Chars);
        Assert.assertEquals(18, numberOfVowels); //Asserts the number of vowels in the string.
        //TODO Doesn't count uppercase letters.
    }

    @Test
    public void testCountVowels1() {
        //fixme funkar ej med versaler
        Assert.assertEquals(2, Iqh.countVowels("ZOO"));
    }

    @Test
    public void testCountVowels2() {
        Assert.assertEquals(0,Iqh.countVowels("qwrt134214p"));
    }

    @Test
    public void testCountVowels3() {
        Assert.assertEquals(6,Iqh.countVowels("Three little monkeys"));
    }

    @Test
    public void testCountVowelsAlphabetUpper() {

        String notV = "testCountVowelsAlphabetUpper notV: ";
        String vowels = "testCountVowelsAlphabetUpper Vowels: ";

        for ( int i = 0; alphabetUpper().size() > i; i++) {
            String s = alphabetUpper().get(i).toString();
            Iqh.countVowels(s);
            if (Iqh.countVowels(s) == 1) {
                vowels = vowels + s;
            }
            else {
                notV = notV + s;
            }
        }
        System.out.println(notV);
        System.out.println(vowels);

        Assert.assertEquals(Iqh.countVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),9); // "0" Sometings not sitting right
        Assert.assertEquals(Iqh.countVowels("abcdefghijklmnopqrstuvxyzåäö"),9);
        Assert.assertEquals(Iqh.countVowels("BCDFGHJKLMNPQRSTVWXYZ"),0);
        Assert.assertEquals(Iqh.countVowels("AEIOUÅÄÖ"),8); // "0"
        Assert.assertEquals(Iqh.countVowels("aeiouåäö"),8); // "9" ?!
        Assert.assertEquals(Iqh.countVowels("ä"),2); // WHYYYYYY?????? ä är en konsonant värde -1 och en vokal värde 2.

    }

    @Test
    public void testCountVowelsAlphabetLower() {
        String notv = "testCountVowelsAlphabetLower notv: ";
        String vowels = "testCountVowelsAlphabetLower vowels: ";

        for ( int i = 0; alphabetLower().size() > i; i++) {
            String s = alphabetLower().get(i).toString();
            Iqh.countVowels(s);
            if (Iqh.countVowels(s) == 1) {
                vowels = vowels + s;
            }
            else {
                notv = notv + s;
            }
        }
        System.out.println(notv);
        System.out.println(vowels);

        Assert.assertEquals(Iqh.countVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),9); // "0"
        Assert.assertEquals(Iqh.countVowels("abcdefghijklmnopqrstuvxyzåäö"),9);
        Assert.assertEquals(Iqh.countVowels("BCDFGHJKLMNPQRSTVWXYZ"),0);
        Assert.assertEquals(Iqh.countVowels("AEIOUÅÄÖ"),8); // "0"
        Assert.assertEquals(Iqh.countVowels("aeiouåäö"),8); // "9" ?!
        Assert.assertEquals(Iqh.countVowels("ä"),2); // WHYYYYYY??????

    }



    // invert();
    @Test
    public void testInvertTest(){
        String output = Iqh.invert(testString102Chars);
        System.out.println(output);
        Assert.assertEquals("*********+:;,._-'¨^´`?=)(/&%¤#! 9876543210 öäåzyxwvutsrqponmlkjihgfedcba,ÖÄÅZYXWVUTSRQPONMLKJIHGFEDCBA", output); //Asserts testString102Chars i inverted.
        //Works
    }

    @Test
    public void testInvert1() {
        Assert.assertEquals("!cinap t'noD", Iqh.invert("Don't panic!"));
    }

    @Test
    public void testInvert2() {
        Assert.assertEquals("OLLEH", Iqh.invert("HELLO"));
    }

    @Test
    public void testInvert3() {
        Assert.assertEquals("10000100 10000110 00110110 11110010 00000100 01010110 10100110 00010010",
                Iqh.invert("01001000 01100101 01101010 00100000 01001111 01101100 01100001 00100001"));
    }

    @Test
    public void testInvertUpper(){
        Assert.assertEquals(Iqh.invert("ABCDEFGHIJKLMMMMMMNOPQRSTUVWXYZÅÄÖ"), "ÖÄÅZYXWVUTSRQPONMMMMMMLKJIHGFEDCBA");
    }

    @Test
    public void testInvertLower(){
        Assert.assertEquals(Iqh.invert("abcdefghijklmnoooooopqrstuvxyzåäö"), "öäåzyxvutsrqpoooooonmlkjihgfedcba");
    }

    @Test
    public void testInvertMix(){
        Assert.assertEquals(Iqh.invert("ABCDEFGHIJKLMNOPQRSTUVWXYZ ÅÄÖ" + "abc defghijklmnopqrstuvxyzåäö" + " " + ".!:;234"),
                "432;:!. öäåzyxvutsrqponmlkjihgfed cbaÖÄÅ ZYXWVUTSRQPONMLKJIHGFEDCBA");
    }

    @Test
    public void testInvertNumbers(){
        Assert.assertEquals(Iqh.invert("0123456789"), "9876543210");
    }


    // Test corner for invert(); issues with double letters
    @Test
    public void testInvertDouble() {
        Assert.assertEquals(Iqh.invert("swwr"), "rwws"); // will fail
    }

    @Test
    public void testInvertDoublePlusTwoLetters() {
        Assert.assertEquals(Iqh.invert("swwrqr"), "rqrwws"); // will not fail.
    }

    @Test
    public void testInvertDoublePlusThreeLetters() {
        Assert.assertEquals(Iqh.invert("swwrqrw"), "wrqrwws"); // will not fail.
    }

    @Test
    public void testInvertDoublePlusThreeLettersPlusDouble() {
        Assert.assertEquals(Iqh.invert("swwrqrww"), "wwrqrwws"); // will fail.
    }

    @Test
    public void testInvertDoublePlusThreeLettersPlusDoublePlusOneLetter() {
        Assert.assertEquals(Iqh.invert("swwrqrwwh"), "hwwrqrwws"); // will fail
    }

    @Test
    public void testInvertDoublePlusThreeLettersPlusDoublePlusTwoLetters() {
        Assert.assertEquals(Iqh.invert("swwrqrwwhg"), "ghwwrqrwws"); // will not fail
    }



    // scatterString();
    @Test
    public void testScatterStringTest() {
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
    public void testScatterString1() {
        for (int i = 0; i<1000000; i++) {
            Assert.assertNotEquals("123456789", Iqh.scatterString("123456789")); //fixme metoden verkar ej ha validering för att return blir annorlunda än input
        }
    }
    @Test
    public void testScatterdStringOnlyWhitespace(){
        String s = Iqh.scatterString(" ");
        Iqh.scatterString(s);
        Assert.assertEquals(s," ");
    }




    // lowerHalf();
    @Test
    public void lowerHalfTest() {
        String testStringUnEven = testString102Chars+ "*";
        String testStringEven = testString102Chars;
        String outputShouldBeNull = Iqh.lowerHalf(testStringUnEven);
        String outputShouldReturnHalf = Iqh.lowerHalf(testStringEven);
        System.out.println(outputShouldBeNull);
        Assert.assertNull(outputShouldBeNull);
        Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrst", outputShouldReturnHalf);
        //TODO Can't handle more than 50 chars.
    }


    @Test
    public void testLowerHalf1() {
        Assert.assertEquals("One", Iqh.lowerHalf("OneTwo"));
    }

    @Test
    public void testLowerHalf2() {
        Assert.assertNull(Iqh.lowerHalf("One Two"));
    }

    @Test
    public void testLowerHalf3() {
        Assert.assertEquals("@F_1",Iqh.lowerHalf("@F_1337!"));
    }


    @Test
    public void testLowerHalfUpperAlphabetUneven(){
        String s = Iqh.lowerHalf("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"); // 29 letters
        Assert.assertEquals(s, null);

    }

    @Test
    public void testLowerHalfUpperAlphabetEven(){
        String s = Iqh.lowerHalf("ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ"); // no "W", 28 letters
        Assert.assertEquals(s, "ABCDEFGHIJKLMN");

    }

    @Test
    public void testLowerHalfLowerAlphabetUneven(){
        String s = Iqh.lowerHalf("abcdefghijklmnopqrstuvwxyzåäö"); // 29 letters
        Assert.assertEquals(s, null);

    }

    @Test
    public void testLowerHalfLowerAlphabeteven(){
        String s = Iqh.lowerHalf("abcdefghijklmnopqrtuvwxyzåäö"); // no "s", 28 letters
        Assert.assertEquals(s, "abcdefghijklmn");

    }

    @Test
    public void testLowerHalfLowerMixEven(){
        String s = Iqh.lowerHalf("L2Trer.!aO"); // 10 char
        Assert.assertEquals(s, "L2Tre");
    }

    @Test
    public void testLowerHalfLowerMixUneven(){
        String s = Iqh.lowerHalf("L2Tre.sNa"); // 9 char
        Assert.assertEquals(s, null);
    }

    @Test
    public void testLowerHalfLowerMixThree(){
        String s = Iqh.lowerHalf("Hi!"); // 3 char
        Assert.assertEquals(s, null);
    }

    @Test
    public void testLowerHalfLowerMixTwo(){
        String s = Iqh.lowerHalf("Hi"); // 2 letter
        Assert.assertEquals(s, "H");
    }

    @Test
    public void testLowerHalfLowerOne(){
        String s = Iqh.lowerHalf("x"); // 1 letter
        Assert.assertEquals(s, null);
    }

    @Test
    public void testLowerHalfLowerNumbersEven(){
        String s = Iqh.lowerHalf("0123456789"); // 10 numbers
        Assert.assertEquals(s, "01234");
    }

    @Test
    public void testLowerHalfLowerNumbersUneven(){
        String s = Iqh.lowerHalf("123456789"); // 9 numbers
        Assert.assertEquals(s, null);
    }

    @Test
    public void testLowerHalfNothing(){
        String s = Iqh.lowerHalf(""); // ""
        Assert.assertEquals(s, "");
    }

    @Test
    public void testLowerHalfWhitespace(){
        String s = Iqh.lowerHalf(" "); // " " one whitespace
        Assert.assertEquals(s, null);
    }

    @Test
    public void testlowerHalfTwoWhitespace(){
        String s = Iqh.lowerHalf("  "); // "  " two whitespace
        Assert.assertEquals(s, " ");
    }



    // upperHalf();
    @Test
    public void testUpperHalfTest(){
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
    public void testUpperHalf1() {
        Assert.assertEquals("Two",Iqh.upperHalf("OneTwo"));
    }

    @Test
    public void testUpperHalf2() {
        Assert.assertNull(Iqh.upperHalf("Seven"));
    }

    @Test
    public void testUpperHalfUpperAlphabetUneven(){
        String s = Iqh.upperHalf("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"); // 29 letters
        Assert.assertEquals(s, null);

    }

    @Test
    public void testUpperHalfUpperAlphabetEven(){
        String s = Iqh.upperHalf("ABCDEFGHIJKLMNOPQRSTUVWYZÅÄÖ"); // no "X", 28 letters
        Assert.assertEquals(s, "OPQRSTUVWYZÅÄÖ");

    }

    @Test
    public void testUpperHalfLowerAlphabetUneven(){
        String s = Iqh.upperHalf("abcdefghijklmnopqrstuvwxyzåäö"); // 29 letters
        Assert.assertEquals(s, null);

    }

    @Test
    public void testUpperHalfLowerAlphabetEven(){
        String s = Iqh.upperHalf("abcdefghijklmnopqrsuvwxyzåäö"); // "t", 28 letters
        Assert.assertEquals(s, "opqrsuvwxyzåäö");

    }

    @Test
    public void testUpperHalfLowerMixEven(){
        String s = Iqh.upperHalf("L2Trer.!aO"); // 10 char
        Assert.assertEquals(s, "r.!aO");
    }

    @Test
    public void testUpperHalfLowerMixUneven(){
        String s = Iqh.upperHalf("L2Tre.sNa"); // 9 char
        Assert.assertEquals(s, null);
    }

    @Test
    public void testUpperHalfLowerMixThree(){
        String s = Iqh.upperHalf("Hi!"); // 3 char
        Assert.assertEquals(s, null);
    }

    @Test
    public void testUpperHalfLowerMixTwo(){
        String s = Iqh.upperHalf("Hi"); // 2 letter
        Assert.assertEquals(s, "i");
    }

    @Test
    public void testUpperHalfLowerOne(){
        String s = Iqh.upperHalf("x"); // 1 letter
        Assert.assertEquals(s, null);
    }
    @Test
    public void testUpperHalfLowerNumbersEven(){
        String s = Iqh.upperHalf("0123456789"); // 10 numbers
        Assert.assertEquals(s, "56789");
    }

    @Test
    public void testUpperHalfLowerNumbersUneven(){
        String s = Iqh.upperHalf("123456789"); // 9 numbers
        Assert.assertEquals(s, null);
    }

    @Test
    public void testUpperHalfNothing(){
        String s = Iqh.upperHalf(""); // ""
        Assert.assertEquals(s, "");
    }

    @Test
    public void testUpperHalfWhitespace(){
        String s = Iqh.upperHalf(" "); // " "
        Assert.assertEquals(s, null);
    }

    @Test
    public void testUpperHalfTwoWhitespace(){
        String s = Iqh.upperHalf("  "); // "  "
        Assert.assertEquals(s, " ");
    }



    // size();
    @Test
    public void testSizeTestOver100Chars(){
        int sizeOfString = Iqh.size(testString102Chars);
        String  testString102CharsUnEven = testString102Chars + "*";
        int sizeOfStringOver100AndUnEven = Iqh.size(testString102CharsUnEven);

        Assert.assertEquals(102, sizeOfString); //Asserts testString102Chars is correctly counted.
        Assert.assertEquals(103, sizeOfStringOver100AndUnEven); //Asserts testString102Chars is correctly counted uneven and over 100 chars.
        //TODO inverts when the count is over 100 chars.
    }

    @Test
    public void testSizeTestUnder100Chars(){
        int sizeOfString = Iqh.size("12345678");
        int sizeOfStringUnEven = Iqh.size("1234567");

        Assert.assertEquals(8, sizeOfString); //Asserts testString102Chars is correctly counted.
        Assert.assertEquals(7, sizeOfStringUnEven); //Asserts testString102Chars is correctly counted uneven and over 100 chars.
        //Works
    }

    @Test
    public void testSize1() { //fixme Efter 102 tecken blir talen negativa
        Assert.assertEquals(103,Iqh.size("2223333333333444444444455555555556666666666777777777788888888889999999999000000000010101010101010101010"));
    }

    @Test
    public void testSize2() {
        Assert.assertEquals(11,Iqh.size("1Aa_2Bb 3Cc"));
    }

    @Test
    public void testSize3() {
        Assert.assertEquals(0,Iqh.size(""));
    }

    @Test
    public void testSizeNone(){
        Assert.assertEquals(Iqh.size(""), 0);
    }

    @Test
    public void testSizeOne(){
        Assert.assertEquals(Iqh.size("i"), 1);
    }

    @Test
    public void testSizeTwo(){
        Assert.assertEquals(Iqh.size("Hi"), 2);
    }

    @Test
    public void testSizeThree(){
        Assert.assertEquals(Iqh.size("Hej"), 3);
    }

    @Test
    public void testSizeNine(){
        Assert.assertEquals(Iqh.size("Greetings"), 9);
        Assert.assertEquals(Iqh.size("Konichiwa"), 9);
        Assert.assertSame(Iqh.size("Greetings"),Iqh.size("Konichiwa"));
    }

    @Test
    public void testSizeAlphabetMix(){
        Assert.assertEquals(Iqh.size("AbCdEfGhIjKlMnOpQrStUvWxYzÅäÖ!:.;"), 33);
    }

    @Test
    public void testSizeAlphabetMixAndWhitespace(){
        Assert.assertEquals(Iqh.size("A b C d E f G h I j KlMnOpQrStUvWxYzÅäÖ!:.;"), 43); // 43 == 33 char and 10 whitespaces

    }



    // readString();
    @Test
    public void testReadStringTest() {
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

    @Test
    public void testReadString2() {
        File temp = new File("temp.txt");
        Assert.assertEquals(".txt",Iqh.readString("temp.txt"));//om ingen sökväg hittas, och argumentet är av jämn längd, returneras sista halvan i filepath
        Assert.assertEquals(null,Iqh.readString("temp.jpeg")); //om argumentet är av ojämn längd returneras null
    }


    @Test
    public void testReadString() {
     /*
       Om det inte finns någon fil kommer metoden att göra samma sak som upperHalf();
       dvs returnera halva strängen om den är jämn, men returnera null om strängen är udda.
         */
        System.out.println(Iqh.readString("filename"));
        Assert.assertEquals(Iqh.readString("filename"), "name");

        System.out.println(Iqh.readString("texttest")); // test
        System.out.println(Iqh.readString("test")); // st
        System.out.println(Iqh.readString("String")); // ing
        System.out.println(Iqh.readString("Fejk")); // jk
        System.out.println(Iqh.readString("Funny")); // null // uneven
        System.out.println(Iqh.readString("Fun")); // null // uneven
        System.out.println(Iqh.readString("Fuuu")); // uu

    }

    @Test
    public void testReadStringTryToReadFromTheFile() {
        // System.out.println(Iqh.readString("texttest.txt")); //Will read from the file while there is any char on the next line.
        Assert.assertEquals(Iqh.readString("texttest.txt"), "This is just a test document.This is the second row.And this is the THIRD row. Smile. Rows after this row will not be printed.");
    }



    // zip();
    @Test
    public void testZipTestEvenLines() {
        String firstHalf = "AbCdE";
        String secondHalf = "123/&";
        String shouldBe = "A1b2C3d/E&";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
        //TODO doesn't work. Removes the last char if uneven.
    }

    @Test
    public void testZipTestUnEvenLines() {
        String firstHalf = "AbCdE";
        String secondHalf = "123/&%";
        String shouldBe = "A1b2C3d/E&%";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
        //TODO doesn't work. Removes the last char if uneven.
    }

    @Test
    public void testZipTest102Chars() {
        String firstHalf = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ,abcdefghijklmnopqrstu";
        String secondHalf = "vwxyzåäö 0123456789 !#¤%&/()=?`´^¨'-_.,;:+*********";
        String shouldBe = "AvBwCxDyEzFåGäHöI J0K1L2M3N4O5P6Q7R8S9T U!V#W¤X%Y&Z/Å(Ä)Ö=,?a`b´c^d¨e'f-g_h.i,j;k:l+m*n*o*p*q*r*s*t*u*";
        String combinedString =  Iqh.zip(firstHalf,secondHalf);
        System.out.println(combinedString);
        Assert.assertEquals(shouldBe,combinedString);
    }

    @Test
    public void testZip1() {
        Assert.assertEquals("adbecf", Iqh.zip("abc","def"));
    }

    @Test
    public void testZip2() {
        Assert.assertEquals("\\/\\/\\/", Iqh.zip("\\\\\\", "///"));
    }

    @Test
    public void testZip3() {
         Assert.assertEquals("HOellalo", Iqh.zip("Hello","Ola")); //fixme olika längder på argumenten fungerar ej
    }

    @Test
    public void testZipSame(){
        Assert.assertEquals(Iqh.zip("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ", "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"), "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
    }

    @Test
    public void testZipNone(){
        Assert.assertEquals(Iqh.zip("", ""), "");
    }

    @Test
    public void testZipOneNone(){
        Assert.assertEquals(Iqh.zip("B", ""), ""); // Cuts "B"
    }

    @Test
    public void testZipNoneOne(){
        Assert.assertEquals(Iqh.zip("", "b"), ""); // Cuts "b"
    }

    @Test
    public void testZipOne(){
        Assert.assertEquals(Iqh.zip("B", "b"), "Bb");
    }

    @Test
    public void testZipTwo(){
        Assert.assertEquals(Iqh.zip("c", "C"), "cC");
    }

    @Test
    public void testZipTwoTypes(){
        Assert.assertEquals(Iqh.zip("AAA", "aaa"), "AaAaAa");
    }

    @Test
    public void testZipMixedEven(){
        Assert.assertEquals(Iqh.zip("RaNdOm !", "MiDdLe ."), "RMaiNDddOLme  !.");
    }

    @Test
    public void testZipMixedUneven(){

        Assert.assertEquals(Iqh.zip("12!", "MiDdLe ."), "1M2i!D"); // cuts the excess "dLe ."
        Assert.assertEquals(Iqh.zip("MiDdLe .", "12!"), "M1i2D!"); // cuts the excess "dLe ."

        Assert.assertEquals(Iqh.zip("aNdOm!CUToff", "MiDdL."), "aMNidDOdmL!."); // cuts the excess "CUToff"
        Assert.assertEquals(Iqh.zip("aNdOm!", "MiDdL.CUToff"), "aMNidDOdmL!."); // cuts the excess "CUToff"

        Assert.assertEquals(Iqh.zip("12345", "12345678"), "1122334455"); // cuts the excess "675"
    }



    //fixme Dessa metoder går ej att nå, därför uteblir de.
        /*
        @Test
    public void testUnZip1() {
        String[] arr = Iqh.unzip("abcdef");
        Assert.assertEquals("abc", arr[0]);
        Assert.assertEquals("def",arr[1]);
    }

       @Test
    public void testUnzipSame(){
        Assert.assertArrayEquals(Iqh.unzip("ZZZZZZ"), ["ZZZ", "ZZZ"], ["ZZZ", "ZZZ"]);
    }

    @Test
    public void testUnzipNone(){
        Assert.assertArrayEquals(Iqh.unzip("", []);
    }

    @Test
    public void testUnzipTwoTypes(){
        Assert.assertArrayEquals(Iqh.unzip("AaAaAa"), ["AAA", "aaa"]);
    }

    @Test
    public void testUnzipMixedEven(){
        Assert.assertArrayEquals(Iqh.unzip("RMaiNDddOLme  !.", ["RaNdOm !", "MiDdLe ."]);
    }




    // removeVowels Does not yet exists?!
 /*
    @Test
    public void testRemoveVowels1() {

        //Assert.assertEquals("zbr",Iqh.removeVowels("zebra"));
    }

    @Test
    public void testRemoveVowelsUpperAlphabet(){
    String s = Iqh.removeVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"); // 29 letters
    Assert.assertEquals(s, "BCDFGHJKLMNPQRSTVWXYZ"); //  "Y" Might be a consonant in english.
    }

     @Test
    public void testRemoveVowelsLowerAlphabet(){
        String s = Iqh.removeVowels("abcdefghijklmnopqrstuvwxyzåäö"); // 29 letters
        Assert.assertEquals(s, "bcdfghjklmnpqrstvwxyz");  //  "y" Might be a consonant in english.

    }

    @Test
    public void testRemoveVowelsNumbers(){
        String s = Iqh.removeVowels("0123456789"); // 10 numbers
        Assert.assertEquals(s, "0123456789");  //
    }

    @Test
    public void testRemoveVowelsMix(){
        String s = Iqh.removeVowels("I like to drink covfefe."); // Random sentence
        Assert.assertEquals(s, " lk t drnk cvff.");

        s = Iqh.removeVowels("A sentence is a set of words that is complete in itself,;!45");
        Assert.assertEquals(s, " sntnc s  st f wrds tht is cmplt n tslf,;!45");
    }

    @Test
    public void testRemoveVowelOne(){
        String s = Iqh.removeVowels("A");
        Assert.assertEquals(s, "");

        s = Iqh.removeVowels("i");
        Assert.assertEquals(s, "");
    }
*/


    @After
    public void tD() throws Exception {
        tearDown();
    }
}
