package Entity;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "equipa", schema = "public", catalog = "projeto")
public class EquipaEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id_equipa")
    private int idEquipa;

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
