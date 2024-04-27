package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigInteger;

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

        if (idJogo != null ? !idJogo.equals(that.idJogo) : that.idJogo != null) return false;
        if (idRelatorio != null ? !idRelatorio.equals(that.idRelatorio) : that.idRelatorio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJogo != null ? idJogo.hashCode() : 0;
        result = 31 * result + (idRelatorio != null ? idRelatorio.hashCode() : 0);
        return result;
    }
}
