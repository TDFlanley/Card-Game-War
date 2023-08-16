/*
 */
package main;


/**
 *
 * @author flant
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;                             //allows for the use of custom fonts
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;                       //allows use of colors
import javafx.stage.Stage;
public class Main extends Application
{
    //Top variables
    Label lblScore = new Label("Score: ");
    Font fntScore = Font.font("Verdana",FontWeight.BOLD,20); //Font.font instead of new Font() so we can include bold in the font
    Color clrScore = Color.rgb(250,0, 250);
    TextField tfLeft = new TextField();
    Label lblLeft = new Label("Left: ");
    TextField tfRight = new TextField();
    Label lblRight = new Label("Right: ");
    //Center Variables
    Label lblCardLeft = new Label();
    Card cardLeft = new Card();         
    Label lblCardRight = new Label();
    Card cardRight = new Card();
    Label lblCardDeck = new Label();
    Card cardDeck = new Card();
    //reset button
    Button btnReset = new Button("Reset");
    //Vars for logistics
    boolean rightTurn = true;
    //the deck
    Deck theDeck = new Deck();


    @Override
    public void start(Stage primaryStage) 
    { 
        btnReset.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent t) 
            {
                Score.resetScore();
                tfRight.setText(String.valueOf(Score.getRightScore()));
                tfLeft.setText(String.valueOf(Score.getLeftScore()));
                rightTurn = true;
                resetCardImages();
            }
        });
        
        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent arg0) 
            {
                if(rightTurn == true)                             
                {
                      cardRight = theDeck.deal();                            //card is assigned from the deck
                      lblCardRight.setGraphic(cardRight);
                }
                else
                {
                      cardLeft = theDeck.deal();
                      lblCardLeft.setGraphic(cardLeft);
                      
                    if(cardRight.getValue() > cardLeft.getValue())  //checking for winner
                    {      
                          Score.setRightScore(cardRight.getValue());
                          tfRight.setText(String.valueOf(Score.getRightScore()));   
                    }
                    else if(cardLeft.getValue() > cardRight.getValue())
                    {
                        Score.setLeftScore(cardLeft.getValue());
                        tfLeft.setText(String.valueOf(Score.getLeftScore()));
                    }
               }
                rightTurn = !rightTurn;
            }
        });
        
        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();                     //top pane
        GridPane cardPane = new GridPane();                    //middle pane
        Scene scene = new Scene(root, 450,350);    //add root, H & W to give scene parameters
        primaryStage.setScene(scene);                         //scene -> primaryStage
        primaryStage.setTitle("War");                //title -> primaryStage
        primaryStage.show();                                  //primaryStage set to VISIBLE    
        
        //The Top Pane
        lblScore.setFont(fntScore);                       //apply font and color to Score Label
        lblScore.setTextFill(clrScore);
        tfLeft.setPrefWidth(50);                            //set Left tf attrib                
        tfLeft.setDisable(true);
        tfLeft.setText(String.valueOf(Score.getLeftScore()));
        tfRight.setPrefWidth(50);                          //set Right tf attrib
        tfRight.setDisable(true);
        tfRight.setText(String.valueOf(Score.getRightScore()));
        topPane.add(lblScore, 0, 0);              //lblScore -> topPane
        topPane.add(lblLeft, 0, 1);               //left and right label/text field -> topPane
        topPane.add(tfLeft, 1, 1);
        topPane.add(lblRight,2,1);
        topPane.add(tfRight,3,1);
        topPane.setHgap(20);                            //set H = 20 & V = 10 gap
        topPane.setVgap(10);
        root.setTop(topPane);                        //topPane -> scene
        
        //The Center Pane
        resetCardImages();
        cardPane.setHgap(20);
        cardPane.add(lblCardLeft, 0, 0);      //lblCards -> cardPane
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.add(lblCardRight, 2, 0);
        cardPane.setAlignment(Pos.CENTER);        //cardPane position = center
        root.setCenter(cardPane);
        
        root.setBottom(btnReset);                //reset button -> scene
    }   
    public void resetCardImages()
    {
        cardLeft = new Card();                              //now uses default const
        lblCardLeft.setGraphic(cardLeft);            
        cardDeck = new Card();
        lblCardDeck.setGraphic(cardDeck);
        cardRight = new Card();
        lblCardRight.setGraphic(cardRight);
    }
    
    public static void main(String[] args) 
    {
        launch(args);    
    }    
} 
