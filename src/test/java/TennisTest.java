import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TennisTest {

    Tennis tennis = new Tennis();

    @Test
    public void initializationShouldReturnZeroForAll (){
        shouldDisplayFirstPlayerScores (0);
        shouldDisplaySecondPlayerScores(0);
        scoreShouldDisplay("Player A: 0 / Player B: 0");
    }

    @Test
    @DisplayName("Test Player A scores 1 times and B  don't score")
    public void shouldReturnFifteen (){
        shouldDisplayFirstPlayerScores (1);
        scoreShouldDisplay("Player A: 15 / Player B: 0");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B  don't score")
    public void shouldReturnThirty (){
        shouldDisplayFirstPlayerScores (2);
        scoreShouldDisplay("Player A: 30 / Player B: 0");
    }

    @Test
    @DisplayName("Test Player A scores 3 times and B  don't score")
    public void shouldReturnForty (){
        shouldDisplayFirstPlayerScores (3);
        scoreShouldDisplay("Player A: 40 / Player B: 0");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  1 times")
    public void shouldReturnFifteen2 (){
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay("Player A: 0 / Player B: 15");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  2 times")
    public void shouldReturnThirty2 (){
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay("Player A: 0 / Player B: 30");
    }

    @Test
    @DisplayName("Test Player A don't score  and B  3 times")
    public void shouldReturnForty2 (){
        shouldDisplaySecondPlayerScores (3);
        scoreShouldDisplay("Player A: 0 / Player B: 40");
    }

    @Test
    @DisplayName("Test Player A scores 1 times and B  1 times")
    public void shouldReturnFifteenForBoth (){
        shouldDisplayFirstPlayerScores (1);
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay("Player A: 15 / Player B: 15");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B  2 times")
    public void shouldReturnThirtyForBoth (){
        shouldDisplayFirstPlayerScores (2);
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay("Player A: 30 / Player B: 30");
    }

    @Test
    @DisplayName("Test Player A scores 2 times and B 1 time")
    public void testPlayerAScores2timesAndPlayerBScores1time() {
        shouldDisplayFirstPlayerScores (2);
        shouldDisplaySecondPlayerScores(1);
        scoreShouldDisplay("Player A: 30 / Player B: 15");
    }

    @Test
    @DisplayName("Test Player A scores 3 times and B  2 times")
    public void testPlayerAScores3timesAndPlayerBScores2time() {
        shouldDisplayFirstPlayerScores (3);
        shouldDisplaySecondPlayerScores(2);
        scoreShouldDisplay("Player A: 40 / Player B: 30");
    }

    @Test
    @DisplayName("Test Deuce")
    public void testShouldReturnDeuce() {
        shouldDisplayFirstPlayerScores (3);
        shouldDisplaySecondPlayerScores(3);
        scoreShouldDisplay("Deuce");
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


}