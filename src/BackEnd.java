import javax.swing.*;

public class BackEnd {
    private String player1; //Namnet på den ena spelaren
    private String player2; //Namnet på den andra spelaren
    private int p1Score;    //Spelare1:s poäng
    private int p2Score;  //Spelare2:s poäng
    private int dice;     //"Tärningens värde"
    private int currentPlayer; // En flagga. Om det är spelare1s tur är den annars 2.
    private int roundCounter; // Räknare som håller ordning på antalet kast per spelomgång
    private boolean gameOver = false;  //Sätts till true när någon spelare vinner


    /**
     * Spelregler
     * Två personer spelar mot varandra. Vill man ange namn på dem kan man
     * göra det på startSkärmen.
     * Spelarna turas om att rulla en 20-sidig tärning. När man kastat tärningen får
     * man välja om man vill behålla värdet eller kasta om tärningen. Man får kasta
     * om upp till tre gånger men man får bara poäng för de senaste kastet. (Slutar
     * man på en 1:a så får man bara en poäng oavsett vad man kastat tidigare).
     * Efter tre kast (eller att spelaren accepterat sin poäng) går spelet vidare till
     * till spelare två som kastar tärningen.
     * Först till 100 poäng vinner.
     */

    //Det finns inget skäl att ändra i konstruktorn eller i instansvariablerna
    public BackEnd (){
        this.player1="";
        this.player2="";
    }

    //Ska returnera en sträng: "And the Winner is " samt namnet på den spelare som har högst poäng
    public String getWinner(){
        if (p1Score >= 100){
            return "And the Winner is " + player1 + "!"
                    + "\nTotal score is: \n" + getPlayer1() + " " + p1Score + "\n" + getPlayer2() + " " + p2Score;
        }

        if (p2Score >= 100){
            return "And the Winner is " + player2 + "!"
                    + "\nFinal score is: \n" + getPlayer1() + " " + p1Score + "\n" + getPlayer2() + " " + p2Score;
        }

        return "And the Winner is not yet decided.";
    }

    // Ska returnera namnet på den spelaren i tur utifrån värdet på currentplayer
    public String currentPlayerName(){
        if (currentPlayer == 1){
            return player1;
        }
        else if (currentPlayer == 2){
            return player2;
        }
        else{
            return  "Not a valid player";
        }
    }

    //Sätter this.currentPlayer till 1 eller 2 baserat på slumpen.
    public void randomStarter(){
        this.currentPlayer = (int) ((Math.random() * 2) + 1);
    }

    //Returnerar en sträng med spelare1:s namn följt av "Score: " samt spelare1:s poäng
    public String player1Score(){
        return getPlayer1() + " score: " + this.p1Score;

    }
    //Returnerar en sträng med spelare2:s namn följt av "Score: " samt spelare2:s poäng
    public String player2Score(){
        return getPlayer2() + " score: " + this.p2Score;
    }

    //Ger this.dice ett värde mellan 1 och 20, samt ökar this.roundCounter med 1;
    public void throwDice(){
        this.dice = (int) (Math.random() * 20 + 1);
        this.roundCounter = this.roundCounter + 1;

    }

    // Lägger till värdet på this.dice till den aktuelle spelaren poäng
    // Nollställer därefter this.dice och this.roundCounter
    // Kollar sedan om någon av spelarna har nått 100 poäng och om så är fallet sätts gameOver till true;
    public void addScore() {

        if (this.dice == 20){
            System.out.println("Nat 20!"); // https://www.urbandictionary.com/define.php?term=nat%2020
            this.dice = 100;
        }

        if (currentPlayer == 1) {
            this.p1Score = this.p1Score + this.dice;
            this.currentPlayer = 2;
        } else if (currentPlayer == 2) {
            this.p2Score = this.p2Score + this.dice;
            this.currentPlayer = 1;
        } else {
            System.out.println("Only valid players get scores.");
        }

        this.dice = 0;
        this.roundCounter = 0;

        if (p1Score >= 100 || p2Score >= 100) {
            gameOver = true;
        }

    }


    /**
     *                 SMILE!
     */


//Inget ska behöva ändras eller testas koden härunder

    public void startGame(String p1, String p2){
        this.gameOver = false;
        this.player1 = p1;
        this.player2 = p2;
        this.p1Score = 0;
        this.p2Score = 0;
        this.currentPlayer = 1;
    }

    public void askToKeep() {
        String nat20 = "";
        String nat20win = "";
        String dot = "";

        if (this.roundCounter < 3) {
            if (this.dice == 20){
                nat20 = "nat ";
                nat20win = "\nSave the nat 20 roll and win!";
                dot = "!";
            }
            else {
                dot = ".";
            }
            int reply = JOptionPane.showConfirmDialog(null, currentPlayerName() + " your dice show " + nat20 + this.dice + dot + nat20win
                    + "\nRoll again?" , this.currentPlayerName(), JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.NO_OPTION) {
                addScore();
            }else {return;}
        } else{
            addScore();
        }
    }

    public String getPlayer1() {
        return player1;
    }
    public String getPlayer2() {
        return player2;
    }
    public int getCurrentPlayer(){
        return this.currentPlayer;
    }
    public int getDice(){
        return this.dice;

    }
    public boolean gameOver(){
        return this.gameOver;
    }

}
