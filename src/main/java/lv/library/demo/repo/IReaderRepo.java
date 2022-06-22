package lv.library.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.Reader;


public interface IReaderRepo extends CrudRepository <Reader, Integer> {

}
