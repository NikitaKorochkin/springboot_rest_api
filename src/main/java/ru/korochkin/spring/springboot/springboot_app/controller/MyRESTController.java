package ru.korochkin.spring.springboot.springboot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.korochkin.spring.springboot.springboot_app.entity.Employee;
import ru.korochkin.spring.springboot.springboot_app.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees()    {

        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    /**Аннотация @PathVariable используется для
     * получения значения переменной из адреса запроса */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    /**Анотация @RequestBody связывает HTTP запрос,
     * использующий HTTP метод POST с методом контроллера */
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee)    {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)  {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)    {

        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);

        String deleteMes = "Employee with ID = " + id + " was deleted";

        return deleteMes;
    }
}
