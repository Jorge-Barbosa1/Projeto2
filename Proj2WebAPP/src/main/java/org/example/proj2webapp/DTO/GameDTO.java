package org.example.proj2webapp.DTO;

import java.math.BigInteger;

public class GameDTO {
    private BigInteger idGame;
    private Integer team1Name;
    private Integer  team2Name;
    private Integer fieldName;
    private String time;

    public GameDTO(BigInteger idGame, Integer team1Name, String time, Integer team2Name, Integer fieldName) {
        this.idGame = idGame;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.fieldName = fieldName;
        this.time = time;
    }
    public BigInteger getIdGame() {
        return idGame;
    }

    public void setIdGame(BigInteger idGame) {
        this.idGame = idGame;
    }

    public Integer getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(Integer team1Name) {
        this.team1Name = team1Name;
    }

    public Integer getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(Integer team2Name) {
        this.team2Name = team2Name;
    }

    public Integer getFieldName() {
        return fieldName;
    }

    public void setFieldName(Integer fieldName) {
        this.fieldName = fieldName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}


