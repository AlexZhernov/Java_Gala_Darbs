package lv.library.demo.services;

import java.util.ArrayList;

import lv.library.demo.model.Book;
import lv.library.demo.model.BookClass;
import lv.library.demo.model.BookCondition;
import lv.library.demo.model.BookRarity;
import lv.library.demo.model.BookRating;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;

public interface IBookService {

	Book insertNewBook(String year, String author_Name, String author_Surname, String title, BookRating rating,
			BookRarity rarity, BookCondition condition, BookClass genre, String URL, String Description);

	Book insertNewBook(Book book);

	void updateBookById(int id, Book book) throws Exception;

	Book selectById(int id) throws Exception;

	void removeById(int id) throws Exception;

	ArrayList<Book> SelectAll();

	void addReader(Book book, Reader reader) throws Exception;

	void removeReader(Book book) throws Exception;

	void addDepartment(Book book, LibraryDepartment department) throws Exception;

	void removeDepartment(Book book) throws Exception;

	void changeDepartment(Book book, LibraryDepartment department) throws Exception;

	void changeReader(Book book, Reader reader) throws Exception;

	Book findByTitle(String title);

	ArrayList<Book> findByAuthorName(String name);

	ArrayList<Book> findByAuthorSurname(String surname);

	ArrayList<Book> findByYear(String Year);

	ArrayList<Book> findByRarity(BookRarity rarity);

	ArrayList<Book> findByReader(Reader reader);

	ArrayList<Book> findByDeparmentId(int id);

	ArrayList<Book> findByDepartment(LibraryDepartment department);

	ArrayList<Book> findByRating(BookRating rating);

	ArrayList<Book> findByCondition(BookCondition condition);

	ArrayList<Book> findByReaderId(int id);

}
