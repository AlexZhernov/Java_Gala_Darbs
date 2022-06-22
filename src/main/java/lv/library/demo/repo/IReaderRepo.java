package lv.library.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.Reader;


public interface IReaderRepo extends CrudRepository <Reader, Integer> {

	ArrayList<Reader> findAllByName(String name);

	ArrayList<Reader> findAllBySurname(String name);

	Reader findByNameAndSurname(String name, String surname);

}
