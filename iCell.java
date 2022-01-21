package com.company;

public interface iCell {
    boolean isAlive();
    int row();
    int col();
    void update();
    void determine();
}
