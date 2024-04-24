import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TennisTest {

    private final String playeFirstrName = "Player A";
    private final String secondPlayerName = "Player B";
    Tennis tennis = new Tennis(playeFirstrName, secondPlayerName);

    @Test
    public void initializationShouldReturnZeroForAll (){
        shouldDisplayFirstPlayerScores (0);
        shouldDisplaySecondPlayerScores(0);
        scoreShouldDisplay(playeFirstrName +": 0 / "+ secondPlayerName +": 0");
    }

    @Test
    @DisplayName("Test Player A scores 1 times and B  don't score")
    public void shouldReturnFifteen (){
        shouldDisplayFirstPlayerScores (1);
        scoreShouldDisplay(playeFirstrName +": 15 / "+ secondPlayerName +": 0");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B  don't score")
    public void shouldReturnThirty (){
        shouldDisplayFirstPlayerScores (2);
        scoreShouldDisplay(playeFirstrName +": 30 / "+ secondPlayerName +": 0");
    }

    @Test
    @DisplayName("Test Player A scores 3 times and B  don't score")
    public void shouldReturnForty (){
        shouldDisplayFirstPlayerScores (3);
        scoreShouldDisplay(playeFirstrName +": 40 / "+ secondPlayerName +": 0");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  1 times")
    public void shouldReturnFifteen2 (){
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay(playeFirstrName + ": 0 / "+ secondPlayerName + ": 15");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  2 times")
    public void shouldReturnThirty2 (){
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay(playeFirstrName + ": 0 / "+ secondPlayerName +": 30");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  3 times")
    public void shouldReturnForty2 (){
        shouldDisplaySecondPlayerScores (3);
        scoreShouldDisplay(playeFirstrName + ": 0 / "+ secondPlayerName + ": 40");
    }

    @Test
    @DisplayName("Test Player A scores 1 times and B  1 times")
    public void shouldReturnFifteenForBoth (){
        shouldDisplayFirstPlayerScores (1);
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay(playeFirstrName + ": 15 / "+ secondPlayerName + ": 15");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B  2 times")
    public void shouldReturnThirtyForBoth (){
        shouldDisplayFirstPlayerScores (2);
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay(playeFirstrName + ": 30 / Player B: 30");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B 1 time")
    public void testPlayerAScores2timesAndPlayerBScores1time() {
        shouldDisplayFirstPlayerScores (2);
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay(playeFirstrName + ": 30 / Player B: 15");
    }

    @Test
    @DisplayName("Test Player A scores 3 times and B  2 times")
    public void testPlayerAScores3timesAndPlayerBScores2time() {
        shouldDisplayFirstPlayerScores (3);
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay(playeFirstrName + ": 40 / Player B: 30");
    }

    @Test
    @DisplayName("Test Deuce")
    public void testShouldReturnDeuce() {
        deuceScores();
        scoreShouldDisplay("Deuce");
    }

    @Test
    @DisplayName("Test Advantage Player A after deuce")
    public void ShouldReturnAdvantageA() {
        deuceScores();
        shouldDisplayFirstPlayerScores (1);
        scoreShouldDisplay("Advantage for Player A");
    }

    @Test
    @DisplayName("Test Advantage Player B after deuce")
    public void ShouldReturnAdvantageB() {
        deuceScores();
        shouldDisplaySecondPlayerScores (1);
        scoreShouldDisplay("Advantage for Player B");
    }

    @Test
    @DisplayName("Test Player A is the winner")
    public void ShouldReturnPlayerAWinner() {
        deuceScores();
        shouldDisplayFirstPlayerScores (2);
        scoreShouldDisplay("Player A wins the game");
    }

    @Test
    @DisplayName("Test Player B is the winner")
    public void ShouldReturnPlayerBWinner() {
        deuceScores();
        shouldDisplaySecondPlayerScores (2);
        scoreShouldDisplay("Player B wins the game");
    }


    private void scoreShouldDisplay (String expected) {
        Assert.assertEquals(expected , tennis.score());
    }

    private void shouldDisplayFirstPlayerScores (int times){
        for (int i = 0; i < times; i++){
            tennis.firstPlayerScore();
        }
    }
    private void shouldDisplaySecondPlayerScores (int times){
        for (int i = 0; i < times; i++){
            tennis.secondPlayerScore();
        }
    }

    private void deuceScores(){
        shouldDisplayFirstPlayerScores (3);
        shouldDisplaySecondPlayerScores(3);
    }


}