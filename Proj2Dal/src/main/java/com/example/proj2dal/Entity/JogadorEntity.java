package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jogador", schema = "public", catalog = "projeto")
public class JogadorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_jogador", nullable = false)
    private int idJogador;
    @Basic
    @Column(name = "nome", nullable = true, length = 250)
    private String nome;
    @Basic
    @Column(name = "id_equipa", nullable = true)
    private Integer idEquipa;
    @ManyToOne
    @JoinColumn(name = "id_equipa", referencedColumnName = "id_equipa", insertable = false, updatable = false)
    private EquipaEntity equipaByIdEquipa;

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Integer idEquipa) {
        this.idEquipa = idEquipa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogadorEntity that = (JogadorEntity) o;
        return idJogador == that.idJogador && Objects.equals(nome, that.nome) && Objects.equals(idEquipa, that.idEquipa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogador, nome, idEquipa);
    }

    public EquipaEntity getEquipaByIdEquipa() {
        return equipaByIdEquipa;
    }

    public void setEquipaByIdEquipa(EquipaEntity equipaByIdEquipa) {
        this.equipaByIdEquipa = equipaByIdEquipa;
    }
}
