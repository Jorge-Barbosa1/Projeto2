package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "arbitro", schema = "public", catalog = "projeto")
public class ArbitroEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_arbitro", nullable = false)
    private int idArbitro;
    @Basic
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;
    @OneToMany(mappedBy = "arbitroByIdArbitro1")
    private Collection<ArbitragemEntity> arbitragemsByIdArbitro;
    @OneToMany(mappedBy = "arbitroByIdArbitro2")
    private Collection<ArbitragemEntity> arbitragemsByIdArbitro_0;
    @OneToMany(mappedBy = "arbitroByIdArbitro3")
    private Collection<ArbitragemEntity> arbitragemsByIdArbitro_1;

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArbitroEntity that = (ArbitroEntity) o;
        return idArbitro == that.idArbitro && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArbitro, nome);
    }

    public Collection<ArbitragemEntity> getArbitragemsByIdArbitro() {
        return arbitragemsByIdArbitro;
    }

    public void setArbitragemsByIdArbitro(Collection<ArbitragemEntity> arbitragemsByIdArbitro) {
        this.arbitragemsByIdArbitro = arbitragemsByIdArbitro;
    }

    public Collection<ArbitragemEntity> getArbitragemsByIdArbitro_0() {
        return arbitragemsByIdArbitro_0;
    }

    public void setArbitragemsByIdArbitro_0(Collection<ArbitragemEntity> arbitragemsByIdArbitro_0) {
        this.arbitragemsByIdArbitro_0 = arbitragemsByIdArbitro_0;
    }

    public Collection<ArbitragemEntity> getArbitragemsByIdArbitro_1() {
        return arbitragemsByIdArbitro_1;
    }

    public void setArbitragemsByIdArbitro_1(Collection<ArbitragemEntity> arbitragemsByIdArbitro_1) {
        this.arbitragemsByIdArbitro_1 = arbitragemsByIdArbitro_1;
    }
}
