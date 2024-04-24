import java.util.HashMap;
import java.util.Map;

public class TennisScore implements TennisInterface {

    private int firstPlayerScoreTimes;
    private int secondPlayerScoreTimes;
    private String playerFirstName;
    private String secondPlayerName;
    private Map<Integer, String> mapScores = new HashMap<>() {{
        put(0, "0");
        put(1, "15");
        put(2, "30");
        put(3, "40");
    }};

    public TennisScore(String playerFirstName, String secondPlayerName) {
        this.playerFirstName = playerFirstName;
        this.secondPlayerName = secondPlayerName;
    }

    public TennisScore() {

    }

    public String score() {
        if(isScoreDifferent()){
            return isAdvantageOrGameOver() ? evaluateAdvantage() : scoreEvaluator();
        }
        return isDeuceScore() ? deuceStatus() : scoreEvaluator();
    }

    private boolean isAdvantageOrGameOver() {
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
        return firstPlayerScoreTimes == 3 && secondPlayerScoreTimes == 3;
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
