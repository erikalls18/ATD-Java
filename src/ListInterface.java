

/** An interface for the ADT list.
 * The position in list begins from 1*/	

public interface ListInterface<T> {
	
	/** Adds a new entry to the end of this list.
	 * The list's length is increased by 1.
	 * @param newEntry is  the object to be added to the list. */
	
	public void add( T newEntry);
	
	/** Adds a new entry at a specified position within this list.
	 * Entries are moved one position  forward  and the list's length  is increased by 1.
	 * @param position is an  integer that specifies the desired the position for new entry 
	 * @param newEntry  is added to  the list
	 * @return an string indicating if the new entry was added successfully.
	 * Handle the error in case the user introduces a wrong entry*/
	
	public String add( int position,  T newEntry);
	
	/** Removes the entry at a given position from this list.
	 * Entries are moved a backward and and the list's length is decreased by 1.
	 * @param givenPosition is an integer that defines  the position of  the entry to be removed.
	 * @return a reference to the removed entry.
	 * Handle the error in case of introducing  a wrong entry*/
	public T remove( int givenPosition);
	
	/** Removes all entries from this list. */
	public void clear();
	
	/** Replaces the entry at a specific position in this list.
	 * @param givenPosition is an integer that indicates the position of the entry to be replaced.
	 * @param newEntry is the  object that will replace the entry at the position givenPosition.
	 * @throw  an exception if IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength(). */
	
	public void replace(int givenPosition, T newEntry);
	
	/**Retrieves the object in an specific position of the list
	 * @param givenPosition is an integer that indicate the position  of the object to be retrieved
	 * @return the object  specified by the entry
	 * @throw  an exception if IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength().*/
	public T getEntry(int givenPosition);
	
	
	/**Search for specific entry in  the list.
	 * @param anEntry is an integer of the desired entry .
	 * @return True if the list contains anEntry, or false if not.*/
	public boolean contains(int anEntry);
	
	/**Search for specific entry in  the list.
	 * @param anEntry is an string of the desired entry .
	 * @return True if the list contains anEntry, or false if not.*/
	public boolean contains(String anEntry);
	
	/**Get the length of the list
	 * @return the number of items in the list*
	 * If there are not items in the list returns 0*/
	public int getLength();
	
	
	/** Evaluate if the list is empty.
	 * @return true if the list is empty, or false if not. */
	public boolean isEmpty();
	
	/** Retrieves all entries  in the list following the order in which items were added. */
	
	public void toArray();
	
	/**Sorts the list with the algorithm Merge Sort.
	@param newEntry is an array that contains items that will  be sorted
	@return  sorter array . */
	
	public Employee[] mergeSort( Employee [] newEntry);
	
	/** Sorts the list with the algorithm Shell Sort .\
	 * @param newEntry is an array that contains items that will  be sorted
	 * @return  sorted array . */
	
	public Employee[] shellSort( Employee [] newEntry);
	
	/** Retrieves all entries of the sorted array .
	 * @param newEntry is a list that contains items that will  be retrieve */

	public void printArraySorted(Employee [] newEntry);	
}
