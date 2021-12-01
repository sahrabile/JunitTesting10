import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackEndTest {
    private BackEnd backEnd = new BackEnd();
    //UserManager manager = Mockito.mock(Usemanager.class);

    @Test
    @DisplayName("Ska testa att vinnaren är Niklas")
    void getWinnerplayer1Test() {
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetP1Score(1001);
        assertEquals("And the Winner is Niklas", backEnd.getWinner());
    }
    @Test
    void getWinnerPlayer2Test(){
        backEnd.tempSetplayer2("Henning");
        backEnd.tempSetP2Score(1002);
        assertEquals("And the Winner is Henning", backEnd.getWinner());
    }
    @Test
    void getWinnerWhenNoOneIsWinnerTest(){
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetplayer2("Henning");
        backEnd.tempSetP1Score(0);
        backEnd.tempSetP2Score(0);
        assertEquals("No one win!",backEnd.getWinner());
    }
    @Test
    void getWinnerWhenPlayer1AndPlayer2ON100Test(){
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetplayer2("Henning");
        backEnd.tempSetP1Score(100);
        backEnd.tempSetP2Score(0);
        assertEquals("And the Winner is Niklas",backEnd.getWinner());
        backEnd.tempSetP1Score(0);
        backEnd.tempSetP2Score(100);
        assertEquals( "And the Winner is Henning",backEnd.getWinner());
    }
    @Test
    void getWinnerCalledTwiceWinnerTest(){
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetP1Score(100);
        assertEquals("And the Winner is Niklas",backEnd.getWinner());
        assertEquals("And the Winner is Niklas",backEnd.getWinner());
    }

    @Test
    void currentPlayerNameForPlayerTest() {
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetplayer2("Henning");
        backEnd.tempSetCurrentPlayer(1);
        assertEquals("Niklas",  backEnd.currentPlayerName());
        backEnd.tempSetCurrentPlayer(2);
        assertEquals("Henning", backEnd.currentPlayerName());
    }

    @Test
    void randomStarterTest() {
        boolean theyAreNotTheSame = true;
        backEnd.randomStarter();
        int firstPlayer = backEnd.getCurrentPlayer();
        for(int i = 0; i<100; i++){
            backEnd.randomStarter();
            if(firstPlayer != backEnd.getCurrentPlayer()){}
            theyAreNotTheSame = true;
            break;
        }
    }
    @Test
    void player1ScoreWhenScoreIs22Test() {
        //input
        backEnd.tempSetplayer1("Niklas");
        //when
        backEnd.tempSetP1Score(22);
        //result
        assertEquals("Niklas score 22",backEnd.player1Score());
    }
    @Test
    void player2ScoreWhenScoreIs35Test() {
        backEnd.tempSetplayer2("Henning");
        backEnd.tempSetP2Score(35);
        assertEquals("Henning score 35",backEnd.player2Score());
    }


    @Test
    void throwDiceTest() {
        for(int i =0; i<100;i++){
            backEnd.throwDice();
            int numberOfDice = backEnd.getDice();
            System.out.println(numberOfDice);
            assertTrue(numberOfDice >=1 &&numberOfDice <= 20);
        }
    }

    @Test
    void addScoreP1_NoWin() {
        backEnd.tempSetP1Score(50);
        backEnd.tempSetP2Score(50);
        backEnd.tempSetCurrentPlayer(1);
        backEnd.tempSetDice(49);
        backEnd.addScore();
        assertEquals(99, backEnd.tempGetP1Score());
        assertEquals(50, backEnd.tempGetP2Score());
        assertFalse(backEnd.tempGetGameOver());


    }
    @Test
    void addScoreP2_NoWin() {
        backEnd.tempSetP1Score(50);
        backEnd.tempSetP2Score(50);

        backEnd.tempSetCurrentPlayer(2);
        backEnd.tempSetDice(49);
        backEnd.addScore();
        assertEquals(50, backEnd.tempGetP1Score());
        assertEquals(99, backEnd.tempGetP2Score());
        assertFalse(backEnd.tempGetGameOver());
    }

    @Test
    void startGameTest() {
        backEnd.startGame("Niklas", "Edwin");
        assertEquals("Niklas",backEnd.getPlayer1());
        assertEquals("Edwin",backEnd.getPlayer2());
        assertEquals( "Niklas score 0",backEnd.player1Score());
        assertEquals("Edwin score 0",backEnd.player2Score());
        assertEquals(1,backEnd.getCurrentPlayer());

    }

    @Test
    void askToKeep() {
    }

    @Test
    void getPlayer1() {
        backEnd.startGame("Niklas","Edwin");
        assertEquals("Niklas",backEnd.getPlayer1());


    }

    @Test
    void getPlayer2() {
        backEnd.startGame("Niklas", "Edwin");
        assertEquals("Edwin",backEnd.getPlayer2());
    }

    @Test
    void getCurrentPlayerTest() {
        backEnd.tempSetplayer1("Niklas");
        backEnd.tempSetplayer2("Edwin");
        backEnd.randomStarter();
        if(backEnd.getCurrentPlayer() ==1){

        }

    }

    @Test
    void getDice() {
    }

    @Test
    void gameOver() {
    }
}