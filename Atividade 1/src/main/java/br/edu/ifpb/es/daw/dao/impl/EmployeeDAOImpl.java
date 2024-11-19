package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.EmployeeDAO;
import br.edu.ifpb.es.daw.entities.Employee;
import jakarta.persistence.EntityManagerFactory;

public class EmployeeDAOImpl extends AbstractDAOImpl<Employee, Long> implements EmployeeDAO {

    public EmployeeDAOImpl(EntityManagerFactory emf) {
        super(Employee.class, emf);
    }
}
