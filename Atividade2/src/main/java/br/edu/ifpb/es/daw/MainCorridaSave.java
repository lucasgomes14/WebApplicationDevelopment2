package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import br.edu.ifpb.es.daw.entities.StatusCorrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainCorridaSave {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			CorridaDAO dao = new CorridaDAOImpl(emf);

			for (int i = 0; i < 5; i++) {
				Corrida corrida = new Corrida();

				corrida.setNome("Corrida " + i);
				corrida.setGridLargada(i, "Corrida " + i);
				corrida.setDataRealizacao(LocalDate.now());
				corrida.setStatus(StatusCorrida.values()[i]);

				System.out.println(corrida);

				dao.save(corrida);

				System.out.println(corrida);
			}
		}
	}

}
