package lv.library.demo.services;

import java.util.ArrayList;

import lv.library.demo.model.Book;
import lv.library.demo.model.Reader;

public interface IReaderService {

	Reader insertReader(String name, String Surname);

	Reader insertReader(Reader read);

	void updateReaderById(int id, Reader read) throws Exception;

	void addHistory(Reader reader, Book book);

	ArrayList<Reader> findAllByName(String name);

	ArrayList<Reader> findAllBySurname(String name);

	Reader findByNameAndSurname(String name, String surname);

	Reader findById(int id);

}
