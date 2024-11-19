package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EmployeeDAO;
import br.edu.ifpb.es.daw.dao.impl.EmployeeDAOImpl;
import br.edu.ifpb.es.daw.entities.Employee;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainEmployeeDelete {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EmployeeDAO dao = new EmployeeDAOImpl(emf);

            Employee employee = new Employee();

            employee.setName("Lucas");
            employee.setSurname("Gomes");
            employee.setCpf("123.456.789-13");
            employee.setDateOfBirth(LocalDate.of(2000, 12, 26));
            employee.setAddress("Rua tal");
            employee.setSex('M');
            employee.setSalary(new BigDecimal(1400.00));
            employee.setnDapendents(0);

            dao.save(employee);

            System.out.println(dao.getAll().size());

            dao.delete(employee.getId());

            System.out.println(dao.getAll().size());
        }
    }
}
