package cse360assign2;


/**@author Saul James Castro, sjcastr1@asu.edu
 * @author Class ID: 234
 * @version Assignment 2 
 * This file contains the class SimpleList.java. This class has 9 public methods: an add method,
 * a remove method, a count method, a toString method, an append method, a first method,
 * a last method, a size method and a search method.  The tenth method is a 
 * private method that is a helper method used in the resizing of the lists.**/

/**This class is called SimpleList. It is a public class that contains 9 public methods.
 * SimpleList allows the user to input integer values, remove values, search for 
 * values, print a string of the values, and keep track of the amount of values 
 * that are in the list by use of a count variable. */

public class SimpleList 
{
	
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
	 *  If the list was full then the list size is increased by 50%. 
	 * @param valueToAdd is the value that is to be added to the list*/
	
	public void add(int valueToAdd)
	{
		if(list.length == count)
		{
			int lengthNew = (int) Math.floor(count*1.5);
			int[] tempList = new int[lengthNew];
			this.arrayCopy(list, tempList);
			list = tempList;
		}
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
			for(int index = count; index > 0; index --)
			{
				list[index] = list[index - 1];
				
			}
			
			list[0] = valueToAdd;
			
			count = count + 1;
			
		}
		
	}

	/**This is the remove method. The remove method will take in a value that is to be removed 
	 * from the list. This method will utilize the search method to find the first appearances of the 
	 * given value and remove it from the list. Decrementing the count appropriately.
	 * If the value that is to be removed is not in the list then the list will remain unchanged.
	 * If the list has more than 25% empty spaces then the size of the list is reduced by 25%.
	 * @param valueToRemove is the value that is to be removed. */
	
	public void remove(int valueToRemove)
	{
		int searchValue = search(valueToRemove);
		
		if(searchValue != -1 && count > 1)
		{
			for(int index = searchValue; index < count - 1; index ++)
			{
				list[index] = list[index + 1];	
			}
			
			count = count - 1;
			
		}
		
		if(size() > 0)
		{
			double calcVal = (double)(size()-count)/size()*100;
			int newValue = (int) calcVal;
			
			if(newValue >= 25)
			{
				calcVal = (double) 0.75*size();
				newValue = (int) calcVal;
				int[] tempList = new int[newValue];
				this.arrayCopy(list, tempList);
				list = tempList;
			}
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
	
	/**This is the append method. The append method is similar to the add method in 
	 * that we will be making the list bigger. However append will place the values at 
	 * the end of the list. If the list is already full then the size of the list
	 * will be increased by 50%. 
	 * @param valueToAppend are the values that we want to append to the list **/
	
	public void append(int valueToAppend)
	{
		if(list.length == count)
		{
			int lengthNew = (int) Math.floor(count*1.5);
			int[] tempList = new int[lengthNew];
			this.arrayCopy(list, tempList);
			list = tempList;
		}
		
		list[count] = valueToAppend;
		count = count + 1;
	}
	
	/**This is the first method. The first method gets the first value of the list.
	 * If the list is empty the returned value is -1.**/
	
	public int first()
	{
		int valueToReturn;
		if(count == 0)
		{
			 valueToReturn = -1;
		}
		else
		{
			valueToReturn = list[0];
		}
		return valueToReturn;
	}
	
	/**This is the last method. The last method gets the last value in the list. If the 
	 * list is empty the returned value is -1.  **/
	
	public int last()
	{
		int valueToReturn;
		if(count == 0)
		{
			valueToReturn = -1;
		}
		else
		{
			valueToReturn = list[count - 1];
		}
		
		return valueToReturn;
	}
	
	/**This is the size method. It returns the length or size of list. **/
	
	public int size()
	{
		return list.length;
	}
	
	/**This is a method that aids in the resizing of the list by copying the values
	 * of the old list into a new list. This is a helper method that I added to make the 
	 * the code easier to follow. 
	 * @param arrayOne is the array we are copying into arrayTwo the newly sized array.
	 * @param arrayTwo is the new array that has been resized**/
	
	private void arrayCopy(int[] arrayOne, int[] arrayTwo)
	{
		
		for(int index = 0; index < count; index++)
		{
			arrayTwo[index] = arrayOne[index];
		}
		
	}
	
}