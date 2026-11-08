enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    JACK, QUEEN, KING, ACE }

enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

public class Card 
{
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
}