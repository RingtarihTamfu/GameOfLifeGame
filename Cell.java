package com.company;

public class Cell implements iCell {
    private boolean _alive;
    private boolean _nextgen;
    private Grid _grid;
    private int _row;
    private int _col;
    public Cell(Grid parent, int row, int col, boolean alive){
        _row = row;
        _col = col;
        _grid = parent;
        _alive = alive;
    }

    public int row(){
        return _row;
    }
    public int col(){
        return _col;
    }
    public boolean isAlive(){
        return _alive;
    }
    public void update(){
        _alive = _nextgen;
    }
    public void determine(){
        Iterable<iCell> neighbors = Rules.neighbors(_grid, _row, _col);
        int liveNeighbors = Rules.liveNeighbors(neighbors);
        _nextgen = Rules.determine(_alive, liveNeighbors);
    }
}
