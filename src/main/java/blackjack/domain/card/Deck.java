package blackjack.domain.card;

import blackjack.domain.card.strategy.DrawCardsStrategy;
import blackjack.domain.card.strategy.RandomShuffleStrategy;
import blackjack.domain.card.strategy.ShuffleStrategy;

import java.util.List;
import java.util.Stack;

public class Deck {
    private static Deck deck = null;
    private static Stack<Card> cards = null;


    private Deck() {
        this.cards = new Stack<>();
        addCards();
        shuffle(new RandomShuffleStrategy());
    }

    public static Deck generate() {
        if (deck == null) {
            deck = new Deck();
        }

        return deck;
    }

    private static void addCards() {
        for (final CardType cardType : CardType.values()) {
            addCardsEachType(cardType);
        }
    }

    private static void addCardsEachType(final CardType cardType) {
        for (final CardValue cardValue : CardValue.values()) {
            cards.add(new Card(cardType, cardValue));
        }
    }


    public int size() {
        return cards.size();
    }

    public void shuffle(ShuffleStrategy shuffleStrategy) {
        shuffleStrategy.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }

    public List<Card> drawCards(DrawCardsStrategy drawCardsStrategy) {
        return drawCardsStrategy.drawCards(cards);
    }

    public void refresh() {
        cards.clear();
        addCards();
        shuffle(new RandomShuffleStrategy());
    }

    public List<Card> getCards() {
        return cards;
    }
}
