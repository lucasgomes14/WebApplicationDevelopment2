package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainCorridaGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			CorridaDAO dao = new CorridaDAOImpl(emf);

			List<Corrida> corridas = dao.getAll();

			for (Corrida corrida : corridas) {
				System.out.println(corrida);
			}
		}
	}

}
