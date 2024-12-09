package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.entities.Corrida;
import jakarta.persistence.EntityManagerFactory;

public class CorridaDAOImpl extends AbstractDAOImpl<Corrida, Long> implements CorridaDAO {

    public CorridaDAOImpl(EntityManagerFactory emf) {
        super(Corrida.class, emf);
    }
}
