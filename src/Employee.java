/**Class that  store the data of employees*/
public class Employee  {
	
	String name ;
	String email;
	String department;
	String status;
	int id;
	
	public Employee(String name, int id, String email, String deparment, String status) {
		this.name= name;
		this.id = id;
		this.email = email;
		this.department = deparment;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
        return String.format("Name: %s%nID:  %s%nEmail: %s%nDeparment: %s%nStatus: %s%n", 
        		getName(), getId(), getEmail(), getDepartment(), getStatus());
    }

}
