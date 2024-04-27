package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "favoritos", schema = "public", catalog = "projeto")
public class FavoritosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_favoritos")
    private BigInteger idFavoritos;

    public BigInteger getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(BigInteger idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    @Basic
    @Column(name = "equipa")
    private String equipa;

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    @Basic
    @Column(name = "jogadores")
    private String jogadores;

    public String getJogadores() {
        return jogadores;
    }

    public void setJogadores(String jogadores) {
        this.jogadores = jogadores;
    }
}
