
package main;

import main.Card;
import java.util.ArrayList;
import java.util.Collections;
public class Deck extends ArrayList<Card> 
{
    int index = 0;           //so our deal method starts at 0
    final int LAST_CARD = 51; //to determine when deck needs to be reshuffled (cards == #'s 0-51)
    public Deck(String path)
    {
        this.loadCards(path);
    }
    public Deck()
    {
        this.loadCards("file:img\\");
    }
    public void shuffle()
    {
        Collections.shuffle(this);    //algo included with .Collections has a common set of algos that can be used on generics
    }
    private void loadCards(String path)
    {
        for(int i = 101; i < 153; i++ )
        {
            this.add(new Card(path + i + ".gif" ));
        }
        this.shuffle();
    }
    public Card deal()
    {
        if(index >= LAST_CARD)
        {
            this.shuffle();
            index = 0;
        }
        index++;
        return this.get(index);
    }
}
