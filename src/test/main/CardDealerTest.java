package main;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CardDealerTest extends CardDealer{
    @Test
    public void createPlayers() {
        ArrayList<Player> testPlayers1 = new ArrayList<>();
        createPlayers(10, testPlayers1);
        assertEquals(testPlayers1.size(), 10);

        ArrayList<Player> testPlayers2 = new ArrayList<>();
        createPlayers(4, testPlayers2);
        assertEquals(testPlayers2.size(), 4);
    }

    @Test
    public void deal() {
        ArrayList<Player> testPlayers1 = new ArrayList<>();
        createPlayers(4, testPlayers1);
        ArrayList<Card> testDeck1 = new ArrayList<>();
        Deck.createDeck(testDeck1);
        deal(testPlayers1, testDeck1);

        //Test that 4 players have 13 cards each
        for(int i = 0; i < testPlayers1.size(); i++){
            assertEquals(testPlayers1.get(i).hand.size(), 13);
            for(int j = i + 1; j < testPlayers1.size(); j++){
                assertEquals(testPlayers1.get(i).hand.size(), testPlayers1.get(j).hand.size());
            }
        }

        //Test that the deck has no cards
        assertEquals(testDeck1.size(), 0);

        ArrayList<Player> testPlayers2 = new ArrayList<>();
        createPlayers(5, testPlayers2);
        ArrayList<Card> testDeck2 = new ArrayList<>();
        Deck.createDeck(testDeck2);
        deal(testPlayers2, testDeck2);

        //Test that 5 players have  10 cards each
        for(int i = 0; i < testPlayers2.size(); i++){
            assertEquals(testPlayers2.get(i).hand.size(), 10);
            for(int j = i + 1; j < testPlayers2.size(); j++){
                assertEquals(testPlayers2.get(i).hand.size(), testPlayers2.get(j).hand.size());
            }
        }

        //Test that the deck has 2 cards left
        assertEquals(testDeck2.size(), 2);

    }
}
