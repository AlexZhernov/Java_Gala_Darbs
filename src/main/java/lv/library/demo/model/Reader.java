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
	private String name;
	
	@Column(name = "Surname")
	private String surname;
	
	@Column(name = "User Number")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="reader")
	@ToString.Exclude
	private Collection<Book> history = new ArrayList<Book>();
	
	
	public Reader(String name, String surname) {
		super();
		setName(name);
		setSurname(surname);
	}

	public int getId() {
		return id;
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
