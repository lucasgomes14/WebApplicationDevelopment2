package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import br.edu.ifpb.es.daw.entities.StatusCorrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainCorridaUpdate {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            CorridaDAO dao = new CorridaDAOImpl(emf);
            Corrida corrida = new Corrida();

            corrida.setNome("Corrida " + 20);
            corrida.setGridLargada(20, "Corrida 20");
            corrida.setDataRealizacao(LocalDate.now());
            corrida.setStatus(StatusCorrida.values()[2]);

            dao.save(corrida);

            System.out.println(corrida);

            corrida.setNome("Corrida 30");

            dao.update(corrida);

            System.out.println(corrida);
        }
    }

}
