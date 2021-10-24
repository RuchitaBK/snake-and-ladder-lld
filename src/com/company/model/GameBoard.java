package com.company.model;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    int[][] board=new int[10][10];
    Map<Integer,Integer> ladder=new HashMap<>();
    Map<Integer,Integer> snake=new HashMap<>();

    public GameBoard(int[][] board, Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {
        this.board = board;
        this.ladder = ladder;
        this.snake = snake;
    }

    public GameBoard() {

    }


    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public Map<Integer, Integer> getLadder() {
        return ladder;
    }

    public void setLadder(Map<Integer, Integer> ladder) {
        this.ladder = ladder;
    }

    public Map<Integer, Integer> getSnake() {
        return snake;
    }

    public void setSnake(Map<Integer, Integer> snake) {
        this.snake = snake;
    }
}

