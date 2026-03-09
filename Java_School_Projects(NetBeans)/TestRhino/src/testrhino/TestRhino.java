/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrhino;
import java.util.Scanner;
/**
 *
 * @author shaetavia
 */
public class TestRhino {
    static int numCorrectAns = 0;

	public static void check(String question, boolean studentAns, boolean correctAns)
	{
		System.out.println(question + ": " + (studentAns == correctAns? "Passed": "Failed"));
		if(studentAns == correctAns)
			numCorrectAns++;
	}

	public static void main(String args[])
	{
		Rhino kibibbi = new Rhino("Kibibbi", 1939, 1, 'F');
		Rhino jimma = new Rhino("Jimma", 1935, 2, 'M');
		Rhino ikenna = new Rhino("Ikenna", 1999, 11, 'F');
		ikenna.addFather(jimma);
		Rhino bubba = new Rhino("Bubba", 1960, 11, 'M', 52, kibibbi, jimma);
		Rhino juba = new Rhino("Juba", 1950, 5, 'M');
		juba.addMother(kibibbi);
		juba.setTag(10);
		Rhino kojo = new Rhino("Kojo", 1994, 8, 'M', 1234, ikenna, juba);
		Rhino sefu = new Rhino("Sefu", 1994, 12, 'F');
		sefu.addFather(bubba);

		juba.print();
		kibibbi.print();
		bubba.print();

		System.out.println();
		check(  "kibbibi.isMotherOf(juba)? " , kibibbi.isMotherOf(juba), true);
		check(  "kibbibi.isMotherOf(ikenna)? " , kibibbi.isMotherOf(ikenna), false);
		check(  "juba.isFatherOf(kojo)? " , juba.isFatherOf(kojo), true);
		check(  "juba.isFatherOf(ikenna)? " , juba.isFatherOf(ikenna), false);
		check(  "kibbibi.isParentOf(juba)? " , kibibbi.isParentOf(juba), true);
		check(  "kibbibi.isParentOf(ikenna)? " , kibibbi.isParentOf(ikenna), false);
		check(  "ikenna.isSisterOf(bubba)? " , ikenna.isSisterOf(bubba), true);
		check(  "ikenna.isSisterOf(juba)? " , ikenna.isSisterOf(juba), false);
		check(  "sefu.isYounger(kojo)? " , sefu.isYounger(kojo), true);
		check(  "juba.isYounger(kojo)? " , juba.isYounger(kojo), false);

		System.out.println( "The number of correct answers is " + numCorrectAns );
	}
}

/*
//Sample output from the test program above

>javac TestRhino.java
>java TestRhino

Male rhino Juba. Born 5/1950. Tag 10. Mother Kibibbi. Children 1.
Female rhino Kibibbi. Born 1/1939. Children 2.
Male rhino Bubba. Born 11/1960. Tag 52. Mother Kibibbi. Father Jimma. Children 1.

kibbibi.isMotherOf(juba)? : Passed
kibbibi.isMotherOf(ikenna)? : Passed
juba.isFatherOf(kojo)? : Passed
juba.isFatherOf(ikenna)? : Passed
kibbibi.isParentOf(juba)? : Passed
kibbibi.isParentOf(ikenna)? : Passed
ikenna.isSisterOf(bubba)? : Passed
ikenna.isSisterOf(juba)? : Passed
sefu.isYounger(kojo)? : Passed
juba.isYounger(kojo)? : Passed
The number of correct answers is 10

*/
    
}


// Declare The Rhino class and private variables
class Rhino{
    private String nickname;
    private int year;
    private int month;
    private char gender;
    private int tag;
    private Rhino mother;
    private Rhino father;
    private int numOfChildren;
    
    
    // the default constructor 
    Rhino(String n, int y, int m, char g){
        
       nickname = n;
        year = y;
        month = m;
        gender = g;
        
        tag = -1;
        mother = null;
        father = null;
        numOfChildren = 0;
        
    }
    // the parameterized constructor will initalize all the variables
    Rhino(String n, int y, int m, char g, int t, Rhino mom, Rhino dad){
        nickname = n;
        year = y;
        month = m;
        gender = g;
        tag = t;
        mother = mom;
        father = dad;
        numOfChildren = 0;
        mom.numOfChildren++;
        dad.numOfChildren++;
        
    }
    
    // the add mother function assigns a mother rhino to the object
public void addMother(Rhino mom){
    
    mother = mom;
    mom.numOfChildren++;
}
// the add mother function assigns a father rhino to the object
public void addFather(Rhino dad){
    father = dad;
    dad.numOfChildren++;
}
// this function gets the name of the object
public String getName(){
    return nickname;
    
}

// this getYear function will return the birth year of the object
public int getYear(){
    return year;
}
// this getMonth function will return the birth month of the object
public int getMonth(){
    return month;
}
//the getGender function returns the gender of the object
public char getGender(){
    return gender;
}
// this function checks if the object is a male
public boolean isMale(){
    return (gender=='M');
}
// this function returns the mother of the object
public Rhino getMother(){
    return mother;
}
// this function returns the father of the object
public Rhino getFather(){
    return father;
}

// this function returns the number of childeren of a parent rhino
public int getNumChildren(){
    return numOfChildren;
}

// this function gets the tag number of the object
public int getTag(){
    return tag;
}
public void setTag(int n){
    tag = n;
        
}
// the isYounger function compares to objects of class rhino's year and birth 
//month if neccessary, to check which object  is younger
public boolean isYounger(Rhino f){
    return (f != null && this.getYear() > f.getYear()|| 
            (this.getYear() == f.getYear()&& this.getMonth() > f.getMonth()));
   
}
// this function checks the parents of two objects to see if the objects 
//have a parent in common
public boolean isSisterOf(Rhino e){
    return (e != null && this != e &&  ! this.isMale() && this.getMother()== 
            e.getMother() || this.getFather()== e.getFather());
}

// this function checks the mother of the object
public boolean isMotherOf(Rhino e){
    
    return (e != null && this == e.getMother());
}
// this function checks the father of the object 
public boolean isFatherOf(Rhino e){
    return (e != null && this == e.getFather());
}
// this function checks the parent of the object 
public boolean isParentOf(Rhino e){
  return (e != null && (this == e.getMother() || this == e.getFather()));
}
// this print function prints out the info about an object of class Rhino.
public void print(){
    
    System.out.println(((isMale())? ("Male"):("Female" ))+ " Rhino " + getName() + 
          ". Born " + getMonth()+ "/" + getYear()+ ". Tag " + getTag() + 
          ". Mother is " + mother + " Number of Children is " +
            numOfChildren);
    
    
}
}
