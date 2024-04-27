package Entity;

import java.io.Serializable;
import java.math.BigInteger;

public class ReporterFavoritosEntityPK implements Serializable {
    private BigInteger idReporter;
    private BigInteger idFavoritos;

    public BigInteger getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(BigInteger idReporter) {
        this.idReporter = idReporter;
    }

    public BigInteger getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(BigInteger idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReporterFavoritosEntityPK that = (ReporterFavoritosEntityPK) o;

        if (idReporter != null ? !idReporter.equals(that.idReporter) : that.idReporter != null) return false;
        return idFavoritos != null ? idFavoritos.equals(that.idFavoritos) : that.idFavoritos == null;
    }

    @Override
    public int hashCode() {
        int result = idReporter != null ? idReporter.hashCode() : 0;
        result = 31 * result + (idFavoritos != null ? idFavoritos.hashCode() : 0);
        return result;
    }
}
