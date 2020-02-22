package cse360assign2;


/**@author Saul James Castro, sjcastr1@asu.edu
 * @author Class ID: 234
 * @version Assignment 1 
 * This file contains the class SimpleList.java. This class has 5 methods: an add method,
 * a remove method, a count method, a toString method, and a search method. **/

/**This class is called SimpleList. It is a public class that contains 5 methods.
 * SimpleList allows the user to input integer values, remove values, search for 
 * values, print a string of the values, and keep track of the amount of values 
 * that are in the list by use of a count variable. */

public class SimpleList 
{
	public static void main(String args[])
	{
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(5);
		testList.add(3);
		testList.add(2);
		testList.add(9);
		testList.add(6);
		testList.add(2);
		testList.add(3);
		testList.add(5);
		testList.add(7);
		testList.add(12);
		
		System.out.println(testList.toString());
		testList.remove(2);
		
		System.out.println(testList.toString());
		System.out.print("The value of count: " + testList.count());
	
	}
	
	
	private int[] list;
	private int count;
	
	/**This is the constructor for the SimpleList class. This constructor creates an
	 * integer array of size 10 and initializes count to 0. */
	
	public SimpleList() 
	{
		list = new int[10];
		count = 0;
	}
	
	/**This method is called add. This method will add an integer to the list. The values
	 * will be added to the front of the list. Duplicates entries are allowed and if a value
	 *  is added to a full list the last value will "fall off". Note that if the count is
	 *  already 10, i.e. the list is full, and a value is added count will not be incremented. 
	 * @param valueToAdd is the value that is to be added to the list*/
	
	public void add(int valueToAdd)
	{
		if(count == 0)
		{
			list[0] = valueToAdd;
			count = count + 1;	
		}
		else if(count == 1)
		{
			list[1] = list[0];
			list[0] = valueToAdd;
			count = count + 1;
		}
		else
		{
			for(int index = count - 1; index > 0; index --)
			{
				list[index] = list[index - 1];
			}
			
			list[0] = valueToAdd;
			
			if(count < 10)
			{
				count = count + 1;
			}
			
		}
		
	}

	/**This is the remove method. The remove method will take in a value that is to be removed 
	 * from the list. This method will utilize the search method to find all appearances of the 
	 * given value and remove all of the from the list. Decrementing the count appropriately.
	 * If the value that is to be removed is not in the list then the list will remain unchanged.
	 * @param valueToRemove is the value that is to be removed. */
	
	public void remove(int valueToRemove)
	{
		int searchValue = search(valueToRemove);
		
		if(searchValue != -1)
		{
			for(int index = searchValue; index < count - 1; index ++)
			{
				list[index] = list[index + 1];	
			}
			
			count = count - 1;
			
		}
		
	}
	
	/**This is the count method. This method will return and integer which is the amount 
	 * of values that are in the list. 
	 * @return count the amount of values in the list */
	
	public int count()
	{
		return count;
	
	}
	
	/**This is the toString method. This method will return the list as a string with a space 
	 * in between each value and no space after the final value. 
	 * @return listToString is a string that displays the values of the list*/
	
	public String toString()
	{
		String listToString = "";
		int index;
		
		if(count == 0)
		{
			listToString = "";
		}
		else
		{
			for(index = 0; index < count - 1; index ++)
			{
				listToString += list[index] + " ";	
			}
			listToString += list[count - 1];
		}
		
		return listToString;
		
	}
	
	/**This is the search method. The search method will take in a value that is to be found
	 * and then return that value's index within the list. If there is multiple appearances of the value
	 * this method will only find the first appearance of the value. If the value is not in the list
	 * then search will return -1, as instructed. 
	 * @param valueToSearchFor is the value that we are searching for in the list
	 * @return elementIndex is the index of the value that was searched for*/
	
	public int search(int valueToSearchFor)
	{
		int index = 0;
		int elementIndex = -1;
		boolean found = false;
		
		while(index < count && !found)
		{
			if(list[index] == valueToSearchFor)
			{
				elementIndex = index;
				found = true;
			
			}
			else
			{
				index = index + 1;
			}
			
		}
		
		return elementIndex;
		
	}
	
}