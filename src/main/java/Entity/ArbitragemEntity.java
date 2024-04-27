package Entity;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "arbitragem", schema = "public", catalog = "projeto")
public class ArbitragemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_arbitragem")
    private int idArbitragem;

    public int getIdArbitragem() {
        return idArbitragem;
    }

    public void setIdArbitragem(int idArbitragem) {
        this.idArbitragem = idArbitragem;
    }

    @Basic
    @Column(name = "id_arbitro1")
    private int idArbitro1;

    public int getIdArbitro1() {
        return idArbitro1;
    }

    public void setIdArbitro1(int idArbitro1) {
        this.idArbitro1 = idArbitro1;
    }

    @Basic
    @Column(name = "id_arbitro2")
    private int idArbitro2;

    public int getIdArbitro2() {
        return idArbitro2;
    }

    public void setIdArbitro2(int idArbitro2) {
        this.idArbitro2 = idArbitro2;
    }

    @Basic
    @Column(name = "id_arbitro3")
    private int idArbitro3;

    public int getIdArbitro3() {
        return idArbitro3;
    }

    public void setIdArbitro3(int idArbitro3) {
        this.idArbitro3 = idArbitro3;
    }
}
