package com.example.proj2dal.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class ReporterFavoritosEntityPK implements Serializable {
    private BigInteger idReporter;
    private BigInteger idFavoritos;

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


}
