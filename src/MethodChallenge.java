public class MethodChallenge {
    public static void main (String[] args){
        int playerScore = 100;
        int calculate = highscoreposition(playerScore);
        displayHighScoreposition("mukilan" , calculate );

    }

    public static void displayHighScoreposition(String playerName ,int highScore){
        System.out.println(playerName +"is high score of "+ highScore);
    }

    public static int highscoreposition(int playerScore){
        if(playerScore >= 1000){
               return 1;
        }else if(playerScore >= 500 &&  playerScore < 1000){
               return 2;
        }else if (playerScore >= 100 && playerScore < 500){
               return 3;
        }else {
            return 4;
        }
    }
}
