package lv.library.demo.model;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Queue;

import lombok.ToString;

@ToString
@Table
@Entity
public class Book {
	@Column(name = "Isbn")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;
	
	@Column(name = "Year")
	private String year;
	
	@Column(name = "Author Name")
	private String name;
	
	@Column(name = "Author Surname")
	private String surname;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Rating")
	private BookRating rating;
	
	@Column(name = "Rarity")
	private BookRarity rarity;
	
	@Column(name = "Condition")
	private BookCondition condition;
	
	@Column(name = "Genre")
	private BookClass genre;
	
	@ToString.Exclude
	private String imageURL;
	
	@ToString.Exclude
	private String description;
	
	@ManyToOne
    @JoinColumn(name="User Number")
    private Reader reader;
	
	@ManyToOne
	@JoinColumn(name="Department Number")
	private LibraryDepartment departments;
	
	
	
	//Bez argumenta konstruktors
	public Book() { 
		setYear("2000");
		setAuthor_Name("TempName");
		setAuthor_Surname("TempSurname");
		setTitle("TempBook");
		setRarity(BookRarity.Common);
		setRating(rating.Three_Star);
		setCondition(condition.Perfect);
		setGenre(genre.Fantasy);
		setImageURL("None");
		setDescription("Temporary descrpitopn for temporary book");
	}
	
	//Konstruktors ja zināms tikai tā gads, autora vards, autora uzvards, un gramatas noasukums
	public Book(String year, String author_Name, String author_Surname, String title, BookClass genre, String URL, String Description) {
		
		setYear(year);
		setAuthor_Name(author_Name);
		setAuthor_Surname(author_Surname);
		setTitle(title);
		setRarity(BookRarity.Common);
		setRating(rating.Three_Star);
		setCondition(condition.Perfect);
		setGenre(genre);
		setImageURL(URL);
		setDescription(Description);
	}

	//Konstruktors ar visiem parametriem
	public Book(String year, String author_Name, String author_Surname, String title, BookRating rating,
			BookRarity rarity, BookCondition condition, BookClass genre, String URL, String Description) {
		
		setYear(year);
		setAuthor_Name(author_Name);
		setAuthor_Surname(author_Surname);
		setTitle(title);
		setRarity(rarity);
		setRating(rating);
		setCondition(condition);
		setGenre(genre);
		setImageURL(URL);
		setDescription(Description);
	}

	public String getYear() {
		return year;
	}

	public String getAuthor_Name() {
		return name;
	}

	public String getAuthor_Surname() {
		return surname;
	}

	public String getTitle() {
		return title;
	}

	public BookRating getRating() {
		return rating;
	}

	public BookRarity getRarity() {
		return rarity;
	}

	public BookCondition getCondition() {
		return condition;
	}
	
	public BookClass getGenre() {
		return genre;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public String getDescription() {
		return description;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setAuthor_Name(String author_Name) {
		this.name = author_Name;
	}

	public void setAuthor_Surname(String author_Surname) {
		this.surname = author_Surname;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRating(BookRating rating) {
		this.rating = rating;
	}

	public void setRarity(BookRarity rarity) {
		this.rarity = rarity;
	}

	public void setCondition(BookCondition condition) {
		this.condition = condition;
	}
	
	public void setGenre(BookClass genre) {
		this.genre = genre;
	}
	
	public void setImageURL(String URL) {
		this.imageURL = URL;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addReader(Reader reader) {
		if(this.reader == null) {
			this.reader = reader;
		}
	}
	
	public Reader getReader() {
		return reader;
	}
	
	public void removeCurrentReader() {
		if(this.reader != null) {
				this.reader = null;
		}
	}
	
	public void setDepartment(LibraryDepartment department) {
		this.departments = department;
	}
	
	public LibraryDepartment getDepartment() {
		return this.departments;
	}
}
