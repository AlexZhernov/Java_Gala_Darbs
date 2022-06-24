package lv.library.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.model.Book;
import lv.library.demo.model.Reader;
import lv.library.demo.repo.IReaderRepo;
import lv.library.demo.services.IBookService;
import lv.library.demo.services.IReaderService;

@Service
public class ReaderServiceImpl implements IReaderService{

	
	@Autowired
	private IReaderRepo readerepo;
	
	@Autowired
	private IBookService bookrepo;
	
	@Override
	public Reader insertReader(String name, String Surname) {
		Reader temp = new Reader(name, Surname);
		Reader readerfromDB = readerepo.save(temp);
		return readerfromDB;
	}
	
	@Override
	public Reader insertReader(Reader read) {
		Reader temp = readerepo.save(read);
		return temp;
	}
	
	@Override
	public void updateReaderById(int id, Reader read) throws Exception {
		if(readerepo.existsById(id)) {
			Reader temp = readerepo.findById(id).get();
				if(!(temp.getName() == read.getName())) {
					temp.setName(read.getName());
				}
				if(!(temp.getSurname() == read.getSurname())) {
					temp.setSurname(read.getSurname());
				}
				readerepo.save(temp);
			
		}else {
			throw new Exception("Cannot update reader, this reader does not exist");
		}
	}
	
	@Override
	public ArrayList<Reader> getAllReader(){
		return (ArrayList<Reader>)readerepo.findAll();
	}
	
	@Override
	public void addHistory(Reader reader, Book book) {
		reader.addBook(book);
		readerepo.save(reader);
	}
	
	@Override
	public ArrayList<Reader> findAllByName(String name){
		return (ArrayList<Reader>)readerepo.findAllByName(name);
	}
	
	@Override
	public ArrayList<Reader> findAllBySurname(String name){
		return (ArrayList<Reader>)readerepo.findAllBySurname(name);
	}
	
	@Override
	public Reader findByNameAndSurname(String name, String surname) {
		return readerepo.findByNameAndSurname(name, surname);
	}
	
	@Override
	public Reader findById(int id) {
		return readerepo.findById(id).get();
	}
	
	@Override
	public Reader findByBookTitle(String title) {
		return bookrepo.findByTitle(title).getReader();
	}
}
