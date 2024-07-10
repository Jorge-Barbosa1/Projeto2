package org.example.proj2webapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
public class TeamDTO {
    private Integer id_equipa;
    @Getter
    private String nome;


    public TeamDTO(Integer id_equipa, String nome) {
        this.id_equipa = id_equipa;
        this.nome = nome;
    }

    public Integer getIdEquipa() {
        return id_equipa;
    }

}
