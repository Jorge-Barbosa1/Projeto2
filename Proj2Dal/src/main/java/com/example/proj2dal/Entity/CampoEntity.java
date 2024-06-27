package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "campo", schema = "public", catalog = "projeto")
public class CampoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_campo", nullable = false)
    private int idCampo;
    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "rua", nullable = false, length = 100)
    private String rua;
    @Basic
    @Column(name = "freguesia", nullable = false, length = 50)
    private String freguesia;
    @Basic
    @Column(name = "codpostal", nullable = false)
    private int codpostal;

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampoEntity that = (CampoEntity) o;
        return idCampo == that.idCampo && codpostal == that.codpostal && Objects.equals(nome, that.nome) && Objects.equals(rua, that.rua) && Objects.equals(freguesia, that.freguesia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCampo, nome, rua, freguesia, codpostal);
    }
}
