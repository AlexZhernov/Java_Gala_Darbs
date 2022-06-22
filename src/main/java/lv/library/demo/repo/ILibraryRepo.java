package lv.library.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.LibraryDepartment;

public interface ILibraryRepo extends CrudRepository <LibraryDepartment, Integer> {

}
