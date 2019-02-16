package main;

import java.util.*;

public class CardDealer {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Card> deckOfCards = new ArrayList<>();

    public static void main(String args[]){

        playerLoop();
        Deck.createDeck(deckOfCards);
        Deck.shuffle(deckOfCards);
        deal(players, deckOfCards);
        printCards(players);
    }

    public static void playerLoop(){
        int numberOfPlayers;
        Scanner input = new Scanner(System.in);

        System.out.println("How many players are at the table?");
        while (true) {
            try {
                numberOfPlayers = input.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer!");
                input.nextLine();
            }
        }
        System.out.println("There are " + numberOfPlayers + " players.");
        createPlayers(numberOfPlayers, players);
    }

    public static void createPlayers(int numberOfPlayers, ArrayList<Player> players){
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(new Player());
        }
    }

    public static void deal(ArrayList<Player> players, ArrayList<Card> deckOfCards){
        int counter = 0;
        int cardsPerPlayer = Math.floorDiv(deckOfCards.size(), players.size());

        while(players.get(players.size() - 1).hand.size() != cardsPerPlayer){
            Card drawnCard = Deck.drawCard(deckOfCards);
            players.get(counter % players.size()).hand.add(drawnCard);
            counter++;
        }
    }

    public static void printCards(ArrayList<Player> players){

        for(int i = 0; i < players.size(); i++){
            System.out.print('\n' + "Cards for player " + (i + 1) + ":" + '\n');
            for(int j = 0; j < players.get(i).hand.size(); j++){
                System.out.print(players.get(i).hand.get(j).toString());
            }
        }
    }
}