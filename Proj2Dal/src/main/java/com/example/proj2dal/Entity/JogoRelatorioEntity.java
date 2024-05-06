package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "jogo_relatorio", schema = "public", catalog = "projeto")
@IdClass(JogoRelatorioEntityPK.class)
public class JogoRelatorioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_jogo", nullable = false, precision = 0)
    private BigInteger idJogo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_relatorio", nullable = false, precision = 0)
    private BigInteger idRelatorio;
    @Basic
    @Column(name = "resultado_casa", nullable = false, precision = 0)
    private BigInteger resultadoCasa;
    @Basic
    @Column(name = "resultado_visitante", nullable = false, precision = 0)
    private BigInteger resultadoVisitante;
    @ManyToOne
    @JoinColumn(name = "id_jogo", referencedColumnName = "id_jogo", nullable = false, insertable = false, updatable = false)
    private JogoEntity jogoByIdJogo;
    @ManyToOne
    @JoinColumn(name = "id_relatorio", referencedColumnName = "id_relatorio", nullable = false, insertable = false, updatable = false)
    private RelatorioEntity relatorioByIdRelatorio;

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

    public BigInteger getResultadoCasa() {
        return resultadoCasa;
    }

    public void setResultadoCasa(BigInteger resultadoCasa) {
        this.resultadoCasa = resultadoCasa;
    }

    public BigInteger getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(BigInteger resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoRelatorioEntity that = (JogoRelatorioEntity) o;
        return Objects.equals(idJogo, that.idJogo) && Objects.equals(idRelatorio, that.idRelatorio) && Objects.equals(resultadoCasa, that.resultadoCasa) && Objects.equals(resultadoVisitante, that.resultadoVisitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idRelatorio, resultadoCasa, resultadoVisitante);
    }

    public JogoEntity getJogoByIdJogo() {
        return jogoByIdJogo;
    }

    public void setJogoByIdJogo(JogoEntity jogoByIdJogo) {
        this.jogoByIdJogo = jogoByIdJogo;
    }

    public RelatorioEntity getRelatorioByIdRelatorio() {
        return relatorioByIdRelatorio;
    }

    public void setRelatorioByIdRelatorio(RelatorioEntity relatorioByIdRelatorio) {
        this.relatorioByIdRelatorio = relatorioByIdRelatorio;
    }
}
