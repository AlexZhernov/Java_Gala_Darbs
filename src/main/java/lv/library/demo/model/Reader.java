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
public class Reader {
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Surname")
	private String Surname;
	
	@Column(name = "User Number")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="reader")
	@ToString.Exclude
	private Collection<Book> history = new ArrayList<Book>();
	
	
	public Reader(String name, String surname) {
		super();
		Name = name;
		Surname = surname;
	}

	public String getName() {
		return Name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public void setHistory(Book book) {
		this.history.add(book);
	}
	
	public void addBook(Book book) {
		history.add(book);
	}
	
	public void removeBook(Book book) {
		history.remove(book);
	}
	
	public Collection<Book> getCurrentBooks() {
		return history;
	}
	
	
	
	

}
