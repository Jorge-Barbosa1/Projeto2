package com.example.proj2dal.Entity;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "utilizador", schema = "public", catalog = "projeto")
public class UtilizadorEntity {
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "telefone")
    private BigInteger telefone;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @OneToMany(mappedBy = "utilizadorByIdUser")
    private Collection<ReporterEntity> reportersByIdUser;

    @Basic
    @Column(name = "isAdmin")
    private int isAdmin;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Collection<ReporterEntity> getReportersByIdUser() {
        return reportersByIdUser;
    }

    public void setReportersByIdUser(Collection<ReporterEntity> reportersByIdUser) {
        this.reportersByIdUser = reportersByIdUser;
    }
}
