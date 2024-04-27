package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "jogo_relatorio", schema = "public", catalog = "projeto")
@IdClass(JogoRelatorioEntityPK.class)
public class JogoRelatorioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_jogo")
    private BigInteger idJogo;

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_relatorio")
    private BigInteger idRelatorio;

    public BigInteger getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(BigInteger idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    @Basic
    @Column(name = "resultado_casa")
    private BigInteger resultadoCasa;

    public BigInteger getResultadoCasa() {
        return resultadoCasa;
    }

    public void setResultadoCasa(BigInteger resultadoCasa) {
        this.resultadoCasa = resultadoCasa;
    }

    @Basic
    @Column(name = "resultado_visitante")
    private BigInteger resultadoVisitante;

    public BigInteger getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(BigInteger resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }
}
