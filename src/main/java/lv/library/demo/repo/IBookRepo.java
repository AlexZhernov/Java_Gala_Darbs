package lv.library.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.Book;
import lv.library.demo.model.BookCondition;
import lv.library.demo.model.BookRarity;
import lv.library.demo.model.BookRating;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;


public interface IBookRepo extends CrudRepository <Book, Integer>{

	Book findByTitle(String title);

	ArrayList<Book> findAllByName(String name);

	ArrayList<Book> findAllBySurname(String surname);

	ArrayList<Book> findAllByRarity(BookRarity rarity);

	ArrayList<Book> findAllByYear(String year);

	ArrayList<Book> findAllByReaderId(int id);

	ArrayList<Book> findAllByReader(Reader reader);

	ArrayList<Book> findAllByDepartmentsDepartid(int id);

	ArrayList<Book> findAllByDepartments(LibraryDepartment department);

	ArrayList<Book> findAllByRating(BookRating rating);

	ArrayList<Book> findAllByCondition(BookCondition condition);

}
