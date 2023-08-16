
package main;

public class Score
{
    static int scoreLeft = 0;         //There is only one copy of a static variable
    static int scoreRight = 0;        // It belongs to the class instead of an instance of the class
    
   static void setRightScore(int intArg)           //setters
   {
       scoreRight += intArg;
   }
   static void setRightScore(String strArg)
   {
       scoreRight += Integer.parseInt(strArg);
   }
   static void setLeftScore(int intArg)
   {
       scoreLeft += intArg;
   }
   static void setLeftScore(String strArg)
   {
       scoreLeft += Integer.parseInt(strArg);
   }
   
   static int getRightScore()                      //getters
   {
       return scoreRight;
   }
   static int getLeftScore()
   {
       return scoreLeft;
   }
   
   static void resetScore()
   {
       scoreLeft = 0;
       scoreRight = 0;
   }
   
    
}
