import java.util.HashMap;
import java.util.Map;

public class Tennis {
    private int firstPlayerScoreTimes;
    private int secondPlayerScoreTimes;
    private Map<Integer, String> mapScores = new HashMap<>() {{
        put(0, "0");
        put(1, "15");
        put(2, "30");
        put(3, "40");
    }};

    public String score() {
        if(isScoreDifferent()){
            if (firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3) {
                if (Math.abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1){
                    return displayAdvantage();
                }
                return displayGameWinner();
            }
           return scoreEvaluator();
        }
        else if(isDeuce()) {
            return "Deuce";
        }
        return scoreEvaluator();
    }

    private String displayAdvantage() {
        return "Advantage for " + getAdvanatagePlayer();
    }

    private String displayGameWinner() {
        return getAdvanatagePlayer() + " wins the game";
    }

    private String getAdvanatagePlayer() {
        return firstPlayerScoreTimes > secondPlayerScoreTimes ? "Player A" : "Player B";
    }

    private boolean isDeuce() {
        return firstPlayerScoreTimes == 3;
    }

    private boolean isScoreDifferent() {
        return firstPlayerScoreTimes != secondPlayerScoreTimes;
    }

    private String scoreEvaluator(){

        return "Player A: " + mapScores.get(firstPlayerScoreTimes) + " / Player B: " + mapScores.get(secondPlayerScoreTimes);
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }

    public void secondPlayerScore() {
        secondPlayerScoreTimes++;
    }
}
