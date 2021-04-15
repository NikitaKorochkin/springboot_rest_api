package ru.korochkin.spring.springboot.springboot_app.dao;

import ru.korochkin.spring.springboot.springboot_app.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
