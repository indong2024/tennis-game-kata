import java.util.HashMap;
import java.util.Map;

public class Tennis implements TennisInterface {

    private int firstPlayerScoreTimes;
    private int secondPlayerScoreTimes;
    private final String playerFirstName;
    private final String secondPlayerName;
    private Map<Integer, String> mapScores = new HashMap<>() {{
        put(0, "0");
        put(1, "15");
        put(2, "30");
        put(3, "40");
    }};

    public Tennis(String playerFirstName, String secondPlayerName) {
        this.playerFirstName = playerFirstName;
        this.secondPlayerName = secondPlayerName;
    }


    public String score() {
        if(isScoreDifferent()){
            return isAdvanatageOrGameOver() ? evaluateAdvantage() : scoreEvaluator();
        }
        return isDeuceScore() ? deuceStatus() :scoreEvaluator();
    }

    private boolean isAdvanatageOrGameOver() {
        return firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3;
    }

    private String evaluateAdvantage() {
        if (isAdvantage()){
            return displayAdvantage();
        }
        return displayGameWinner();
    }

    private boolean isAdvantage() {
       return Math.abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1;
    }

    private String deuceStatus() {
        return "Deuce";
    }

    private String displayAdvantage() {
        return "Advantage for " + getAdvantagePlayer();
    }

    private String displayGameWinner() {
        return getAdvantagePlayer() + " wins the game";
    }

    private String getAdvantagePlayer() {
        return firstPlayerScoreTimes > secondPlayerScoreTimes ? playerFirstName : secondPlayerName;
    }

    private boolean isDeuceScore() {
        return firstPlayerScoreTimes == 3;
    }

    private boolean isScoreDifferent() {
        return firstPlayerScoreTimes != secondPlayerScoreTimes;
    }

    private String scoreEvaluator(){

        return playerFirstName +": "+ mapScores.get(firstPlayerScoreTimes) + " / "+  secondPlayerName+": " + mapScores.get(secondPlayerScoreTimes);
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }

    public void secondPlayerScore() {
        secondPlayerScoreTimes++;
    }
}
