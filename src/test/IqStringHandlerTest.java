import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class IqStringHandlerTest extends TestCase {

    // ALPHABET alphabetUpper (not a test)
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
    public void testCountConsonants() {
        Assert.assertEquals(3,Iqh.countConsonants("Three"));
    }

    @Test
    public void testCountConsonants2() {
        //fixme registrerar versaler som konsonanter
        //  Assert.assertEquals(5,Iqh.countConsonants("Assimilate"));
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

        // Assert.assertEquals(Iqh.countConsonants("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),21); // "29"
        // Assert.assertEquals(Iqh.countConsonants("abcdefghijklmnopqrstuvxyzåäö"),21); // "19"
        Assert.assertEquals(Iqh.countConsonants("BCDFGHJKLMNPQRSTVWXYZ"),21);
        // Assert.assertEquals(Iqh.countConsonants("AEIOUÅÄÖ"),0); // "8"
        //  Assert.assertEquals(Iqh.countConsonants("aeiouåäö"),0);  // "-1" whoa?!?!
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

        //  Assert.assertEquals(Iqh.countConsonants("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),21); // "29"
        //  Assert.assertEquals(Iqh.countConsonants("abcdefghijklmnopqrstuvxyzåäö"),21); // "19"
        Assert.assertEquals(Iqh.countConsonants("BCDFGHJKLMNPQRSTVWXYZ"),21);
        // Assert.assertEquals(Iqh.countConsonants("AEIOUÅÄÖ"),0); // "8"
        // Assert.assertEquals(Iqh.countConsonants("aeiouåäö"),0); // "-1" whoa?!?!
        Assert.assertEquals(Iqh.countConsonants("ä"),-1); // WHYYYYYY??????
    }



    // Tests for countVowels();
    //  "Y" may be a consonant in english.
    @Test
    public void testCountVowels1() {
        //fixme funkar ej med versaler
        // Assert.assertEquals(2, Iqh.countVowels("ZOO"));
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

        // Assert.assertEquals(Iqh.countVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),9); // "0" Sometings not sitting right
        Assert.assertEquals(Iqh.countVowels("abcdefghijklmnopqrstuvxyzåäö"),9);
        Assert.assertEquals(Iqh.countVowels("BCDFGHJKLMNPQRSTVWXYZ"),0);
        // Assert.assertEquals(Iqh.countVowels("AEIOUÅÄÖ"),8); // "0"
        //  Assert.assertEquals(Iqh.countVowels("aeiouåäö"),8); // "9" ?!
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

        // Assert.assertEquals(Iqh.countVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"),9); // "0"
        Assert.assertEquals(Iqh.countVowels("abcdefghijklmnopqrstuvxyzåäö"),9);
        Assert.assertEquals(Iqh.countVowels("BCDFGHJKLMNPQRSTVWXYZ"),0);
        // Assert.assertEquals(Iqh.countVowels("AEIOUÅÄÖ"),8); // "0"
        //  Assert.assertEquals(Iqh.countVowels("aeiouåäö"),8); // "9" ?!
        Assert.assertEquals(Iqh.countVowels("ä"),2); // WHYYYYYY??????

    }



    // invert();

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
    public void testInvertTestersCorner() {
        // Words consisting of 1 letter will fail.
        // Words consisting of 3 letter will fail.
        // Words consisting the same two letters in a row at second and third place (first and second position) will fail at four letters.
        //      If the same double letter is repeated the word will fail once again and for the next letter.
        //      Example:
        //      swwr will fail.
        //      swwrqr will not fail.
        //      swwrqrw will not fail.
        //      swwrqrww will fail.
        //      swwrqrwwh will fail
        //      swwrqrwwhg will not fail


        // Assert.assertEquals(Iqh.invert("1"), "1"); // seems not able to invert only one char -> java.lang.StringIndexOutOfBoundsException: String index out of range: 1
        //  Assert.assertEquals(Iqh.invert("123"), "321"); // "23212" Something seems off when trying a three-letter string.
        // Assert.assertEquals(Iqh.invert("Hej"), "jeH"); // "ejeHe"
        // Assert.assertEquals(Iqh.invert("Jooo"), "oooJ"); // "ooooJo"
        // Assert.assertEquals(Iqh.invert("Joooa"), "aoooJ"); // "oaoooJo"

        Assert.assertEquals(Iqh.invert("Joakk"), "kkaoJ");
        Assert.assertEquals(Iqh.invert("Jooak"), "kaooJ");
        Assert.assertEquals(Iqh.invert("Jooakk"), "kkaooJ");
        //  Assert.assertEquals(Iqh.invert("Jook"), "kooJ"); // Fail 4 letters, second and third letter same.
        //  Assert.assertEquals(Iqh.invert("jiikntiig"), "giitnkiij");
        Assert.assertEquals(Iqh.invert("tuuhb"), "bhuut");
        Assert.assertEquals(Iqh.invert("mggypt"), "tpyggm");
        //Assert.assertEquals(Iqh.invert("KKEEKKEEKK"), "KKEEKKEEKK");
        Assert.assertEquals(Iqh.invert("mllNMllkkllkk"), "kkllkkllMNllm");
        //Assert.assertEquals(Iqh.invert("sww"), "wws");
        // Assert.assertEquals(Iqh.invert("swwr"), "rwws");
        Assert.assertEquals(Iqh.invert("swwrbc"), "cbrwws");
        // Assert.assertEquals(Iqh.invert("swwrbcww"), "wwcbrwws");
        Assert.assertEquals(Iqh.invert("swwrbcwttt"), "tttwcbrwws");
        Assert.assertEquals(Iqh.invert("swwrbcwwgp"), "pgwwcbrwws");
        Assert.assertEquals(Iqh.invert("swwrbcwwgpwwtbwwsr"), "rswwbtwwpgwwcbrwws");
        // Assert.assertEquals(Iqh.invert("swwrbcwwgpwwftqww"), "wwqtfwwpgwwcbrwws");

        Assert.assertEquals(Iqh.invert("swwrqr"), "rqrwws");
        Assert.assertEquals(Iqh.invert("swwrqrvvbvvrwwsp"), "pswwrvvbvvrqrwws");

        // Example from above in code:
        //   Assert.assertEquals(Iqh.invert("swwr"), "rwws"); // will fail
        Assert.assertEquals(Iqh.invert("swwrqr"), "rqrwws"); // will not fail.
        Assert.assertEquals(Iqh.invert("swwrqrw"), "wrqrwws"); // will not fail.
        // Assert.assertEquals(Iqh.invert("swwrqrww"), "wwrqrwws"); // will fail.
        // Assert.assertEquals(Iqh.invert("swwrqrwwh"), "hwwrqrwws"); // will fail
        Assert.assertEquals(Iqh.invert("swwrqrwwhg"), "ghwwrqrwws"); // will not fail

    }



    // scatterString();
    @Test
    public void testScatterString1() {
      /*  for (int i = 0; i<1000000; i++) {
            Assert.assertNotEquals("123456789", Iqh.scatterString("123456789")); //fixme metoden verkar ej ha validering för att return blir annorlunda än input
        } */
    }
    @Test
    public void testScatterdStringOnlyWhitespace(){
        String s = Iqh.scatterString(" ");
        Iqh.scatterString(s);
        Assert.assertEquals(s," ");
    }




    // lowerHalf();
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
    public void testUpperHalf1() {
        Assert.assertEquals("Two",Iqh.upperHalf("OneTwo"));
    }

    @Test
    public void testUpperHalf2() {
        Assert.assertNull(Iqh.upperHalf("Seven"));
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
    public void testSize1() { //fixme Efter 102 tecken blir talen negativa
        //Assert.assertEquals(103,Iqh.size("2223333333333444444444455555555556666666666777777777788888888889999999999000000000010101010101010101010"));
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
    public void testZip1() {
        Assert.assertEquals("adbecf", Iqh.zip("abc","def"));
    }

    @Test
    public void testZip2() {
        Assert.assertEquals("\\/\\/\\/", Iqh.zip("\\\\\\", "///"));
    }

    @Test
    public void testZip3() {
        // Assert.assertEquals("HOellalo", Iqh.zip("Hello","Ola")); //fixme olika längder på argumenten fungerar ej
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



    // unzip(); Does not yet exists?! // todo add method Iqh.unzip(); then return to these test :)
        /*
        @Test
    public void testUnZip1() {

        String[] arr = Iqh.unzip("abcdef");//fixme metod verkar ej finnas
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
*/



    // removeVowels Does not yet exists?! // todo add method Iqh.removeVowels(); then return to these test :)
 /*
    @Test
    public void testRemoveVowels1() {

        //Assert.assertEquals("zbr",Iqh.removeVowels("zebra"));//fixme metod verkar ej finnas
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

