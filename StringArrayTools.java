/** The class IntegerArrayTools implements a variety of basic array tasks
  * using an array of integers.
  * 
  * The array has a fixed length MAX_NUMS but the actual number of elements
  * that are used can vary.
  */

import java.util.Scanner;

public class StringArrayTools
{
  
  private String [] arrayData;
  private int arrayCount;
  public final int MAX_NUMS = 100;
  
  // ------------------ CONSTRUCTOR ----------------------------
  /** The contsructor merely creates the array.
    * It does not fill it with any data.  That is left up to 
    * the fillRandom or fillKeyboard methods.
    */
  public StringArrayTools ()
  {
    arrayData = new String [MAX_NUMS];
    arrayCount = 0;
  }
  
  /** Returns the number of objects in the array.
    * @return the count of items in the array. */
  public int getCount ()
  {
    return arrayCount;
  }
  
  // ------------------- METHODS TO FILL THE ARRAY -------------------------
  /** Adds an element to the end of the array. 
    * @param n The element to add
    * @return whether the element was successfully added
    */
  public boolean addItem (String n)
  {
    if (arrayCount < MAX_NUMS)
    {
      arrayData[arrayCount] = n;
      arrayCount++;
      return true;
    }
    else
      return false;
  }
  
    /** Fills the array nums with integers from 1 to n
    * @param n Upper bound for numbers with which to fill the array.
    * @param count the array to fill.  Returns a modified array.
    */
  /* public void fillRandom (int n, int count)
  {
    if (count > MAX_NUMS)       // check that it's not too many items
      count = MAX_NUMS;
    for (int i = 0; i < count; i++)
      addItem((int)(Math.random() * n) + 1);
  }
  */
  
  /** Fills the array with integers entered by the user
    * @param nums the array to fill.  Returns a modified array.
    */
  public void fillKeyboard ()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Please enter Strings on one line, separated by spaces.");
    System.out.println ("Use enter to signal the end of the list.");
    
    arrayCount = 0;
    String n = keyboard.nextLine();
    while (n.length() != 0)                 // stop input when user enters -1
    {
      addItem(n);
      n = keyboard.nextLine();
    }
    keyboard.close();
  }
  
  // -------------------- METHODS TO WORK WITH THE ARRAY --------------------------
  /** Prints the array, spaces between numbers.
    */
  
  public void printArray ()
  {
    sort();
    for (int i = 0; i < arrayCount; i++)
      System.out.print (arrayData[i] + "  ");
    System.out.println();
  }
  
  /** Find the maximum String value in an array
    * @return string with the greatest value
    */
  public String getMax ()
  {
    String maximum = arrayData[0];
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(maximum) > 0)
      {
        maximum = arrayData[i];
      }
    }
    return maximum;
  }
   /** Find the index of the maximum String value in an array
    * @return integer of the string with the greatest value
    */ 
  public int getMaxIndex ()
  {
    String maximum = arrayData[0];
    int index = 0;
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(maximum) > 0)
      {
        index = i;
      }
    }
    return index;
  }
  /** Find the minimum String value in an array
    * @return string with the smallest value
    */
   public String getMin ()
  {
    String minimum = arrayData[0];
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(minimum) < 0)
      {
        minimum = arrayData[i];
      }
    }
    return minimum;
  }
  /** Find the index of the minimum String value in an array
    * @return integer of the string with the smallest value
    */ 
  public int getMinIndex ()
  {
    String minimum = arrayData[0];
    int index = 0;
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(minimum) < 0)
      {
        index = i;
      }
    }
    return index;
  }
  /** Find the index of the minimum String value in an array, beginning at a given element
    * @param integer of the element of the array to start finding the minimum from
    * @return integer of the string with the smallest value within the element given and the final element
    */ 
  public int getMinIndex (int start)//Can have same name as getMinIndex above, because it is different, as it takes parameters
  {
    String minimum = arrayData[start];
    int index = start;
    for (int i = 1; i < arrayCount; i++)
    {
      if (arrayData[i].compareTo(minimum) < 0)
      {
        index = i;
      }
    }
    return index;
  }
  /** Sorts the elements of an array of strings from least to greatest
    * @return sorted string array, with elements sorted from least to greatest
    */ 
  public String [] sort ()
  {
    int position = 0;
    while (position < arrayCount - 1)
    {
      int min = getMinIndex(position);
      String temp = arrayData[min];
      arrayData[min] = arrayData[position];
      arrayData[position] = temp;
      position++;
    }
    return arrayData;
  }
  
  /** Tests the various array tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    //myArray.fillRandom(100, 12);
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.println ("There are " + myArray.getCount() + " integers in the array.");
    
    // Un-comment these lines one at a time after you have written the appropriate code
    System.out.println ("The largest item is " + myArray.getMax() ); 
    System.out.println ("The largest item is at index " + myArray.getMaxIndex());

    System.out.println ("The smallest item is " + myArray.getMin() );
    System.out.println ("The smallest item is at index " + myArray.getMinIndex());
    myArray.printArray();
    
  }
}