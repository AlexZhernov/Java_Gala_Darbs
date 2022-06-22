package lv.library.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.LibraryDepartment;

public interface ILibraryRepo extends CrudRepository <LibraryDepartment, Integer> {

	ArrayList<LibraryDepartment> findAllByName(String name);

	ArrayList<LibraryDepartment> findAllByWorkintimes(String workingtimes);

	LibraryDepartment findByNameAndWorkintimes(String name, String workingtimes);

}
