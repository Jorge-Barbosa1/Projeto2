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
    @Column(name = "id_arbitragem", nullable = true)
    private Integer idArbitragem;
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

    public Integer getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(Integer idArbitragem) {
        this.idArbitragem = idArbitragem;
    }

    public Collection<JogoRelatorioEntity> getJogoRelatoriosByIdRelatorio() {
        return jogoRelatoriosByIdRelatorio;
    }

    public void setJogoRelatoriosByIdRelatorio(Collection<JogoRelatorioEntity> jogoRelatoriosByIdRelatorio) {
        this.jogoRelatoriosByIdRelatorio = jogoRelatoriosByIdRelatorio;
    }


}
