package com.example.proj2dal.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "arbitragem", schema = "public", catalog = "projeto")
public class ArbitragemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_arbitragem", nullable = false)
    private int idArbitragem;
    @Basic
    @Column(name = "id_arbitro1", nullable = false)
    private int idArbitro1;
    @Basic
    @Column(name = "id_arbitro2", nullable = false)
    private int idArbitro2;
    @Basic
    @Column(name = "id_arbitro3", nullable = false)
    private int idArbitro3;
    @ManyToOne
    @JoinColumn(name = "id_arbitro1", referencedColumnName = "id_arbitro", nullable = false, insertable = false, updatable = false)
    private ArbitroEntity arbitroByIdArbitro1;
    @ManyToOne
    @JoinColumn(name = "id_arbitro2", referencedColumnName = "id_arbitro", nullable = false, insertable = false, updatable = false)
    private ArbitroEntity arbitroByIdArbitro2;
    @ManyToOne
    @JoinColumn(name = "id_arbitro3", referencedColumnName = "id_arbitro", nullable = false, insertable = false, updatable = false)
    private ArbitroEntity arbitroByIdArbitro3;

    public int getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(int idArbitragem) {
        this.idArbitragem = idArbitragem;
    }

    public int getIdArbitro1() {
        return idArbitro1;
    }

    public void setIdArbitro1(int idArbitro1) {
        this.idArbitro1 = idArbitro1;
    }

    public int getIdArbitro2() {
        return idArbitro2;
    }

    public void setIdArbitro2(int idArbitro2) {
        this.idArbitro2 = idArbitro2;
    }

    public int getIdArbitro3() {
        return idArbitro3;
    }

    public void setIdArbitro3(int idArbitro3) {
        this.idArbitro3 = idArbitro3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArbitragemEntity that = (ArbitragemEntity) o;
        return idArbitragem == that.idArbitragem && idArbitro1 == that.idArbitro1 && idArbitro2 == that.idArbitro2 && idArbitro3 == that.idArbitro3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArbitragem, idArbitro1, idArbitro2, idArbitro3);
    }

    public ArbitroEntity getArbitroByIdArbitro1() {
        return arbitroByIdArbitro1;
    }

    public void setArbitroByIdArbitro1(ArbitroEntity arbitroByIdArbitro1) {
        this.arbitroByIdArbitro1 = arbitroByIdArbitro1;
    }

    public ArbitroEntity getArbitroByIdArbitro2() {
        return arbitroByIdArbitro2;
    }

    public void setArbitroByIdArbitro2(ArbitroEntity arbitroByIdArbitro2) {
        this.arbitroByIdArbitro2 = arbitroByIdArbitro2;
    }

    public ArbitroEntity getArbitroByIdArbitro3() {
        return arbitroByIdArbitro3;
    }

    public void setArbitroByIdArbitro3(ArbitroEntity arbitroByIdArbitro3) {
        this.arbitroByIdArbitro3 = arbitroByIdArbitro3;
    }
}
