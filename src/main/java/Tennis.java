public class Tennis {
    private int firstPlayerScoreTimes;

    public int score() {
        if(firstPlayerScoreTimes==1){
            return 15;
        }
        return 0;
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }
}
