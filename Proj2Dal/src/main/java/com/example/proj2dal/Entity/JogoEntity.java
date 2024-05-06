package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "jogo", schema = "public", catalog = "projeto")
public class JogoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_jogo", nullable = false, precision = 0)
    private BigInteger idJogo;
    @Basic
    @Column(name = "id_administrador", nullable = false, precision = 0)
    private BigInteger idAdministrador;
    @Basic
    @Column(name = "data", nullable = true)
    private Date data;
    @Basic
    @Column(name = "hora", nullable = true, length = 50)
    private String hora;
    @Basic
    @Column(name = "id_campo", nullable = true)
    private Integer idCampo;
    @Basic
    @Column(name = "id_equipa", nullable = true)
    private Integer idEquipa;
    @Basic
    @Column(name = "id_arbitragem", nullable = true)
    private Integer idArbitragem;
    @ManyToOne
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_administrador", nullable = false , insertable = false, updatable = false)
    private AdministradorEntity administradorByIdAdministrador;
    @OneToMany(mappedBy = "jogoByIdJogo")
    private Collection<JogoRelatorioEntity> jogoRelatoriosByIdJogo;
    @OneToMany(mappedBy = "jogoByIdJogo")
    private Collection<ReporterEntity> reportersByIdJogo;

    public BigInteger getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(BigInteger idJogo) {
        this.idJogo = idJogo;
    }

    public BigInteger getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(BigInteger idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Integer idCampo) {
        this.idCampo = idCampo;
    }

    public Integer getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Integer idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Integer getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(Integer idArbitragem) {
        this.idArbitragem = idArbitragem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoEntity that = (JogoEntity) o;
        return Objects.equals(idJogo, that.idJogo) && Objects.equals(idAdministrador, that.idAdministrador) && Objects.equals(data, that.data) && Objects.equals(hora, that.hora) && Objects.equals(idCampo, that.idCampo) && Objects.equals(idEquipa, that.idEquipa) && Objects.equals(idArbitragem, that.idArbitragem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idAdministrador, data, hora, idCampo, idEquipa, idArbitragem);
    }

    public AdministradorEntity getAdministradorByIdAdministrador() {
        return administradorByIdAdministrador;
    }

    public void setAdministradorByIdAdministrador(AdministradorEntity administradorByIdAdministrador) {
        this.administradorByIdAdministrador = administradorByIdAdministrador;
    }

    public Collection<JogoRelatorioEntity> getJogoRelatoriosByIdJogo() {
        return jogoRelatoriosByIdJogo;
    }

    public void setJogoRelatoriosByIdJogo(Collection<JogoRelatorioEntity> jogoRelatoriosByIdJogo) {
        this.jogoRelatoriosByIdJogo = jogoRelatoriosByIdJogo;
    }

    public Collection<ReporterEntity> getReportersByIdJogo() {
        return reportersByIdJogo;
    }

    public void setReportersByIdJogo(Collection<ReporterEntity> reportersByIdJogo) {
        this.reportersByIdJogo = reportersByIdJogo;
    }
}
