import org.junit.Assert;
import org.junit.Test;

public class TennisTest {

    Tennis tennis = new Tennis();

    @Test
    public void initializationShouldReturnZero (){
        scoreShouldDisplay(0);
    }

    @Test
    public void shouldReturnFifteen (){
        tennis.firstPlayerScore();
        scoreShouldDisplay(15);
    }

    private void scoreShouldDisplay (int expected) {
        Assert.assertEquals(expected , tennis.score());
    }


}