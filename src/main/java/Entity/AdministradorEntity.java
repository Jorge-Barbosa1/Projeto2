package Entity;

import jakarta.persistence.Entity;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "administrador", schema = "public", catalog = "projeto")
public class AdministradorEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id_administrador")
    private BigInteger idAdministrador;

    public BigInteger getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(BigInteger idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "id_contactos")
    private BigInteger idContactos;

    public BigInteger getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(BigInteger idContactos) {
        this.idContactos = idContactos;
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
