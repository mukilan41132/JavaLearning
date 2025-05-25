package games.poker;

import games.Card;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {

    private final List<Card> deck = Card.getStandardDeck();

    private int playerCount;

    private int cardsInHand;

    private List<PokerHand> pokerHands;

    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand){
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startGame(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        Collections.rotate(deck, 26);
        Card.printDeck(deck);

        dealCards();
        System.out.println("_________________________");
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));
      //  pokerHands.forEach(System.out::println);
        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;

        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining, null));

        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));

        Card.printDeck(remainingCards, "remaining Cards", 2);

    }

    private void dealCards(){
        Card[][] cards = new Card[playerCount][cardsInHand];
        for(int deckIndex = 0, i = 0; i< cardsInHand; i++){
            for(int j = 0; j < playerCount; j++){
                cards[j][i] = deck.get(deckIndex++);
            }
        }
        int playerNo = 1;
        for (Card[] hand : cards) {
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }

    }
}
