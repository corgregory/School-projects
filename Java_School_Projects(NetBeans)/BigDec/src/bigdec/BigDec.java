/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdec;

  
/**
 *
 * @author shaetavia
 */
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
public class BigDec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MathContext mc = new MathContext(60, RoundingMode.DOWN);
            int a = 1;
            float r = (float)(1/2.0);
            int n = 150;
        
        BigDecimal steps = new BigDecimal(geoSeries(a,r,n), mc);
        
        System.out.println("The aliean goes for " + steps +" miles during walk.");
    }
    

static float geoSeries(float a, float r, float n){

float sum = 0;
for(int i = 0; i < n; i++)
{
sum = sum +a; 
a = a*r;
}
return sum;

}
}
