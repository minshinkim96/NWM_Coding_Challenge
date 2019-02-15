package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public static ArrayList<Card> createDeck(ArrayList<Card> deckOfCards){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                deckOfCards.add(new Card(Card.Suite.values()[i], Card.Value.values()[j]));
            }
        }
        return deckOfCards;
    }

    public static void shuffle(ArrayList<Card> deck){
        Collections.shuffle(deck);
    }

    public static Card drawCard(ArrayList<Card> deck){
        return deck.remove(deck.size() - 1);
    }

}