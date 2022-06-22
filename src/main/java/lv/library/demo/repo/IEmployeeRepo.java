package lv.library.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.library.demo.model.Employee;
import lv.library.demo.model.LibraryDepartment;

public interface IEmployeeRepo extends CrudRepository <Employee, Integer> {

	ArrayList<Employee> findAllByName(String name);

	ArrayList<Employee> findAllBySurname(String surname);

	ArrayList<Employee> findAllByDepartment(LibraryDepartment department);

	ArrayList<Employee> findAllByDepartmentDepartid(int id);

	Employee findByNameAndSurname(String name, String surname);

	Employee findByNameAndSurnameAndDepartmentDepartid(String name, String surname, int id);

}
