package lv.library.demo.services;

import java.util.ArrayList;

import lv.library.demo.model.Employee;
import lv.library.demo.model.LibraryDepartment;

public interface IEmployeeService {

	Employee createNewEmployee(String name, String surname);

	Employee createNewEmployee(Employee empl);

	void updateEmployeeById(int id, Employee empl) throws Exception;

	void addDepartment(Employee empl, LibraryDepartment department) throws Exception;

	void removeDepartment(Employee empl) throws Exception;

	void changeDepartment(Employee empl, LibraryDepartment department) throws Exception;

	ArrayList<Employee> findEmployeesByName(String Name);

	ArrayList<Employee> findEmployeesBySurname(String Surname);

	ArrayList<Employee> findEmployeesByDepartment(LibraryDepartment department);

	ArrayList<Employee> findEmployeesByDepartmentID(int id);

	Employee findEmployeeByNameAndSurname(String name, String surname);

	Employee findEmployeeByNameAndSurnameAndDepartment(String name, String surname, int id);

	Employee findById(int id);

}
