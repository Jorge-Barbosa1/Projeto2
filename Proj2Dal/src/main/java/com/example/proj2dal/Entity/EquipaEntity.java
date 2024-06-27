package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "equipa", schema = "public", catalog = "projeto")
public class EquipaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_equipa", nullable = false)
    private int idEquipa;
    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @OneToMany(mappedBy = "equipaByIdEquipa")
    private Collection<JogadorEntity> jogadorsByIdEquipa;

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipaEntity that = (EquipaEntity) o;
        return idEquipa == that.idEquipa && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipa, nome);
    }

    public Collection<JogadorEntity> getJogadorsByIdEquipa() {
        return jogadorsByIdEquipa;
    }

    public void setJogadorsByIdEquipa(Collection<JogadorEntity> jogadorsByIdEquipa) {
        this.jogadorsByIdEquipa = jogadorsByIdEquipa;
    }
}
