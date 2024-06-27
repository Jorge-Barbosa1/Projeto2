package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "favoritos", schema = "public", catalog = "projeto")
public class FavoritosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_favoritos", nullable = false, precision = 0)
    private BigInteger idFavoritos;
    @Basic
    @Column(name = "equipa", nullable = false, length = 100)
    private String equipa;
    @Basic
    @Column(name = "jogadores", nullable = false, length = 100)
    private String jogadores;
    @OneToMany(mappedBy = "favoritosByIdFavoritos")
    private Collection<ReporterFavoritosEntity> reporterFavoritosByIdFavoritos;

    public BigInteger getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(BigInteger idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public String getJogadores() {
        return jogadores;
    }

    public void setJogadores(String jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritosEntity that = (FavoritosEntity) o;
        return Objects.equals(idFavoritos, that.idFavoritos) && Objects.equals(equipa, that.equipa) && Objects.equals(jogadores, that.jogadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavoritos, equipa, jogadores);
    }

    public Collection<ReporterFavoritosEntity> getReporterFavoritosByIdFavoritos() {
        return reporterFavoritosByIdFavoritos;
    }

    public void setReporterFavoritosByIdFavoritos(Collection<ReporterFavoritosEntity> reporterFavoritosByIdFavoritos) {
        this.reporterFavoritosByIdFavoritos = reporterFavoritosByIdFavoritos;
    }
}
