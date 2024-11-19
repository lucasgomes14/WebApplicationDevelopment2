package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EmployeeDAO;
import br.edu.ifpb.es.daw.dao.impl.EmployeeDAOImpl;
import br.edu.ifpb.es.daw.entities.Employee;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainEmployeeSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EmployeeDAO dao = new EmployeeDAOImpl(emf);

            Employee employee = new Employee();

            employee.setName("Lucas");
            employee.setSurname("Gomes");
            employee.setCpf("123.456.789-10");
            employee.setDateOfBirth(LocalDate.of(2000, 12, 26));
            employee.setAddress("Rua tal");
            employee.setSex('M');
            employee.setSalary(new BigDecimal(1400.00));
            employee.setnDapendents(0);

            System.out.println(employee);

            dao.save(employee);

            System.out.println(employee);
        }
    }
}
