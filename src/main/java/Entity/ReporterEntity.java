package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "reporter", schema = "public", catalog = "projeto")
public class ReporterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_reporter")
    private BigInteger idReporter;

    public BigInteger getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(BigInteger idReporter) {
        this.idReporter = idReporter;
    }

    @Basic
    @Column(name = "id_jogo")
    private BigInteger idJogo;

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }

    @Basic
    @Column(name = "id_contactos")
    private BigInteger idContactos;

    public BigInteger getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(BigInteger idContactos) {
        this.idContactos = idContactos;
    }

    @Basic
    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
