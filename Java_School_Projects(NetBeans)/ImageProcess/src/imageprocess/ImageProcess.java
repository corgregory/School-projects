/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocess;

/**
 *
 * @author shaetavia
 */
public class ImageProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
	//Input pixel values to a temporary 2D array
	int [][] b = new int [][]{
		{221, 184, 178, 84, 135},
		{84, 255, 255, 130, 84},
		{78, 255, 0, 0, 78},
		{84, 130, 255, 130, 84}
	};


	GrayImage gimg = new GrayImage(b, 4, 5);
	gimg.print();
	System.out.println("\nThe number of white pixels is " + gimg.countWhitePixels());
	gimg.processImage();
	gimg.print();
	
}
        
        
    }
class Pixel // Declare  Class Pixel
{       
    //this class has data members
        private int value;
	private int rol;
	private int col;
	private GrayImage img ;
        
        
        // Copy.constructor
	Pixel(int v, int r, int c, GrayImage m){
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

    
 class GrayImage{  // declare gray image class
	private int rows;
	private int cols;
        private Pixel[][] PixArray;
       
        // this double loop will construct a gray image object from a 2D array implementation
	GrayImage(int array [][], int r, int c){
            rows = array.length;
            cols = array[0].length;
            PixArray = new Pixel[rows][cols];
	for (int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
             PixArray[i][j] = new Pixel(array[i][j], i , j , this);
            } 
        }
        }
        // a double loop will step through the array.  
        //a counter variable will keep ount of white pixels
	int countWhitePixels(){
             int whitePixelCounter = 0;
	for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
             if(PixArray[i][j].getValue()== 255){
                 whitePixelCounter++;
              
             }
            }
           }
        return whitePixelCounter;
        }
        void print(){
           System.out.println("The values are ");
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    System.out.print(PixArray[i][j].getValue() + " ");
                }
                System.out.println();
            }
       
            
            }
        
      
        
        // this method processes the images and makes sure values are set appropiately 
        void processImage() {
            int x;
            for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
               if(i <2 && j <3){
               x = PixArray[i][j].getValue()- PixArray[i+2][j+2].getValue();
              
              if (x < 0){
                  PixArray[i][j].setValue(0);
              }
             else if ( x > 255){
                         x = 255;
                    } 
                
            
               }
            }
            }
        }
        
 }
     
          