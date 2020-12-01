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

    //Det finns inget skäl att ändra i konstruktorn eller i instansvariablerna
    public BackEnd (){
        this.player1="";
        this.player2="";
    }

    //Ska returnera en sträng: "And the Winner is " samt namnet på den spelare som har högst poäng
    public String getWinner(){
        if(p1Score >= 100){
            return "And the winner is " + player1 + " with " + p1Score + " points!";
        } else {
            return "And the winner is " + player2 + " with " + p2Score + " points!";
        }
    }

    // Ska returnera namnet på den spelaren i tur utifrån värdet på currentplayer
    public String currentPlayerName(){
        if(currentPlayer == 1){
            return player1;
        } else {
            return player2;
        }
    }

    //Sätter this.currentPlayer till 1 eller 2 baserat på slumpen.
    public void randomStarter(){
        currentPlayer = (int) (Math.random() * 2);
    }

    //Returnerar en sträng med spelare1:s namn följt av "Score: " samt spelare1:s poäng
    public String player1Score(){

        return player1 + " score is: " + p1Score;

    }
    //Returnerar en sträng med spelare2:s namn följt av "Score: " samt spelare2:s poäng
    public String player2Score(){

        return player2 + " score is: " + p2Score;
    }

    //Ger this.Dice ett värde mellan 1 och 20, samt ökar this.roundCounter med 1;
    public void throwDice(){
        this.roundCounter++;
        this.dice = (int) (1 + Math.random()*20);
    }
    // Lägger till värdet på this.dice till den aktuelle spelaren poäng
    // Nollställer därefter this.dice och this.roundCounter
    //Kollar sedan om någon av spelarna har nått 100 poäng och om så är fallet sätts gameOver till true;
    public void addScore(){
        int player = getCurrentPlayer();

        if(player ==1){
            p1Score = this.dice + p1Score;
            currentPlayer = 2;
        } else {
            p2Score = this.dice + p2Score;
            currentPlayer = 1;
        }

        if(p1Score >= 100 || p2Score >=100) {
            gameOver = true;
        }
        this.dice = 0;
        this.roundCounter = 0;

    }


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
        if (this.roundCounter <3) {
            int reply = JOptionPane.showConfirmDialog(null, "Roll again?" , this.player1, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                addScore();
            }else {
                return;
            }
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

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setP1Score(int score) {
        p1Score = score;
    }

    public void setP2Score(int score) {
        p2Score = score;
    }
}
