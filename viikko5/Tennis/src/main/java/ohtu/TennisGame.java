package ohtu;

import java.util.HashMap;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private HashMap<Integer, String> scorings;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        scorings = new HashMap<>();
        scorings.put(0, "Love");
        scorings.put(1, "Fifteen");
        scorings.put(2, "Thirty");
        scorings.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return getEvenScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getWinOrAdvantageScore();
        } else {
            return getLeadScore();
        }
    }

    private String getEvenScore() { // tässä ja viimeisessä toistoa, tallensi hashMapiin Stringit
        if (scorings.containsKey(player1Score)) {
            return scorings.get(player1Score) + "-All";
        }

        return "Deuce";
    }

    private String getWinOrAdvantageScore() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getLeadScore() {
        String score = "";
        
        score += scorings.get(player1Score);
        score += "-";
        score += scorings.get(player2Score);
        
//        int tempScore;
//        for (int i = 1; i < 3; i++) {
//            if (i == 1) {
//                tempScore = player1Score;
//            } else {
//                score += "-";
//                tempScore = player2Score;
//            }
//            switch (tempScore) {
//                case 0:
//                    score += "Love";
//                    break;
//                case 1:
//                    score += "Fifteen";
//                    break;
//                case 2:
//                    score += "Thirty";
//                    break;
//                case 3:
//                    score += "Forty";
//                    break;
//            }
//        }
        return score;
    }
}
