import java.util.HashMap;

public class Tennis {
    private int firstPlayerScoreTimes;

    public int score() {
        HashMap<Integer, Integer> mapScores = new HashMap<Integer, Integer>() {{
            put(1, 15);
            put(2, 30);
        }};
        if(firstPlayerScoreTimes > 0){
            return mapScores.get(firstPlayerScoreTimes);
        }
        return 0;
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }
}
