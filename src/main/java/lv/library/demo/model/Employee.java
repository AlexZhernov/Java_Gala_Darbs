package lv.library.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Table
@Entity
public class Employee {
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Surname")
	private String surname;
	
	@Column(name = "Employee ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employID;
	
	@ManyToOne
	@JoinColumn(name="Department Number")
	private LibraryDepartment department;
	

	public Employee(String name, String surname) {
		setName(name);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setDepartment(LibraryDepartment department) {
		this.department = department;
	}
	
	public LibraryDepartment getDepartment() {
		return department;
	}
	
	
}
