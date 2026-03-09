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

public class InvertImage{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File imgFile = null;

    //read image
    try {
	  imgFile = new File("C:\Users\shaetavia\Documents\NetBeansProjects\ImageProc\sm_model.jpg");
      img = ImageIO.read(imgFile);
    } catch(IOException e){
      System.out.println(e);
    }

    //get width and height of the image
    int width = img.getWidth();
    int height = img.getHeight();

    //convert to an invert image
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int pixel = img.getRGB(x, y);

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

        img.setRGB(x, y, pixel);
      }
    }

    //write image
    try{
      imgFile = new File("sm_model.jpg");
      ImageIO.write(img, "jpg", imgFile);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}