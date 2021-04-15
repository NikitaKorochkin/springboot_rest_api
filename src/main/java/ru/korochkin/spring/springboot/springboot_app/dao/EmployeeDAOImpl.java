package ru.korochkin.spring.springboot.springboot_app.dao;

//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.korochkin.spring.springboot.springboot_app.entity.Employee;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//
//        List<Employee> allEmps = query.getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmps = query.getResultList();

        return allEmps;
    }

    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);

          Employee newEmp = entityManager.merge(employee);
          employee.setId(newEmp.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where id =: employeeId");
//        query.setParameter("employeeId", id);
//
//        query.executeUpdate();  //executeUpdate() отвечает как за update, так и за delete операции

        Query query = entityManager.createQuery("delete from Employee " +
                "where id=: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
