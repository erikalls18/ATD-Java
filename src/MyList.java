
/**Class that  implements the interface ListInterface*/

public class MyList<T> implements ListInterface <T>{

	private final int maxlenght = 50; 
	T[] list;
	int length;
	//private Object Employee; 
	

	public MyList() {
		
		list = (T[])new Object[maxlenght +1] ;
	}

	/** Adds a new entry to the end of this list.
	 * The list's length is increased by 1.
	 * @param newEntry is  the object to be added to the list. */
	@Override
	public void add(T newEntry) {
		
			if(getLength() < maxlenght) {
				list[getLength()+1] = newEntry;
				length++;
			}
	}
	
	/** Adds a new entry at a specified position within this list.
	 * Entries are moved one position forward  and the list's length  is increased by 1.
	 * @param position is an  integer that specifies the desired the position for new entry 
	 * @param newEntry is added to  the list
	 * @return an string indicating if the new entry was added successfully.
	 * Handle the error in case the user introduces a wrong entry*/

	@Override
	public String add(int position, T newEntry) {
		T temp1;
		T temp2;   		
		if (position >0 && position  <= getLength()+1) {  
			if (list[position]== null) {
				list[position]= newEntry;
				length++;
			}				
			else {
				temp1=list[position];
				list[position]=newEntry;
				int i= position;
				while(i <= getLength() ) {	
					temp2 = list[i+1];
					list[i+1] = temp1;
					temp1 = temp2;
					i++;
				}
				length++;
			}
		}		
		else {
			return ("Position is not valid. Please enter a position between 1 and "+ (getLength()+1));
        }
		return "true";
	}
	
	
	/** Removes the entry at a given position from this list.
	 * Entries are moved one position backward and and the list's length is decreased by 1.
	 * @param givenPosition is an integer that defines  the position of  the entry to be removed.
	 * @return a reference to the removed entry.
	 * Handle the error in case of user introduce  a wrong entry*/
	@Override
	public T remove(int givenPosition) {
		T removedEntry = null;
		if(isEmpty()) {
			System.out.println("List is empty, nothing to delete.");
		}
		else {
			if (givenPosition >0 && givenPosition  <= getLength()) {
					removedEntry = list[givenPosition];
					list[givenPosition]= list[givenPosition +1];
					
					for(int i=givenPosition+1; i< getLength(); i++) {
						list[i]=list[i+1];		
						}
					length--;
					return removedEntry;				
				}
				else {
					System.out.println("Position is not valid. Please enter a position between 1 and "+ (getLength()));	
				}				
		}
		return removedEntry;
	}
	

	/** Removes all entries from this list. */
	@Override
	public void clear() {
		list = (T[])new Object[maxlenght];
		length =0;
			
	}
	/** Replaces the entry at a specific position in this list.
	 * @param givenPosition is an integer that indicates the position of the entry to be replaced.
	 * @param newEntry is the  object that will replace the entry at the position givenPosition.
	 * @throw  an exception if IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength(). */
	
	@Override
	public void replace(int givenPosition, T newEntry) {
			
		try {
			if(givenPosition >=1 && givenPosition <= getLength()) {
				list[givenPosition] = newEntry;
			}
			else {	
	            throw new IndexOutOfBoundsException("Position is not valid. Please enter a position between 1 and "
	            + getLength());	
				}
			}		
		catch (IllegalStateException e) {
		        
		        System.out.println("Error: " + e.getMessage());		
		}
					
	}
	
	/**Retrieves the object in an specific position of the list
	 * @param givenPosition is an integer that indicate the position  of the object to be retrieved
	 * @return the object  specified by the entry	 * @throws  an exception if IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength().*/

	@Override
	public T  getEntry(int givenPosition) {
		try {
			
			if (givenPosition >= 1 && givenPosition <= getLength()) {
		        return list[givenPosition];
		    } 
			else {	
	            throw new IndexOutOfBoundsException("Position is not valid. Please enter a position between 1 and"
	            + getLength());	
				}
			}
			
		catch (IllegalStateException e) {
	        
	        System.out.println("Error: " + e.getMessage());	
	        return null;
			}
	}
	/**Search for specific entry in  the list.
	 * @param anEntry is an integer of the desired entry .
	 * @return true if the list contains anEntry, or false if not.*/
	@Override
	public boolean contains(int anEntry) {
		boolean found = false;	
		for(int i=1; i<=getLength(); i++) {
			Employee employee1 = null;
			employee1 = (Employee) list[i];
			
			if(anEntry == employee1.getId()) {
				found=true;
				break;
			}					
		}
		return found;
	}
	/**Search for specific entry in  the list.
	 * @param anEntry is an string of the desired entry .
	 * @return true if the list contains anEntry, or false if not.*/

	@Override
	public boolean contains(String anEntry) {
		boolean found = false;	
		for(int i=1; i<=getLength(); i++) {
			Employee employee1 = null;
			employee1 = (Employee) list[i];
			
			if(anEntry.equals(employee1.getEmail())) {
				found=true;
				break;
			}					
		}
		return found;
	}
	/**Get the length of the list
	 * @return the number of items in the list*
	 * If there are not items in the list returns 0*/
	@Override
	public int  getLength() {
	
		if (isEmpty()) {
			return 0;
		}
		else {
			return length;
		}
	}
	/** Evaluate if the list is empty.
	 * @return True if the list is empty, or false if not. */
	@Override
	public boolean isEmpty() {
		if (length !=0) {
			return false;
		}
		else {
		return true;
		}
	}
	
	/** Retrieves all entries  in the list following the order in which items were added. */
	@Override
	public void toArray() {
		if (isEmpty()) {
			System.out.println("[]");
		}
		else {
			for(int i = 1; i <= getLength(); i++) {
				System.out.println(list[i]);
			}
		}
	}
	
	/**Sorts the list with the algorithm Merge Sort.
	 * @param listEmployees is a list that contains items that will  be sorted
	 * @return  sorted array . */
	@Override
	public  Employee [] mergeSort(Employee [] listEmployees) {
		Employee [] firstSubArray1;
		Employee [] seconSubArray2;
		int  mid;
		
		if (listEmployees.length > 1){
			mid= listEmployees.length  /2;
			firstSubArray1 = new Employee[mid];
			seconSubArray2 = new Employee[listEmployees.length - mid];
			
			for (int i = 0; i < mid; i++) {
				firstSubArray1[i]= listEmployees[i];			    
			}	

			for (int i = mid ; i < listEmployees.length ; i++) {
				seconSubArray2[i- mid]= listEmployees[i];			    
			}
		
			mergeSort(firstSubArray1); 
			mergeSort(seconSubArray2);
			merge(listEmployees, firstSubArray1, seconSubArray2);	
		}
		return listEmployees;
	}
	
	/**Merges the two arrays in one single sorted array.
	 * @param listEmployees is the array that must be sorted
	 * @param firstSubArray is an array that contains the first part of the array Employee
	 * @param secondSubArray is an array that contains the seconds part of the array Employee */
	public static void merge(Employee[]listEmployees, Employee[] firstSubArray, Employee[] secondSubArray)
	{
		int i=0, j=0, k =0; 
		while(i <firstSubArray.length && j < secondSubArray.length) {
			if (firstSubArray[i].getId() <= secondSubArray[j].getId()){
				listEmployees[k]= firstSubArray[i];
				k++;
				i++;			
			}
			else {
				listEmployees[k] = secondSubArray[j];
				k++;
				j++;
			}
		}
		
		while(i< firstSubArray.length) {
			listEmployees[k] = firstSubArray[i];
			k++;
			i++;
		}
		while(j< secondSubArray.length) {
			listEmployees[k] = secondSubArray[j];
			j++;
			k++;
		}			
	}
	
	
	
	/** Orders the list with the algorithm Shell Sort .
	 * @param listEmployees is an array that contains items that will  be sorted
	 * @return  sorted array . */
	@Override
	public Employee[] shellSort(Employee[] listEmployees) {
		int gap;
		Employee temp;
		gap = listEmployees.length/2;
		int j;
		while(gap > 0) {
			for (int i = gap; i < listEmployees.length ;  i++) {
            	 temp = listEmployees[i];
            	 j = i ;
            	 while(j >= gap && (listEmployees[j-gap].getId())> temp.getId()) {
            		 listEmployees[j]=listEmployees[j-gap];
            		 j -= gap;
            	 }       
            	 listEmployees[j]= temp; 
			}
			gap = gap/2;
		}
		return listEmployees;
	}
	
	/** Retrieves all entries of the sorted array .
	 * @param newEntry is an array that contains items that will  be retrieve*/
	@Override
	public void printArraySorted(Employee[] newEntry) {
		System.out.println("Ordered list: ");
	    for (int i = 0; i < newEntry.length; i++) {
	        System.out.println(newEntry[i] + " ");
	    }
	}
}


