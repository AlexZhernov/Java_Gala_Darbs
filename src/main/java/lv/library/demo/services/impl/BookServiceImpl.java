package lv.library.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.model.Book;
import lv.library.demo.model.BookClass;
import lv.library.demo.model.BookCondition;
import lv.library.demo.model.BookRarity;
import lv.library.demo.model.BookRating;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;
import lv.library.demo.repo.IBookRepo;
import lv.library.demo.services.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepo bookrepo;
	
	@Override
	public Book insertNewBook(String year, String author_Name, String author_Surname, String title, BookRating rating,
			BookRarity rarity, BookCondition condition, BookClass genre, String URL, String Description) {
		Book temp = new Book(year, author_Name, author_Surname, title, rating, rarity, condition, genre, URL, Description);
		Book bookfromDB = bookrepo.save(temp);
		return bookfromDB;
	}
	
	@Override
	public Book insertNewBook(Book book) {
		Book temp = bookrepo.save(book);
		return temp;
	}
	
	@Override
	public void updateBookById(int id, Book book) throws Exception {
		if(bookrepo.existsById(id)) {
			Book booktemp = bookrepo.findById(id).get();
			if(!(booktemp.getYear() == book.getYear())) {
				booktemp.setYear(book.getYear());
			}
			if(!(booktemp.getAuthor_Name() == book.getAuthor_Name())) {
				booktemp.setAuthor_Name(book.getAuthor_Name());
			}
			if(!(booktemp.getAuthor_Surname() == book.getAuthor_Surname())) {
				booktemp.setAuthor_Surname(book.getAuthor_Surname());
			}
			if(!(booktemp.getCondition() == book.getCondition())) {
				booktemp.setCondition(book.getCondition());
			}
			if(!(booktemp.getDepartment() == book.getDepartment())) {
				booktemp.setDepartment(book.getDepartment());
			}
			if(!(booktemp.getDescription() == book.getDescription())) {
				booktemp.setDescription(book.getDescription());
			}
			if(!(booktemp.getGenre() == book.getGenre())) {
				booktemp.setGenre(book.getGenre());
			}
			if(!(booktemp.getImageURL() == book.getImageURL())) {
				booktemp.setImageURL(book.getImageURL());
			}
			if(!(booktemp.getRarity() == book.getRarity())){
				booktemp.setRarity(book.getRarity());
			}
			if(!(booktemp.getTitle() == book.getTitle())) {
				booktemp.setTitle(book.getTitle());
			}
			if(!(booktemp.getReader() == book.getReader())) {
				booktemp.addReader(book.getReader());
			}
			if(!(booktemp.getRating() == book.getRating())) {
				booktemp.setRating(book.getRating());
			}
			
			bookrepo.save(booktemp);
		} else {
			throw new Exception("Cannot update, because this book does not exist");
		}
	}
	
	@Override
	public Book selectById(int id) throws Exception {
		if(bookrepo.existsById(id)) {
			Book temp = bookrepo.findById(id).get();
			return temp;	
		}else {
			throw new Exception("Cannot select, because this book does not exist");
		}

	}
	
	@Override
	public void removeById(int id) throws Exception {
		if(bookrepo.existsById(id)) {
			bookrepo.deleteById(id);
		}else {
			throw new Exception("Cannot delete, because this book does not exist");
		}
	}
	
	@Override
	public ArrayList<Book> SelectAll(){
		return (ArrayList<Book>)bookrepo.findAll();
	}
	
	@Override
	public void addReader(Book book, Reader reader) throws Exception {
		if(book.getReader() == null) {
			book.addReader(reader);
			bookrepo.save(book);
		}else {
			throw new Exception("Cannot add reader to book, book already has a reader");
		}
		
	}
	
	@Override
	public void removeReader(Book book) throws Exception {
		if(book.getReader() != null) {
			book.removeCurrentReader();
			bookrepo.save(book);
		}else {
			throw new Exception("Cannot remove current reader, book has no reader already");
		}
	}
	
	@Override
	public void changeReader(Book book, Reader reader) throws Exception {
		removeReader(book);
		addReader(book, reader);
	}
	
	@Override
	public void addDepartment(Book book, LibraryDepartment department) throws Exception {
		if(book.getDepartment() == null) {
			book.setDepartment(department);
			bookrepo.save(book);
		}else {
			throw new Exception("Cannot add departement, book already has a department");
		}
	}
	
	@Override
	public void removeDepartment(Book book) throws Exception {
		if(book.getDepartment() != null) {
			book.setDepartment(null);
			bookrepo.save(book);
		}else {
			throw new Exception("Cannot remove department, book already has no department");
		}
	}
	
	@Override
	public void changeDepartment(Book book, LibraryDepartment department) throws Exception {
		removeDepartment(book);
		addDepartment(book, department);
	}
	
	@Override
	public Book findByTitle(String title){
		return bookrepo.findByTitle(title);
	}
	
	@Override
	public ArrayList<Book> findByAuthorName(String name){
		return (ArrayList<Book>)bookrepo.findAllByName(name);
	}
	
	@Override
	public ArrayList<Book> findByAuthorSurname(String surname){
		return (ArrayList<Book>)bookrepo.findAllBySurname(surname);
	}
	
	@Override
	public ArrayList<Book> findByYear(String Year){
		return (ArrayList<Book>)bookrepo.findAllByYear(Year);
	}
	
	@Override
	public ArrayList<Book> findByRarity(BookRarity rarity){
		return (ArrayList<Book>)bookrepo.findAllByRarity(rarity);
	}
	
	@Override
	public ArrayList<Book> findByCondition(BookCondition condition){
		return (ArrayList<Book>)bookrepo.findAllByCondition(condition);
	}
	
	@Override
	public ArrayList<Book> findByRating(BookRating rating){
		return (ArrayList<Book>)bookrepo.findAllByRating(rating);
	}
	
	@Override
	public ArrayList<Book> findByDepartment(LibraryDepartment department){
		return (ArrayList<Book>)bookrepo.findAllByDepartments(department);
	}
	
	@Override
	public ArrayList<Book> findByDeparmentId(int id){
		return (ArrayList<Book>)bookrepo.findAllByDepartmentsDepartid(id);
	}
	
	@Override
	public ArrayList<Book> findByReader(Reader reader){
		return (ArrayList<Book>)bookrepo.findAllByReader(reader);
	}
	
	@Override
	public ArrayList<Book> findByReaderId(int id){
		return (ArrayList<Book>)bookrepo.findAllByReaderId(id);
	}
}
