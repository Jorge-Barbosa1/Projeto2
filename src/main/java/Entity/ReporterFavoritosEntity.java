package Entity;

import jakarta.persistence.Entity;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "reporter_favoritos", schema = "public", catalog = "projeto")
@jakarta.persistence.IdClass(ReporterFavoritosEntityPK.class)
public class ReporterFavoritosEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id_reporter")
    private BigInteger idReporter;

    public BigInteger getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(BigInteger idReporter) {
        this.idReporter = idReporter;
    }

    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id_favoritos")
    private BigInteger idFavoritos;

    public BigInteger getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(BigInteger idFavoritos) {
        this.idFavoritos = idFavoritos;
    }
}
