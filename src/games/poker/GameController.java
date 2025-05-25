package games.poker;



public class GameController {
    public static void main(String[] args) {
        PokerGame fiveCardDraw = new PokerGame(10, 5);
        fiveCardDraw.startGame();
        String s = "ddd";
        int hash = s.hashCode();
        System.out.println("Hash code of \"" + s + "\": " + hash);

    }
}
