package Entity;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "jogador", schema = "public", catalog = "projeto")
public class JogadorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_jogador")
    private int idJogador;

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
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
    @Column(name = "id_contactos")
    private Integer idContactos;

    public Integer getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(Integer idContactos) {
        this.idContactos = idContactos;
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
}
