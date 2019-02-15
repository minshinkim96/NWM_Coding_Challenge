package main;

public class Card {

    public enum Suite{
        Clubs, Diamonds, Hearts, Spades
    }

    public enum Value{
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
    }

    private Suite suite;
    private Value value;

    public Card(Suite suite, Value value){
        this.value = value;
        this.suite = suite;
    }

    public String toString(){
        return value + " of " + suite + '\n';
    }

}