/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testanimal;

/**
 *
 * @author shaetavia
 */
public class TestAnimal {
	public static void main(String []args)
	{
	   Animal d1 = new Dog(50.2, 101, "German Shepherd");
	   Dog d2 = new Dog(40.5, 102, "Lab");	 
	   Animal b1 = new Bird(0.35, 103, "Blue");
	   Flyable b2 = new Bird(0.55, 104, "Red");
	   
	   if (d1 instanceof Dog)
			((Dog)d1).speak();
	   
	   b1.speak();
	   b2.fly();
	   
	   try{		   
			Dog d3 = (Dog)d2.clone();
			Bird b3 = (Bird)((Bird)b1).clone();
			d3.speak();
			b3.speak();
			b3.fly();
	   } catch (Exception e){
		   e.printStackTrace();
	   }

	   System.out.println(d2.compareTo(d1));
	   System.out.println(((Bird)b2).compareTo(b1));
	}
}

abstract class Animal
{
	protected double weight;
	protected int tag;
	
	
    public abstract void speak();
}

class Dog extends Animal implements Comparable<Animal>, Cloneable
{
	private String breed;
	//private java.util.Date whenBuilt;
	
	public Dog(double weight, int tag, String breed)
	{
		this.weight = weight;
		this.tag = tag;
		this.breed = breed;
		//whenBuilt = new java.util.Date();
	}
	//Implement a compareTo method that returns 1 if the caller object weighs more than the object as parameter;
	//returns 0 if they weigh equally; returns -1 if the caller object weighs less than the object as parameter
	public int compareTo(Animal a)
	{
		if(weight > a.weight)
			return 1;
		else if(weight<a.weight)
			return -1;
		else 
			return 0;
		
	
	}
	
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	@Override
	public void speak() {
		System.out.println(breed+ " dog with a tag of " + tag + " woof!");		
	}
	
}

class Bird extends Animal implements Flyable, Comparable<Animal>, Cloneable
{
	private String color;
	
	public Bird(double weight, int tag, String color)
	{
		this.weight = weight;
		this.tag = tag;
		this.color = color;
	}
	
	public void fly() {
		System.out.println(color + " bird with a tag of " + tag + " is flying!");
	}
	@Override 
	public void speak()
	{
		System.out.println(color + " bird with a tag of " + tag + " tweet!");
	}

	@Override
	public int compareTo(Animal a) {
		if(weight > a.weight)
			return 1;
		else if(weight<a.weight)
			return -1;
		else 
			return 0;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

}