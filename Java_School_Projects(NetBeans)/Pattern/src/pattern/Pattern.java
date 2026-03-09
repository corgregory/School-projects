/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern;

/**
 *
 * @author shaetavia
 */

import java.util.Scanner;
public class Pattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner input = new Scanner(System.in);
		System.out.println("Enter the height and width of a rectangle: ");
		int height = input.nextInt();         //The height of the rectangle
		int width = input.nextInt();          //The width of the rectangle
		
		System.out.println("Enter the row and column indice for a point through which two 45 degree diagonals pass: ");
		int r = input.nextInt();          //The row index
		int c = input.nextInt();         //The column index
		
		int rows = height + 1;				  //The number of rows of the rectangle
		int cols = width + 1;				  //The number of columns of the rectangle
		int [][] a = new int[rows][cols];	  //Create a 2D array with size of rows by cols
		
		System.out.println("\nA rectangle with 0's in the upper triangle and 1's in the lower triangle:");
		createRectangle(a);
		print(a);
		
		System.out.println("\nTwo 45 degree diagonals pass through a point (" + r + ", " + c + "):");		
		createTwoDiagonals(a, r, c);
		print(a);
		
		System.out.println("\nA rectangle with a half-sized rectangular hole:");	
		createRectangularHole(a);
		print(a);
		
		System.out.println("\nA rectangle with a circular hole:");			
		createCircularHole(a);
		print(a);
		
		/*System.out.println("\nA rectangle with a sin curve:");			
		createSinCurve(a);
		print(a);*/ 
    }
     public static void createCircularHole(int [][] p)
	{
		int rows = p.length;
		int cols = p[0].length;
		int h = rows - 1;
		int w = cols - 1;
                int r = 1/4 * Math.max(h,w);
		
		for (int i = 0; i < rows; i++){
                    for (int j = 0; j < cols; j++){
			if(Math.pow(j-(w/2),2)+ Math.pow(i-(h/2),2) <= Math.pow(r,2))
                 // I can't seem to solve this issue my output just prints a single one in the middle
					p[i][j] = 1;
				else
					p[i][j] = 0;	
			}	
		}
	}
    public static void createRectangularHole(int [][] p)
	{
		int rows = p.length;
		int cols = p[0].length;
		int h = rows - 1;
		int w = cols - 1;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if((i > h/4)&&(i < 3* h/4)&&(j > w/4) && (j< 3* w/4))
					p[i][j] = 1;
				else
					p[i][j] = 0;	
			}
                        
		}
	}
    public static void createRectangle(int [][] p)
	{
		int rows = p.length;
		int cols = p[0].length;
		int h = rows - 1;
		int w = cols - 1;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if(w*i + h*j > h*w )
					p[i][j] = 1;
				else
					p[i][j] = 0;	
			}	
		}
	}
     public static void createTwoDiagonals(int [][]p,int r, int c)
	{
		
		for (int i = 0; i < p.length; i++){
			for (int j = 0; j < p[0].length; j++){
			if(i == -j + r + c)
					p[i][j] = 1;
                       
                        else if (i == j+ r - c)
					p[i][j] = 1 ;
                                
                        else p[i][j] = 0;
                        }
                }
        }
                        
				
		
	
    public static void print(int [][] p)
	{
		int rows = p.length;
		int cols = p[0].length;
		int h = rows - 1;
		int w = cols - 1;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
                            System.out.print(p[i][j]);
				
			}
                 System.out.println();       
		}
	} 
}


