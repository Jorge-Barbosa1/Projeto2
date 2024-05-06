package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "administrador", schema = "public", catalog = "projeto")
public class AdministradorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_administrador", nullable = false, precision = 0)
    private BigInteger idAdministrador;
    @Basic
    @Column(name = "id_contactos")
    private BigInteger idContactos;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @OneToMany(mappedBy = "administradorByIdAdministrador")
    private Collection<JogoEntity> jogosByIdAdministrador;

    public BigInteger getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(BigInteger idAdministrador) {
        this.idAdministrador = idAdministrador;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministradorEntity that = (AdministradorEntity) o;
        return idUser == that.idUser && Objects.equals(idAdministrador, that.idAdministrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdministrador, idUser);
    }

    public Collection<JogoEntity> getJogosByIdAdministrador() {
        return jogosByIdAdministrador;
    }

    public void setJogosByIdAdministrador(Collection<JogoEntity> jogosByIdAdministrador) {
        this.jogosByIdAdministrador = jogosByIdAdministrador;
    }
}
