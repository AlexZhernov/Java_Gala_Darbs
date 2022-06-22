package lv.library.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Table
@Entity
public class LibraryDepartment {
	@Column(name = "Department Number")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departid;
	
	@Column(name = "Department Name")
	private String Name;
	
	@Column(name = "Working Times")
	private String workintimes;
	
	@OneToMany(mappedBy="department")
	@ToString.Exclude
	private Collection<Employee> Employee = new ArrayList<Employee>();
	
	@OneToMany(mappedBy="departments")
	@ToString.Exclude
	private Collection<Book> Books = new ArrayList<Book>();
	
	public LibraryDepartment(String name, String workintimes) {
		super();
		Name = name;
		this.workintimes = workintimes;
	}

	public String getName() {
		return Name;
	}

	public String getWorkintimes() {
		return workintimes;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setWorkintimes(String workintimes) {
		this.workintimes = workintimes;
	}
	
	public void addEmployee(Employee empl) {
		Employee.add(empl);
		empl.setDepartment(this);
	}
	
	public void removeEmployee(Employee empl) {
		Employee.remove(empl);
		empl.setDepartment(null);
	}
	
	public void addBook(Book book) {
		this.Books.add(book);
		book.setDepartment(this);
	}
	
	public void removeBook(Book book) {
		this.Books.remove(book);
	}
	
	public void giveBook(Book book, Reader reader) {
		if(this.Books.contains(book)) {
			book.addReader(reader);
			reader.addBook(book);
		}
	}
	
	public void takeBook(Book book) {
		if(this.Books.contains(book)) {
			if(book.getReader() != null) {
				book.removeCurrentReader();
			}
		}
	}


	
	
}
