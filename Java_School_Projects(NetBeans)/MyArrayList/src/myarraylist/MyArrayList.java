/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shaetavia
 */
public class MyArrayList {
	public static void main(String[] args) {
		int [] a = {23, 5, 3, 7, 5, 6, 4, 25, 2, 2, 5, 2, 4};
		ArrayList list = new ArrayList<>();
		
		for (int i = 0; i < a.length; i++)
		{
			Integer n = new Integer(a[i]);
			list.add(n);
		}
		
		System.out.println("The max integer in the list is : " + findMax(list));
				
		System.out.println("The integers with duplicates are : ");
		print(list);
		removeDuplicates(list);
		System.out.println("\nThe integers after removing duplicates are : ");
		print(list);		
		
		int [] b = {8, 5, 9, 7, 6};
		ArrayList list2 = new ArrayList<>();
		
		for (int i = 0; i < b.length; i++)
		{
			Integer n = new Integer(b[i]);
			list2.add(n);
		}
		
		System.out.println("\n\nThe integers before union are : ");
		print(list);
		System.out.println("\n");
		print(list2);		
		union(list, list2);
		System.out.println("\nThe integers after union are : ");
		print(list);		
	}

	public static int findMax(ArrayList list)
	{	
		int max = ((Integer)list.get(0)).intValue();
		
		for (int i = 0; i < list.size(); i++){
				Integer n = (Integer) list.get(i);
					if ( n.intValue() > max )
						max = n.intValue();
		}
		
		return max;
	}
	
	//This method takes an array list object as input and remove the duplicates in it
	//The items in the array are objects of Integer type (Java APIs). Use the methods defined for class Integer
	public static void removeDuplicates(ArrayList list)
	{	
		//Using brute force method would be fine
		//To be completed
              //Using brute force method would be fine
		//To be completed
		for (int i = 0; i < list.size(); i++)
		{ 
			Integer n = (Integer) list.get(i);
			for(int j = i + 1; j < list.size(); j++)
			{
				Integer m = (Integer) list.get(j);
				if (n.intValue() == m.intValue() )
					list.remove(list.get(j));
			}
	    }
	}
                   
	
	//This method takes two array lists as input. The resultant list after union is store into the first list.
	public static void union(ArrayList list1, ArrayList list2)
	{
		for (int i = 0; i < list1.size(); i++)
		{
			Integer a = (Integer) list1.get(i);
			for(int j = 0; j < list2.size(); j++)
			{
                            Integer b = (Integer) list2.get(j);
                            if (a.intValue() == b.intValue())
                        {
                            list2.remove(j);
                    }
		}
	    }
		
		for(int i = 0; i < list2.size(); i++)
		{
			Integer tmp = (Integer) list2.get(i);
			list1.add(tmp);
                }
	}
	
	//This method prints items stored in an arrayList object.
	public static void print(ArrayList lst)
	{
		for (int i = 0; i < lst.size(); i++){
					System.out.print(((Integer)lst.get(i)).intValue() + ", ");
		}
	}
}