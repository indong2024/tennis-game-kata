import java.util.ArrayList;
import java.util.List;

public class TennisGame {
    private int firstPlayerScoreTimes = 0;
    private int secondPlayerScoreTimes = 0;
    private boolean deuce = false;
    private boolean advantageA = false;
    private boolean advantageB = false;
    private boolean gameOver = false;
    private List<TennisInterface> tennisInterfaces = new ArrayList<>();

    public void updatePeople(TennisInterface people) {
        tennisInterfaces.add(people);
    }

    private void notifyPeople() {
        for (TennisInterface tennisInterface : tennisInterfaces) {
            tennisInterface.score();
        }
    }

    public void playerAWonTheGame() {
        if (gameOver) {
            return;
        }

        if (deuce) {
            if (advantageB) {
                deuce = false;
            } else {
                advantageA = true;
            }
        } else {
            firstPlayerScoreTimes++;
            if (firstPlayerScoreTimes == 3 && secondPlayerScoreTimes == 3) {
                deuce = true;
            } else if (firstPlayerScoreTimes == 4) {
                gameOver = true;
            }
        }

        notifyPeople();
    }

    public void playerBWonTheGame() {
        if (gameOver) {
            return;
        }

        if (deuce) {
            if (advantageA) {
                deuce = false;
            } else {
                advantageB = true;
            }
        } else {
            secondPlayerScoreTimes++;
            if (firstPlayerScoreTimes == 3 && secondPlayerScoreTimes == 3) {
                deuce = true;
            } else if (secondPlayerScoreTimes == 4) {
                gameOver = true;
            }
        }

        notifyPeople();
    }
}
