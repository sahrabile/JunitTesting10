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
        //TODO
        return "Not implemented";
    }

    // Ska returnera namnet på den spelaren i tur utifrån värdet på currentplayer
    public String currentPlayerName(){
        //TODO
        return "Not implemented";

    }

    //Sätter this.currentPlayer till 1 eller 2 baserat på slumpen.
    public void randomStarter(){
        //TODO
    }

    //Returnerar en sträng med spelare1:s namn följt av "Score: " samt spelare1:s poäng
    public String player1Score(){
        //TODO
        return "Not implemented";

    }
    //Returnerar en sträng med spelare2:s namn följt av "Score: " samt spelare2:s poäng
    public String player2Score(){
        //TODO
        return "Not implemented";
    }

    //Ger this.Dice ett värde mellan 1 och 20, samt ökar this.roundCounter med 1;
    public void throwDice(){
        //TODO
    }
    // Lägger till värdet på this.dice till den aktuelle spelaren poäng
    // Nollställer därefter this.dice och this.roundCounter
    //Kollar sedan om någon av spelarna har nått 100 poäng och om så är fallet sätts gameOver till true;
    public void addScore(){
        //TODO
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
