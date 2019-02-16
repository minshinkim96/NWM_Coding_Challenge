package main;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DeckTest {
    @Test
    public void createDeck() {
        ArrayList<Card> testDeck = new ArrayList<>();
        assertEquals(testDeck.size(), 0);
        Deck.createDeck(testDeck);
        assertEquals(testDeck.size(), 52);
    }

    @Test
    public void checkForNullCards(){
        ArrayList<Card> testDeck = new ArrayList<>();
        Deck.createDeck(testDeck);
        for(int i = 0; i < testDeck.size(); i++){
            assertNotNull(testDeck.get(i));
            assertNotNull(testDeck.get(i).getSuite());
            assertNotNull(testDeck.get(i).getValue());
        }
    }

    @Test
    public void checkNoDuplicateCards(){
        ArrayList<Card> testDeck = new ArrayList<>();
        Deck.createDeck(testDeck);
        for(int i = 0; i < testDeck.size(); i++){
            for(int j = i + 1; j < testDeck.size(); j++){
                assertNotEquals(testDeck.get(i), testDeck.get(j));
            }
        }
    }

    @Test
    public void shuffle() {
        ArrayList<Card> testDeck1 = new ArrayList<>();
        ArrayList<Card> testDeck2 = new ArrayList<>();
        Deck.createDeck(testDeck1);
        Deck.createDeck(testDeck2);
        Deck.shuffle(testDeck1);
        assertNotEquals(testDeck1, testDeck2);
    }

    @Test
    public void drawCard() {
        ArrayList<Card> testDeck1 = new ArrayList<>();
        int cardsDrawn = 0;
        Deck.createDeck(testDeck1);
        for(int i = 0; i < testDeck1.size(); i++){
            Deck.drawCard(testDeck1);
            cardsDrawn++;
            assertEquals(testDeck1.size(), 52 - cardsDrawn);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void drawCardFromEmptyDeck(){
        ArrayList<Card> testDeck1 = new ArrayList<>();
        Deck.drawCard(testDeck1);
        assertEquals(testDeck1.size(), 51);
    }
}