package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(
        name = "TB_CORRIDA", uniqueConstraints =  {
                @UniqueConstraint(name = "uc_corrida__nome_e_dataRealizacao", columnNames = { "nome", "dataRealizacao" })
        },
        indexes = {@Index(name = "ix_corrida__nome_e_dataRealizacao",columnList = "nome, dataRealizacao")}
)
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "GRIDS_LARGADA")
    @MapKeyColumn(name = "POSICAO")
    @Column(name = "NOME_PILOTO")
    private Map<Integer, String> gridLargada;

    @Column(nullable = false)
    private LocalDate dataRealizacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCorrida status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Integer, String> getGridLargada() {
        return gridLargada;
    }

    public void setGridLargada(Integer posicao, String nomePiloto) {
        if (gridLargada == null) {
            gridLargada = new HashMap<>();
        }
        gridLargada.put(posicao, nomePiloto);
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Corrida corrida = (Corrida) o;
        return Objects.equals(nome, corrida.nome) && Objects.equals(dataRealizacao, corrida.dataRealizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataRealizacao);
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", gridLargada=<" + gridLargada.keySet() + ", " + gridLargada.values() + ">" +
                ", dataRealizacao=" + dataRealizacao +
                ", status=" + status +
                '}';
    }
}
