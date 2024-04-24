import java.util.Scanner;

public class TennisDisplayScoreAndWinner {

    public void main (String[] args) {

        TennisGame game = new TennisGame();
        TennisScore tennisScore = new TennisScore();
        game.updatePeople(tennisScore);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char inputCharacter = input.charAt(i);
            if (isInputCharacterA (inputCharacter) ) {
                game.playerAWonTheGame();
            } else if (isInputCharacterB (inputCharacter) ) {
                game.playerBWonTheGame();
            }
        }
    }

    private boolean isInputCharacterA(char inputCharacter) {
        return inputCharacter == 'A';
    }

    private boolean isInputCharacterB(char inputCharacter) {
        return inputCharacter == 'B';
    }
}
