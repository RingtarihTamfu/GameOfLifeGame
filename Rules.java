package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rules {
    public static boolean determine(boolean alive, int neighbors){
        return (alive && (neighbors == 2 || neighbors == 3))
                || (!alive && (neighbors == 3));
    }

    public static int liveNeighbors(Iterable<iCell> neighbors){
        int count = 0;
        for (iCell c : neighbors){
            if(c.isAlive()){
                count++;
            }
        }
        return count;
    }

    public static List<iCell> neighbors(Grid g, int r, int c){
        List<iCell> n = new ArrayList<>();
        AddIfNotNull(n, g.CellAt(r-1, c-1));
        AddIfNotNull(n, g.CellAt(r-1, c));
        AddIfNotNull(n, g.CellAt(r-1, c+1));
        AddIfNotNull(n, g.CellAt(r, c+1));
        AddIfNotNull(n, g.CellAt(r+1, c+1));
        AddIfNotNull(n, g.CellAt(r+1, c));
        AddIfNotNull(n, g.CellAt(r+1, c-1));
        AddIfNotNull(n, g.CellAt(r, c-1));
        return n;
    }

    private static void AddIfNotNull(List<iCell> l, iCell c){
        if(c!=null){
            l.add(c);
        }
    }
}
