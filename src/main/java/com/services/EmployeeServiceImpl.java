/**
 * 
 */
package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IEmployeeDao;
import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanl�
 *
 */


@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	// B�t�n Business-Logic katman�ndaki s�n�flarda @service anostasyonu kullan�lmaktad�r.
	// @transactional veritaban�ndaki verilerin do�ru ve di�er verilerle tutarl� olmas�n� sa�lamak i�in kullan�lan bir y�ntemdir.
	
	// @service anotasyonu ayn� zamanda nesneleri otomatik olarak Bean olarak olu�turmaktad�r.
	// A�a��da Autowired ile IEmployeeDao interface'inden olu�turulan employeeDao Bean'i inject edilmi�tir.
	@Autowired
	private IEmployeeDao employeeDao;
	
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	public List<Employee> findAllWithJoinDepartmentsToEmployees(){
		return employeeDao.findAllWithJoinDepartmentsToEmployees();
	}
	public Employee findById(int emp_id) {
		return employeeDao.findById(emp_id);
	}

	
	public void createEmployeeWithDepartmentInfo(Employee employee, Department department) {
		try {
			employeeDao.createEmployeeWithDepartmentInfo(employee,department);
		} catch (Exception e) {
		
		}
		
	}

	
	public void deleteById(int emp_id) {
		try {
			employeeDao.deleteById(emp_id);
		} catch (Exception e) {
		
		}
		
	}
}
