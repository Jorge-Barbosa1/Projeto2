package org.example.proj2webapp.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayerDTO {
    private Integer idJogador;
    private String nome;
    private Integer IdEquipa;

    public PlayerDTO(Integer idJogador, String nome, Integer IdEquipa) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.IdEquipa = IdEquipa;
    }

}
