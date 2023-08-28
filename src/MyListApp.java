
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

/**Main class that executes the entire application
 * author Liceth Leguizamon*/

public class MyListApp {
	 private static Employee employee;
	 private static String name, email, department, status;
	 private static int id;
	 private static int selectedOption;
	 private static Employee [] employeeArray; 
	 private static Employee [] arraySortedEmployee;
	 private static ListInterface<Employee> listEmployees = new MyList<>();
	 
	 
	 /**Displays and execute all options for the user
	  * @throw an exception if InputMismatchException  are not in required format */
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		selectedOption = 10;
		
		while (selectedOption !=0) {
			displayMenu();
			System.out.print("Please enter the option: ");
			try {
				selectedOption = scanner.nextInt();
				scanner.nextLine();
				
				if(selectedOption <0 || selectedOption >9) {
					System.out.print("Please enter a valid option.");
				}
				else if (selectedOption == 0) {
					break;
				}
				else if (selectedOption ==1){
					displayAddEmployeeMenu();
					listEmployees.add(employee);
					
				}
				else if (selectedOption ==2) {
					String result = "false";
					while (result != "true"){
						displayAddEmployeeMenu();
						System.out.println("Please enter the position:");
						int position =0;
						position=scanner.nextInt();
						scanner.nextLine();
						result = listEmployees.add(position, employee);
						System.out.println(result);
					}
				}
					
				else if (selectedOption == 3) {
					System.out.println("Please enter the position to be removed:");
					int position =0;
					position=scanner.nextInt();
					scanner.nextLine();
					System.out.println(listEmployees.remove(position));
				}
				
				else if(selectedOption == 4) {
					listEmployees.clear();
				}
				else if(selectedOption == 5) {
					listEmployees.toArray();
				}
				else if(selectedOption == 6) {
					System.out.print("Please enter the employee's id or email to search for: ");
					String search;
					search=scanner.nextLine();
					try {
						int id = Integer.parseInt(search); 
						System.out.println(listEmployees.contains(id));
					}
					catch (Exception e) {
						System.out.println(listEmployees.contains(search));
					}
					
				}
				else if(selectedOption == 7) {
					System.out.println(listEmployees.getLength());
				}
				else if(selectedOption == 8) {
					System.out.println(listEmployees.isEmpty());
				}
				else if (selectedOption == 9 ) {
					
					int subMenuOption = 10;
					while(subMenuOption !=0) {
						System.out.println("Plase select one of the following options or 0 to comeback to main menu");
						System.out.println("1. Sort with  selection sort");
						System.out.println("2. Sort with  merge sort");
						System.out.println("3. Sort with shell sort");
						System.out.print("Enter your option: ");
						
						try {
							subMenuOption = scanner.nextInt();
							scanner.nextLine();
							if(subMenuOption ==0) {
								break;
								}
							if(subMenuOption <0 || subMenuOption >3) {
								System.out.print("Enter a valid option  ");
								}
							if(subMenuOption == 1) {
								selectionSort(listEmployees);
							}
							if (subMenuOption==2) {
								int size;
								size=  listEmployees.getLength();
								employeeArray = new Employee [size];
								for (int i = 0; i < size; i++) {
								    employeeArray[i] = listEmployees.getEntry(i+1);
								}
								
								arraySortedEmployee = listEmployees.mergeSort(employeeArray); 
								listEmployees.printArraySorted(arraySortedEmployee);
											
							}
							if (subMenuOption==3) {
								int size;
								size=  listEmployees.getLength();
	
								employeeArray = new Employee [size];
								for (int i = 0; i < size; i++) {
								    employeeArray[i] = listEmployees.getEntry(i+1);
								}
	
								System.out.println(employeeArray.length);
								arraySortedEmployee =listEmployees.shellSort(employeeArray);
								
								listEmployees.printArraySorted(arraySortedEmployee);
								
								
								arraySortedEmployee = listEmployees.shellSort(employeeArray); 
								listEmployees.printArraySorted(arraySortedEmployee);
							}
							
						} 
						catch (InputMismatchException e) {
				            System.out.println("Invalid input. Please enter a valid option.");
				            scanner.nextLine();
				        }		     
					}							
				}

			}
			catch (InputMismatchException e) {
	            System.out.println("Invalid input, returning to main menu.");
	            scanner.nextLine();
			}
		}	
	}
	 /** Display menu with the option for the users */
	public static void displayMenu() {
		System.out.println("Please select one of the following options or 0 to finish");
		System.out.println("1. Add an employee");
		System.out.println("2. Add an employee in specific position");
		System.out.println("3. Remove  an employee");
		System.out.println("4. Remove all employees");
		System.out.println("5. Retrieve information from all employees");
		System.out.println("6. Search an employee");
		System.out.println("7. Count the number of the employees");
		System.out.println("8. Check if the employee list is empty");
		System.out.println("9. Sort the employee list");
	
	}
	 /** Display menu with the option  for the user to select a sorting algorithm*/
	public static void  displayAddEmployeeMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please introduce the following data for employees");
		System.out.print("Name: ");
		name = scanner.nextLine();
		id = -1;
		while (id == -1) {
			try {
				System.out.print("Id: ");
				id = scanner.nextInt();
				scanner.nextLine();
			}
			catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid option.");
	            scanner.nextLine();
			}
		}
		System.out.print("Email: ");
		email= scanner.nextLine();
		System.out.print("Deparment: ");
		department = scanner.nextLine();
		System.out.print("Status: ");
		status = scanner.nextLine();
		employee = new Employee(name, id, email, department, status);
		
	}
	/** Sorts the list with the algorithm Shell Sort .
	 * @param listEmployees is a list that contains items that will  be sorted */
	public static  void selectionSort(ListInterface<Employee> listEmployees) {
		Employee employee1 = null;
		Employee employee2= null;
		
		if (listEmployees.isEmpty()){
			System.out.print("The list is empty. ");
		}
		for(int i= 1; i<= listEmployees.getLength(); i++) {
			int j;
			for( j =i+1; j<= listEmployees.getLength(); j++) {
				
				  employee1 = listEmployees.getEntry(i);
				  employee2 = listEmployees.getEntry(j);
				
				if (employee1.getId() > employee2.getId()) { 				
					listEmployees.replace(i, employee2);
					listEmployees.replace(j, employee1);
				}
			}
		
		}
		listEmployees.toArray();
	}

}