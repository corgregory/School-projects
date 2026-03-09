/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author shaetavia
 */
public class ImageProc{
  public static void main(String args[])throws IOException{
	  
	//The user enters input, output image files and the type of operation through command line arguments
	if(args.length == 0){
		System.out.println("Missing input, output file names and the type of operation");		
	} 
	
	String inputFile = args[0];
	String outputFile = args[1];
	String op = args[2];

	System.out.println("Input image file: " + inputFile);
	System.out.println("Output image file: " + outputFile);
	System.out.println("What operation do you want to perform: " + op);
	
	//Extract pixel values from a real image file and return to a 2D integer array
	int [][] arr = extract(inputFile);

	//Create an Image object
	Image image = new Image(arr, arr.length, arr[0].length);
	
	//Operation menu
	switch(op)
	{
		case "grayscale":
			image.grayScale();
			break;
 		case "invert":
			image.invertImage();
			break;
		case "add_bars":
			image.addBars();
			break;
		case "blur":
			image.blur();
			break;
		case "emboss":
			image.emboss();
			break;	 	
	}
	
	//Get pixel values (a 2D array of integers) from the Image object
	arr = image.getPixels();
	
	//Create a real output image file with pixel values from the Image object 
	write(arr, outputFile);
	
	System.out.println("Image Processing is complete!");
  }
  
  void extract(Image m){
      
  }
}

class Image{
    private int row;
    private int col;
    private Pixel [][] pixels;
    
    Image(int r, int c, Pixel array[][]){
        row = r;
        col = c;
        pixels = array;
        
    }
    
    void addBars(Image img){
         for(int y = 0; y < col; y++){
      for(int x = 0; x < row; x++){
        int pixel = img.getRGB(x, y, pixels);

		//extract color values
        int a = (pixel >> 24) & 0xff;
        int r = (pixel >> 16) & 0xff;
        int g = (pixel >> 8) & 0xff;
        int b = pixel & 0xff;

        // use the modulos arithmitic to eventually place bars
       if(x%(row/6)==0 || y%(col/6)==0){
           r = 0;
           g = 0;
           b = 0;
       }

        //set new RGB values
        pixel = (a << 24) | ( r << 16) | ( b << 8) | b;

        img.setRGB(x, y, pixels);
    }
         }
    }
   void grayScale(Image m){
         for(int y = 0; y < col; y++){
      for(int x = 0; x < row; x++){
        int pixel = m.getRGB(x, y, pixels);

		//extract color values
        int a = (pixel >> 24) & 0xff;
        int r = (pixel >> 16) & 0xff;
        int g = (pixel >> 8) & 0xff;
        int b = pixel & 0xff;

        // declare a variable to hold the average of the rgb values
        int avg = (r + g + b)/3;

        //set new RGB values
        pixel = (a << 24) | ( avg << 16) | ( avg << 8) | avg;

        m.setRGB(x, y, pixels);
      }
    }
    }
    
   void invertImage(Image img){
     for(int y = 0; y < col; y++){
      for(int x = 0; x < row; x++){
        int pixel = img.getRGB(x, y, pixels);

		//extract color values
        int a = (pixel >> 24) & 0xff;
        int r = (pixel >> 16) & 0xff;
        int g = (pixel >> 8) & 0xff;
        int b = pixel & 0xff;

        // change color values for an invert image
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;

        //set new RGB values
        pixel = (a << 24) | ( r << 16) | ( g << 8) | b;

        img.setRGB(x, y, pixels);
      }
   }
   }
}
   
  class Pixel // Declare  Class Pixel
{       
    //this class has data members
        private int value;
	private int rol;
	private int col;
	private Image img ;
        
        
        // Copy.constructor
	Pixel(int v, int r, int c, Image m){
            value = v;
            rol = r;
            col = c;
            img = m;
         
             
        }
        void print(){
           System.out.println("%4d" + value);
            
            }
        // this gets value from any index in the array
	int getValue(){
            return value;
        }
        // set vlues will set a value into the array
	void setValue(int a){
            value = a;
        }
  }
  
        
         
             
 
    
    
        
    
      
