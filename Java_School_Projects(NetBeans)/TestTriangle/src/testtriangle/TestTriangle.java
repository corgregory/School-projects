/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testtriangle;
/**
 *
 * @author shaetavia
 */
import java.util.Scanner;
public class TestTriangle {
  public static void main(String[] args) {
    //Create Triangle objects
	Triangle r1 = new Triangle(2, 2, 5.5, 4.9, 9.0, 10.3);
    Triangle r2 = new Triangle(4, 5, 10.5, 3.2, -0.5, -10.5);
    Triangle r3 = new Triangle(3, 5, 2.3, 6.7, 5.5, 8.8);
    Triangle r4 = new Triangle(4, 0, 6, 0, 5, 2);
    
	//Print the three points of a triangles
	System.out.println("Triangle r1:");
	r1.print();
	System.out.println("Triangle r2:");
	r2.print();
	System.out.println("Triangle r3:");
	r3.print();
	System.out.println("Triangle r4:");
	r4.print();
    System.out.println();
	
    System.out.printf("The area of triangle r1 is %.5f\n",  r1.getArea());
    System.out.printf("The perimeter of triangle r1 is %.5f\n", r1.getPerimeter());    
    System.out.println();    
	
	System.out.println("Triangle r1 contains point (6, 6): " + r1.contains(6, 6));
    System.out.println("Triangle r1 contains point (3, 13): " + r1.contains(3, 13));    
    System.out.println();  

    System.out.println("Triangle r1 contains triangle r2: " + r1.contains(r2));
    System.out.println("Triangle r2 contains triangle r4: " + r2.contains(r4));
    System.out.println("Triangle r1 overlaps triangle r2: " + r1.overlaps(r2));
    System.out.println("Triangle r1 overlaps triangle r3: " + r1.overlaps(r3));
    System.out.println();
 
    //Check two lines intersect each other   
    Line line1 = new Line(0.0, 0.0, 10.0, 0.0);
    Line line2 = new Line(5.0, -5.0, 8.0, 10.0);
    Line line3 = new Line(5.0, -5.0, 5.0, 1.0);
    
    System.out.println("Line line1 intersects Line line2: " + line1.intersectsLine(line2));
    System.out.println("Line line1 intersects Line line3: " + line1.intersectsLine(line3));
	System.out.println("Point(7.5, 7.5) is on Line line2: " + line2.contains(7.5, 7.5));
	System.out.println("Point(6.0, 7.5) is on Line line2: " + line2.contains(6.0, 7.5));    
  }
}


/** Output:
Triangle r1:
Three points are:
(2.0, 2.0)
(5.5, 4.9)
(9.0, 10.3)
Triangle r2:
Three points are:
(4.0, 5.0)
(10.5, 3.2)
(-0.5, -10.5)
Triangle r3:
Three points are:
(3.0, 5.0)
(2.3, 6.7)
(5.5, 8.8)
Triangle r4:
Three points are:
(4.0, 0.0)
(6.0, 0.0)
(5.0, 2.0)

The area of triangle r1 is 4.37500
The perimeter of triangle r1 is 21.83810

Triangle r1 contains point (6, 6): true
Triangle r1 contains point (3, 13): false

Triangle r1 contains triangle r2: false
Triangle r2 contains triangle r4: true
Triangle r1 overlaps triangle r2: true
Triangle r1 overlaps triangle r3: false

Line line1 intersects Line line2: true
Line line1 intersects Line line3: true
Point(7.5, 7.5) is on Line line2: true
Point(6.0, 7.5) is on Line line2: false
*/


//Triangle class
class Triangle {
  private Point p1, p2, p3;  //instance variables: three Point objects 
  
  final double error = 0.0001; //tolerance error when comparing two double precision numbers.
  
  //Constructors
  public Triangle() {
      p1 = new Point(0,0);
      p2 = new Point (0,0);
      p3 = new Point (0,0);
  }

  //Given the x, y coordinates of three points: (x1, y1), (x2, y2), and (x3, y3)   
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
       p1 = new Point(x1,y1);
      p2 = new Point (x2,y2);
      p3 = new Point (x3,y3);
  }
  
  //Given three Point objects: p1, p2, and p3
  public Triangle(Point p1, Point p2, Point p3) {
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
  }
  
  public Point GetP1(){
          return p1;}
public Point GetP2(){return p2;}

public Point GetP3(){return p3;}
  //Setters

public void SetP1(Point p1){
          this.p1 =p1;  
}
public void SetP2(Point p2){
    this.p2 = p2;
}

public void SetP3(Point p3){
  this.p3 =p3;
}
  //Calculate the perimeter of a triangle
  public double getPerimeter() {
      
     return p1.distance(p2)+p1.distance(p3)+p2.distance(p3);

  }

  //Calculate the area of a triangle  
  public double getArea() {
      double S = getPerimeter()/2;
            return Math.sqrt(S*(S-p1.distance(p2))*(S - p1.distance(p3))*
                    (S - p2.distance(p3))); 
     }

    
  public boolean contains(double x, double y) { 
     Point p = new Point(x,y);
     Triangle T = new Triangle(p1,p2,p3);
     Triangle T1 = new Triangle (p,p2,p3);
     Triangle T2 = new Triangle(p1,p,p3);
     Triangle T3 = new Triangle(p1,p2,p);
     
     if (error > Math.abs(T.getArea()-T1.getArea()-T2.getArea()-T3.getArea()) )
         return true;
     else
     {
         return false;
     }
         
  }
  

  //Return true if a triangle t is contained in this triangle
  public boolean contains(Triangle t) {    
    //If a triangle t is contained in this triangle, its three points must be contained in this triangle
     // Triangle A = new Triangle(this.p1,this.p2,this.p3);
      
        if (contains(t.p1.getX(),t.p1.getY())&&contains(t.p2.getX(),t.p2.getY())
                &&contains(t.p3.getX(),t.p3.getY()))
            return true;
            else {
            
            return false;
        }
	}
  
  //Return true if a triangle t overlaps with this triangle
  public boolean overlaps(Triangle t) {    
    //Two triangles overlap each other if one is inside the other (check if A.contains(B) or B.contains(A)) or 
	//a side in one triangle intersects a side in the other triangle (nine combinations)
Line A = new Line(this.p1.getX(),this.p1.getY(),this.p2.getX(),this.p2.getY());
Line B = new Line(this.p1.getX(),this.p1.getY(),this.p2.getX(),this.p2.getY());
Line C = new Line(this.p1.getX(),this.p1.getY(),this.p2.getX(),this.p2.getY());
Line A1 = new Line(t.p1.getX(),t.p1.getY(),t.p2.getX(),t.p2.getY());
Line B2 = new Line(t.p1.getX(),t.p1.getY(),t.p2.getX(),t.p2.getY());
Line C3 = new Line(t.p1.getX(),t.p1.getY(),t.p2.getX(),t.p2.getY());
return (this.contains(t) || A.intersectsLine(A1) || A.intersectsLine(B2) ||
        A.intersectsLine(C3) || B.intersectsLine(A1) || 
        B.intersectsLine(B2) || B.intersectsLine(C3) || C.intersectsLine(A1) ||
        C.intersectsLine(B2) || C.intersectsLine(C3));
  }

  //Print the three points of this triangle
  public void print()
  {
      System.out.println("Point1 is ( " + p1.getX()+","+ p1.getY()+")" + 
                         "Point2 is ( " + p2.getX()+ "," + p2.getY()+")"  +
                           "Point3 is ( " + p3.getX()+","+ p3.getY()+")" );
  }


//Line class
class Line {
	private Point p1, p2;
    final double error = 0.0001; //tolerance error when comparing two double precision numbers.
    
	//Constructor 
	Line(double x1, double y1, double x2, double y2)
	{  p1 = new Point(x1,y1);
           p2 = new Point(x2,y2);
        
	}
	
         public Point GetP1(){
          return p1;}
public Point GetP2(){return p2;}
	void print()
	{
		p1.print();
		p2.print();
	}
	
	//Return true if a point p is on this line
	boolean contains(double x, double y)
	{  Point Q = new Point(x,y);
        //if line p1q + line qp2 = p1p2 then return true
             if(p1.distance(p2)>= GetP1().distance(Q) + Q.distance(GetP2()))
                return true;
            else 
                return false;
        
	
        }
	
	//Return true if "this" line segment intersects "line" segment.
	boolean intersectsLine(Line line){
		double a =  (this.p1.getY() - this.p2.getY());
		double b = -(this.p1.getX() - this.p2.getX());
		double c =  (line.p1.getY() - line.p2.getY());
		double d = -(line.p1.getX() - line.p2.getX());
		double e = (this.p1.getY() - this.p2.getY()) * this.p1.getX() - (this.p1.getX() - this.p2.getX()) * this.p1.getY();
		double f = (line.p1.getY() - line.p2.getY()) * line.p1.getX() - (line.p1.getX() - line.p2.getX()) * line.p1.getY();

		double detA = a * d - b * c;
		
		if (detA == 0) {
		  //System.out.println("The two lines are parallel");
		  return false;
		}
		else // check the intersection point is on the both lines 
		{
		  double x = (e * d - b * f) / detA;
		  double y = (a * f - e * c) / detA;
		  //System.out.printf("The intersecting point is at (%.5f,  %.5f)\n", x, y);
		  
		  if (this.contains(x, y) && line.contains(x, y))
			  return true;
		  else
			  return false;
		}
	}
}
}

//Point class
class Point {
  private double x;
  private double y;

  //Constructor
  public Point(double x, double y) {
      this.x = x;
      this.y = y;
  }

  //Print the coordinates of a point
  void print()
  {
	  System.out.println("(" + x + ", " + y + ")");
  }

  //Calculate the distance between two points
  public double distance(Point secondPoint) {
    return distance(this, secondPoint);
  }

  //Calculate the distance between two points. This is a class method
    public static double distance(Point p1, Point p2) {
        double x2 = p2.getX();
        double x1 = p1.getX();
        double y2 = p2.getY();
        double y1 = p1.getY();
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2));


  }


  //Getters
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}


