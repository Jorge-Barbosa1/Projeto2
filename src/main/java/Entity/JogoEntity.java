package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@jakarta.persistence.Table(name = "jogo", schema = "public", catalog = "projeto")
public class JogoEntity {
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

    @Basic
    @Column(name = "id_administrador")
    private BigInteger idAdministrador;

    public BigInteger getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(BigInteger idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Basic
    @Column(name = "data")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "hora")
    private String hora;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Basic
    @Column(name = "id_campo")
    private Integer idCampo;

    public Integer getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Integer idCampo) {
        this.idCampo = idCampo;
    }

    @Basic
    @Column(name = "id_equipa")
    private Integer idEquipa;

    public Integer getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Integer idEquipa) {
        this.idEquipa = idEquipa;
    }

    @Basic
    @Column(name = "id_arbitragem")
    private Integer idArbitragem;

    public Integer getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(Integer idArbitragem) {
        this.idArbitragem = idArbitragem;
    }
}
