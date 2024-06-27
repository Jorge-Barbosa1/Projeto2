package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "reporter_favoritos", schema = "public", catalog = "projeto")
@IdClass(ReporterFavoritosEntityPK.class)
public class ReporterFavoritosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reporter", nullable = false, precision = 0)
    private BigInteger idReporter;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_favoritos", nullable = false, precision = 0)
    private BigInteger idFavoritos;
    @ManyToOne
    @JoinColumn(name = "id_reporter", referencedColumnName = "id_reporter", nullable = false, insertable = false, updatable = false)
    private ReporterEntity reporterByIdReporter;
    @ManyToOne
    @JoinColumn(name = "id_favoritos", referencedColumnName = "id_favoritos", nullable = false, insertable = false, updatable = false)
    private FavoritosEntity favoritosByIdFavoritos;

    public BigInteger getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(BigInteger idReporter) {
        this.idReporter = idReporter;
    }

    public BigInteger getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(BigInteger idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public ReporterEntity getReporterByIdReporter() {
        return reporterByIdReporter;
    }

    public void setReporterByIdReporter(ReporterEntity reporterByIdReporter) {
        this.reporterByIdReporter = reporterByIdReporter;
    }

    public FavoritosEntity getFavoritosByIdFavoritos() {
        return favoritosByIdFavoritos;
    }

    public void setFavoritosByIdFavoritos(FavoritosEntity favoritosByIdFavoritos) {
        this.favoritosByIdFavoritos = favoritosByIdFavoritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReporterFavoritosEntity that = (ReporterFavoritosEntity) o;
        return Objects.equals(idReporter, that.idReporter) && Objects.equals(idFavoritos, that.idFavoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporter, idFavoritos);
    }
}
