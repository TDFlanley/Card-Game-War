
package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
public class Card extends Label
{
    private Image imgRef;
    private int value;
    private String strImgPath = ""; 
    private Suit.enumSuit suit;
    
    public Card(String path)
    {
        this.setImage(path);
    }
    public Card()
    {
        this.setImage("file:img\\155.gif");
    }
    private boolean loadCard(String path)
    {
        imgRef = new Image(path);                       //create space for img reference
        this.setGraphic(new ImageView(imgRef));        //Set graphic on label created above
        this.getSuit();
        this.getCardValue(path);
        return true;
    }
    private int getCardValue(String path)
    {
        String strValue = "";
        for(int i = 9; i < 13; i++)
        {
            char ch = path.charAt(i);
            if(Character.isDigit(ch))
            {
                 strValue += ch;
            }
        }
        value = Integer.parseInt(strValue);
        if(value > 100 && value < 114)                                        //check suit
        {
            this.suit = Suit.enumSuit.Diamonds;
            if(value == 101)
            {
                value = 11;
            }
            else if(value > 101 & value < 110 )
            {
                value = value % 100;
            }
            else
            {
                value = 10;
            }
        }
        else if(value > 113 && value < 127)
        {
            this.suit = Suit.enumSuit.Clubs;
            if(value == 114)
            {
                value = 11;
            }
            else if(value > 114 & value < 123 )
            {
                value = (value-13) % 100;
            }
            else
            {
                value = 10;
            }
        }
        else if(value > 126 && value < 140)
        {
            this.suit = Suit.enumSuit.Hearts;
            if(value == 127)
            {
                value = 11;
            }
            else if(value > 127 && value < 136)
            {
                value = (value - 26) % 100;
            }
            else
            {
                value = 10;
            }
        }
        else if(value > 139 && value < 153)
        {
            this.suit = Suit.enumSuit.Spades;
            if(value == 140)
            {
                value = 11;
            }
            else if(value > 140 && value < 149)
            {
                value = (value - 39 ) % 100;
            }
            else
            {
                value = 10;
            }
        }
        return value;
    }
    public int getValue()
    {
        return value;
    }
    public Suit.enumSuit getSuit()
    {
        return suit;
    }
     public void setImage(String path)
    {
        strImgPath = path;
        this.loadCard(strImgPath);
    }
}
