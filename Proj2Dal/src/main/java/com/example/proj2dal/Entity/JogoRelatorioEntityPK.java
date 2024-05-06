package com.example.proj2dal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class JogoRelatorioEntityPK implements Serializable {
    @Column(name = "id_jogo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idJogo;
    @Column(name = "id_relatorio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idRelatorio;

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }

    public BigInteger getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(BigInteger idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoRelatorioEntityPK that = (JogoRelatorioEntityPK) o;
        return Objects.equals(idJogo, that.idJogo) && Objects.equals(idRelatorio, that.idRelatorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idRelatorio);
    }
}
