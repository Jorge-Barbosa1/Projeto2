package com.example.proj2ui.DTO;

import java.math.BigInteger;

public class GameInfo {
    private BigInteger idGame;
    private String team1Name;
    private String team2Name;
    private String fieldName;
    private String time;

    public GameInfo(BigInteger idGame, String team1Name, String time, String team2Name, String fieldName) {
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

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
