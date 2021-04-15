package ru.korochkin.spring.springboot.springboot_app.service;



import ru.korochkin.spring.springboot.springboot_app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
