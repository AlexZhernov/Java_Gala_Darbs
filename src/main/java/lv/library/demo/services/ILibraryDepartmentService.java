package lv.library.demo.services;

import java.util.ArrayList;

import lv.library.demo.model.Book;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;

public interface ILibraryDepartmentService {

	LibraryDepartment createDepartment(String name, String time);

	LibraryDepartment createDepartment(LibraryDepartment depart);

	void updateDepartmentById(int id, LibraryDepartment depart) throws Exception;

	void addBook(Book book, LibraryDepartment dep) throws Exception;

	void removeBook(Book book) throws Exception;

	void giveBook(Book book, Reader reader) throws Exception;

	void takeBook(Book book) throws Exception;

	ArrayList<LibraryDepartment> findByName(String name);

	ArrayList<LibraryDepartment> findByWorkingTimes(String workingtimes);

	LibraryDepartment findById(int id);

	LibraryDepartment findByNameAndWorkingTimes(String name, String workingtimes);

}
