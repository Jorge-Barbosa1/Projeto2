package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@jakarta.persistence.Table(name = "contactos", schema = "public", catalog = "projeto")
public class ContactosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_contactos")
    private BigInteger idContactos;

    public BigInteger getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(BigInteger idContactos) {
        this.idContactos = idContactos;
    }

    @Basic
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telefone")
    private BigInteger telefone;

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }
}
