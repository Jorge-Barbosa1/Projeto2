package Entity;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "campo", schema = "public", catalog = "projeto")
public class CampoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_campo")
    private int idCampo;

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    @Basic
    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "rua")
    private String rua;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Basic
    @Column(name = "freguesia")
    private String freguesia;

    public String getFreguesia() {
        return freguesia;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    @Basic
    @Column(name = "codpostal")
    private int codpostal;

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }
}
