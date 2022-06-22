package lv.library.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.model.Book;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;
import lv.library.demo.repo.ILibraryRepo;
import lv.library.demo.services.IBookService;
import lv.library.demo.services.ILibraryDepartmentService;
import lv.library.demo.services.IReaderService;

@Service
public class LibraryDepartmentServiceImpl implements ILibraryDepartmentService {

	@Autowired
	private ILibraryRepo libraryrepo;
	
	@Autowired
	private IReaderService readerservice;
	
	@Autowired
	private IBookService bookservice;
	
	@Override
	public LibraryDepartment createDepartment(String name, String time) {
		LibraryDepartment temp = new LibraryDepartment(name, time);
		LibraryDepartment departmentfromDB = libraryrepo.save(temp);
		return departmentfromDB;
	}
	
	@Override
	public LibraryDepartment createDepartment(LibraryDepartment depart) {
		LibraryDepartment departmentfromDB = libraryrepo.save(depart);
		return departmentfromDB;
	}
	
	@Override
	public void updateDepartmentById(int id, LibraryDepartment depart) throws Exception {
		if(libraryrepo.existsById(id)) {
			LibraryDepartment temp = libraryrepo.findById(id).get();
			if(!(temp.getName() == depart.getName())) {
				temp.setName(depart.getName());
			}
			if(!(temp.getWorkintimes() == depart.getWorkintimes())) {
				temp.setWorkintimes(depart.getWorkintimes());
			}
			libraryrepo.save(temp);
		}else {
			throw new Exception("Cannot update department, this department does not exist");
		}
	}
	
	@Override
	public void addBook(Book book, LibraryDepartment dep) throws Exception {
		bookservice.changeDepartment(book, dep);
	}
	
	@Override
	public void removeBook(Book book) throws Exception {
		bookservice.removeDepartment(book);
	}
	
	@Override
	public void giveBook(Book book, Reader reader) throws Exception {
		bookservice.addReader(book, reader);
		readerservice.addHistory(reader, book);
	}
	
	@Override
	public void takeBook(Book book) throws Exception {
		bookservice.removeReader(book);
	}
	
	@Override
	public ArrayList<LibraryDepartment> findByName (String name){
		return (ArrayList<LibraryDepartment>)libraryrepo.findAllByName(name);
	}
	
	@Override
	public ArrayList<LibraryDepartment> findByWorkingTimes (String workingtimes){
		return (ArrayList<LibraryDepartment>)libraryrepo.findAllByWorkintimes(workingtimes);
	}
	
	@Override
	public LibraryDepartment findById(int id) {
		return libraryrepo.findById(id).get();
	}
	
	@Override
	public LibraryDepartment findByNameAndWorkingTimes (String name, String workingtimes) {
		return libraryrepo.findByNameAndWorkintimes(name, workingtimes);
	}
}
