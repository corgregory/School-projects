/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circles;
import java.util.Scanner;
/**
 *
 * @author shaetavia // owner of the pc I was using in school before I got my own.
 */
public class Circles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // prompt useer for input of first x and y coordinates
        System.out.print(" Please enter two X coordinate and Y coordinate for first circle. ");
        double x;
       double y;
        // declare x and why variables to store values
       x = input.nextDouble();
       y = input.nextDouble();
      // promt user for coordinates of the second circle
       System.out.print(" Please enter x and y coordinates for the second circle. ");
       // these variables will hold values for second circle
       double _x = input.nextDouble();
       double _y = input.nextDouble();
       
      System.out.print("Please enter the radius of the first circle.");
      double r1 = input.nextDouble();
     
      System.out.print("Please enter the radius of the second circle.");
      double r2 = input.nextDouble();
      
      double testX = _x - x;
      double testY = _y - y;
      // this is the distance formula converted to the java language
      double Distance = Math.sqrt(Math.pow(testX, 2) - Math.pow(testY, 2));
    
      System.out.print(" The Distance between the two circles is " + Distance);
      // this if statwement is true if the circle is inside the first one
      if (Distance <= Math.abs(x - _x)){
          System.out.print("The second Circle is inside the First one .");
      }
      // this if statement is true if the second circle is overlapping the first.
      else if (Distance <= Math.abs(y +_y)){
          System.out.print("The second circle is overlapping the First Circle. ");
      } 
      
             
    }
    
}
