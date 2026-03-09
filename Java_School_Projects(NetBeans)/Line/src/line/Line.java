/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package line;
import java.util.Scanner;

/**
 *
 * @author shaetavia
 * 
 */
public class Line {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TheLine line1 = new TheLine(5, 4, -17);
        double slope1 = line1.getSlope();
        boolean onLine1 = line1.isOnLine(5, -2);
        TheLine line2 = new TheLine(-25, 40, 30);
        double slope2 = line2.getSlope();
        boolean onLine2 = line2.isOnLine(5, -2);
        TheLine line3 = new TheLine(line1);
        TheLine line4 = new TheLine(1, 3, 5);
        line4 = line1;
       line1.Print();
       line2.Print();
       line3.Print();
       line4.Print();
    }
    
}

class TheLine{
    private double a;
    private double b;
    private double c;
    
    TheLine() {
	double a = 1;
	double b = 1;
	double c = -2;
}
    
    TheLine(float _a, float _b, float _c) {
	a = _a;
	b = _b;
	c = _c;

}
    TheLine(TheLine L) {
	this.a = L.a;
	this.b = L.b;
	this.c = L.c;
    }
    
    

    double getSlope() {
	return -(a / b);
    }
    
    boolean isOnLine(double x, double y) {
	if (a * x + b * y + c == 0){
            System.out.println("Is on Line");
            return true;
        }
		
        else{
                System.out.println("Is not on Line");
		return false;

        }
}
    void Print() {

System.out.println(" The equation for the Line is " + a + "x +" + b + "y +" + c +" = 0");


}
        


}
    
