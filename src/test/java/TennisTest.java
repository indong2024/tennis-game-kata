import org.junit.Assert;
import org.junit.Test;

public class TennisTest {
    @Test
    public void initializationShouldReturnZero (){
        Tennis tennis = new Tennis();
        Assert.assertEquals("0", tennis.score());
    }
}