package com.company.model;


public class GameUser {
    private String userName;
    private int position;
    private boolean isWinner;

    public GameUser(String userName, int position, boolean isWinner) {
        this.userName = userName;
        this.position = position;
        this.isWinner = isWinner;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
