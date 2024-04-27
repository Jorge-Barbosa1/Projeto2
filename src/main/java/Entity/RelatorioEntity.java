package Entity;

import jakarta.persistence.Entity;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "relatorio", schema = "public", catalog = "projeto")
public class RelatorioEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id_relatorio")
    private BigInteger idRelatorio;

    public BigInteger getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(BigInteger idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "descricao")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "id_arbitragem")
    private Integer idArbitragem;

    public Integer getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(Integer idArbitragem) {
        this.idArbitragem = idArbitragem;
    }
}
