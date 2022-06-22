package lv.library.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.library.demo.model.Employee;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.repo.IEmployeeRepo;
import lv.library.demo.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo employeerepo;
	
	@Override
	public Employee createNewEmployee(String name, String surname) {
		Employee temp = new Employee(name, surname);
		Employee employeefromDB = employeerepo.save(temp);
		return employeefromDB;
	}
	
	@Override
	public Employee createNewEmployee(Employee empl) {
		Employee temp = employeerepo.save(empl);
		return temp;
	}
	
	@Override
	public void updateEmployeeById(int id, Employee empl) throws Exception {
		if(employeerepo.existsById(id)) {
			Employee temp = employeerepo.findById(id).get();
			if(!(temp.getName() == empl.getName())) {
				temp.setName(empl.getName());
			}
			if(!(temp.getSurname() == empl.getSurname())) {
				temp.setSurname(empl.getSurname());
			}
			if(!(temp.getDepartment() == empl.getDepartment())) {
				temp.setDepartment(empl.getDepartment());
			}
			employeerepo.save(temp);
		}else {
			throw new Exception("Cannot update Employee, employee does not exist");
		}
	}
	
	@Override
	public void addDepartment(Employee empl ,LibraryDepartment department) throws Exception {
		if(empl.getDepartment() == null) {
			empl.setDepartment(department);
			employeerepo.save(empl);
		}else {
			throw new Exception("Cannot add departmment to employee, employee already has a department");
		}
	}
	
	@Override
	public void removeDepartment(Employee empl) throws Exception {
		if(empl.getDepartment() != null) {
			empl.setDepartment(null);
			employeerepo.save(empl);
		}else {
			throw new Exception("Cannot remove department, employee has no department");
		}
		
	}
	
	@Override
	public void changeDepartment(Employee empl, LibraryDepartment department) throws Exception {
		removeDepartment(empl);
		addDepartment(empl, department);
	}
	
	@Override
	public ArrayList<Employee> findEmployeesByName(String Name){
		return (ArrayList<Employee>)employeerepo.findAllByName(Name);
	}
	
	@Override
	public ArrayList<Employee> findEmployeesBySurname(String Surname){
		return (ArrayList<Employee>)employeerepo.findAllBySurname(Surname);
	}
	
	@Override
	public ArrayList<Employee> findEmployeesByDepartment(LibraryDepartment department){
		return (ArrayList<Employee>)employeerepo.findAllByDepartment(department);
	}
	
	@Override
	public ArrayList<Employee> findEmployeesByDepartmentID(int id){
		return (ArrayList<Employee>)employeerepo.findAllByDepartmentDepartid(id);
	}
	
	@Override
	public Employee findEmployeeByNameAndSurname(String name, String surname) {
		return employeerepo.findByNameAndSurname(name, surname);
	}
	
	@Override
	public Employee findEmployeeByNameAndSurnameAndDepartment(String name, String surname, int id) {
		return employeerepo.findByNameAndSurnameAndDepartmentDepartid(name, surname, id);
	}
	
}
