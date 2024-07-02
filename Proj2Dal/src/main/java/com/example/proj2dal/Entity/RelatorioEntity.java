package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "relatorio", schema = "public", catalog = "projeto")
public class RelatorioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_relatorio", nullable = false, precision = 0)
    private BigInteger idRelatorio;
    @Basic
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    @Basic
    @Column(name = "id_jogo", nullable = true)
    private BigInteger idJogo;
    @OneToMany(mappedBy = "relatorioByIdRelatorio")
    private Collection<JogoRelatorioEntity> jogoRelatoriosByIdRelatorio;

    public BigInteger getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(BigInteger idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }
}
