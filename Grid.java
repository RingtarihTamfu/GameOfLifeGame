package com.company;

import java.util.*;

public class Grid implements Iterable<iCell> {
    private iCell[][] board;
    private int rows, cols;

    public Grid(boolean[][] start, iCellFactory cf) {
        rows = start.length;
        cols = start[0].length;
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                board[r][c] = cf.Make(this, r, c, start[r][c]);
            }
        }
    }

    public boolean[][] State(){
        boolean[][] state = new boolean[rows][cols];
        for (iCell c: this){
            state[c.row()][c.col()] = c.isAlive();
        }
        return state;
    }

    public iCell CellAt(int r, int c){
        return(r >= 0 && r < rows && c >= 0 && c < cols) ? board[r][c]:null;
    }

    public void OneGen() {
        for (iCell cell: this) cell.determine();
        for (iCell cell: this) cell.update();
    }

    public void Update(int Generations){
        for (int i=0; i<Generations; ++i){
            OneGen();
        }
    }

    public Iterator<iCell> iterator() {
        return new GridIterator();
    }

    class GridIterator implements Iterator<iCell> {
        private int r=0, c=0;
        public boolean hasNext() {
            return (r < rows) && (c < cols);
        }
        public iCell next() {
            if (!hasNext()) {
                return null;
            }
            iCell cell = board[r][c];
            c++;
            if (c >= cols) {
                c = 0;
                r++;
            }
            return cell;
        }
    }
}
