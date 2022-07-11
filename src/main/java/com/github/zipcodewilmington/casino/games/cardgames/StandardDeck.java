package com.github.zipcodewilmington.casino.games.cardgames;


import java.util.*;

public class StandardDeck implements Deck {
    Deque<PlayingCard> cards;

    public StandardDeck() {
        List<PlayingCard> newCards = initCards();
        shuffle(newCards);
        this.cards = new ArrayDeque<>(newCards);
    }

    public void shuffle(List<PlayingCard> cards) {
        Collections.shuffle(cards);
    }

    public void shuffle() {
        List<PlayingCard> tmp = new ArrayList<>(cards);
        Collections.shuffle(tmp);
        cards = new ArrayDeque<>(tmp);
    }

    // pop card from top of deck
    public PlayingCard dealCard() {
        return cards.pop();
    }

    // insert a card to the bottom of deck
    public void insertCardFromBottom(PlayingCard card) {
        cards.offerLast(card);
    }

    // reset cards to a new shuffled state
    public void reset() {
        List<PlayingCard> newCards = initCards();
        shuffle(newCards);
        this.cards = new ArrayDeque<>(newCards);
    }

    public int getDeckSize() {
        return cards.size();
    }

    public Deque<PlayingCard> getCards() {
        return cards;
    }
    protected List<PlayingCard> initCards() {
        List<PlayingCard> newCards = new ArrayList<>();
        for (CardRank r : CardRank.values()) {
            for (CardSuit s : CardSuit.values()) {
                newCards.add(new PlayingCard(s, r));
            }
        }
        return newCards;
    }
    // TODO: Add graphic console representation of Deck
    public void printCards() {
    }

}
