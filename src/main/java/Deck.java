import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck 
{
    private final List<Card> deck = new ArrayList<>();

    public Deck() 
    {
        for (Suit suit : Suit.values()) 
            for (Rank rank : Rank.values()) 
                deck.add(new Card(rank, suit));
        
        Collections.shuffle(deck);
    }
}