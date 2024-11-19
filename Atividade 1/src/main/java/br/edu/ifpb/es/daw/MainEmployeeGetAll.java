package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EmployeeDAO;
import br.edu.ifpb.es.daw.dao.impl.EmployeeDAOImpl;
import br.edu.ifpb.es.daw.entities.Employee;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainEmployeeGetAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EmployeeDAO dao = new EmployeeDAOImpl(emf);

            List<Employee> employees = dao.getAll();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

        }
    }
}
