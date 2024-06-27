package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "reporter", schema = "public", catalog = "projeto")
public class ReporterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reporter", nullable = false, precision = 0)
    private BigInteger idReporter;
    @Basic
    @Column(name = "id_jogo", nullable = false, precision = 0)
    private BigInteger idJogo;
    @Basic
    @Column(name = "id_contactos", nullable = false, precision = 0)
    private BigInteger idContactos;
    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 50)
    private String password;
    @Basic
    @Column(name = "id_user", nullable = true)
    private Integer idUser;
    @ManyToOne
    @JoinColumn(name = "id_jogo", referencedColumnName = "id_jogo", nullable = false, insertable = false, updatable = false)
    private JogoEntity jogoByIdJogo;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    private UtilizadorEntity utilizadorByIdUser;
    @OneToMany(mappedBy = "reporterByIdReporter")
    private Collection<ReporterFavoritosEntity> reporterFavoritosByIdReporter;

    public BigInteger getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(BigInteger idReporter) {
        this.idReporter = idReporter;
    }

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }

    public BigInteger getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(BigInteger idContactos) {
        this.idContactos = idContactos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public JogoEntity getJogoByIdJogo() {
        return jogoByIdJogo;
    }

    public void setJogoByIdJogo(JogoEntity jogoByIdJogo) {
        this.jogoByIdJogo = jogoByIdJogo;
    }

    public UtilizadorEntity getUtilizadorByIdUser() {
        return utilizadorByIdUser;
    }

    public void setUtilizadorByIdUser(UtilizadorEntity utilizadorByIdUser) {
        this.utilizadorByIdUser = utilizadorByIdUser;
    }

    public Collection<ReporterFavoritosEntity> getReporterFavoritosByIdReporter() {
        return reporterFavoritosByIdReporter;
    }

    public void setReporterFavoritosByIdReporter(Collection<ReporterFavoritosEntity> reporterFavoritosByIdReporter) {
        this.reporterFavoritosByIdReporter = reporterFavoritosByIdReporter;
    }

}
