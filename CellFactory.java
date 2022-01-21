package com.company;

public class CellFactory implements iCellFactory {
    public Cell Make(Grid parent, int row, int col, boolean alive) {
        return new Cell(parent, row, col, alive);
    }
}
