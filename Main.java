package com.company;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String FileName = "C:\\Users\\thatt\\Desktop\\Game of Life\\start.txt";

        Object[] returns = Display.ReadFile(FileName, 'X');
        boolean[][] FileState = (boolean[][]) returns[0];
        int gens = (int) returns[1];

        Grid G = new Grid(FileState, new CellFactory());
        Display.Show(G.State(), 'X', '.', "Start");

        G.Update(gens);
        Display.Show(G.State(), 'X', '.', "Finish");
    }
}
