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
    public BackEnd() {
        this.player1 = "";
        this.player2 = "";
    }

    //Ska returnera en sträng: "And the Winner is " samt namnet på den spelare som har högst poäng
    public String getWinner() {
        String player1Win = "And the Winner is " + player1;
        String player2Win = "And the Winner is " + player2;
        String gameOver = "No one win!";
        if (p1Score >= 100) {
            return player1Win;
        } else if (p2Score >= 100) {
            return player2Win;
        } else {
            return gameOver;
        }

    }

    // Ska returnera namnet på den spelaren i tur utifrån värdet på currentplayer
    public String currentPlayerName() {
        if (this.currentPlayer == 1) {
            return player1;
        } else if (this.currentPlayer == 2) {
            return player2;
        }
        return null;
    }

    //Sätter this.currentPlayer till 1 eller 2 baserat på slumpen.
    public void randomStarter(){
        int [] nummer = {1,2};
        int rand = (int) (Math.random() * nummer.length );
        this.currentPlayer = nummer[rand];
    }

    //Returnerar en sträng med spelare1:s namn följt av "Score: " samt spelare1:s poäng
    public String player1Score(){
        return player1 + " score " + p1Score;

    }
    //Returnerar en sträng med spelare2:s namn följt av "Score: " samt spelare2:s poäng
    public String player2Score(){

        return player2 + " score " + p2Score;
    }

    //Ger this.Dice ett värde mellan 1 och 20, samt ökar this.roundCounter med 1;
    public void throwDice(){
        int [] nummer = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int rand = (int) (Math.random() * nummer.length);
        this.dice = nummer[rand];
        this.roundCounter = this.roundCounter + 1;
    }
    // Lägger till värdet på this.dice till den aktuelle spelaren poäng
    // Nollställer därefter this.dice och this.roundCounter
    //Kollar sedan om någon av spelarna har nått 100 poäng och om så är fallet sätts gameOver till true;
    public void addScore(){
        if(this.currentPlayer == 1){
            this.p1Score  = this.dice + p1Score;
            this.currentPlayer = 2;
        }
        else if (this.currentPlayer == 2){
            this.p2Score  = this.dice + p2Score;
            this.currentPlayer = 1;
        }

        if(p1Score >= 100 || p2Score >= 100){
            this.gameOver = true;
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
        if (this.roundCounter <3 && currentPlayer == 1) {
            int reply = JOptionPane.showConfirmDialog(null, "Roll again?" , this.player1, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                addScore();
            }
        } else if(this.roundCounter < 3 && currentPlayer == 2) {
            //String dialogTitle = this.currentPlayer == 1 ? this.player1 : this.player2;
            int reply = JOptionPane.showConfirmDialog(null, "Roll again?", this.player2, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                addScore();
            }
        }
        else {
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
    public void setRoundCounter(int roundCounter){
        this.roundCounter = roundCounter;
    }

    public void getP1Score(int score) {
        p1Score = score; }
    public void get2Score(int score) {
        p2Score = score;

    }

    public void tempSetP1Score(int score) {
        this.p1Score = score;
    }
    public void tempSetplayer1 (String player1){
        this.player1 =player1;
    }
    public void tempSetplayer2 (String player2){
        this.player2 = player2;
    }

    public void tempSetP2Score(int score) {
        this.p2Score = score;
    }
    public void tempSetCurrentPlayer(int currentPlayer)
    {this.currentPlayer = currentPlayer;
    }
    public void tempSetDice(int value) {
        this.dice = value;
    }
    public int tempGetP1Score() {
        return this.p1Score;
    }
    public int tempGetP2Score() {
        return this.p2Score;
    }
    public boolean tempGetGameOver() {
        return this.gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
