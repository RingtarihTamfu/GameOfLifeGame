package com.company;

public interface iCellFactory {
    public iCell Make(Grid parent, int row, int col, boolean c);
}
