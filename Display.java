package com.company;

import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Display {
    public static void Show(boolean[][] state, char alive, char dead, String title){
        System.out.println(title);
        for (boolean[] r : state){
            for (boolean x : r){
                System.out.println( (x) ? alive : dead);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean[][] MakeState(String[] s, char alive){
        boolean[][] state = new boolean[s.length][s[0].length()];
        for (int r=0; r<s.length; r++){
            for (int c=0; c<s[0].length(); c++){
                state[r][c] = s[r].charAt(c) == alive;
            }
        }
        return state;
    }

    public static Object[] ReadFile(String FileName, char alive) throws FileNotFoundException {
        String[] s = new String[20];
        Scanner scanner = new Scanner(new File(FileName));
        for (int r=0; r<20; r++){
            s[r] = scanner.next();
        }
        int gens = scanner.nextInt();
        return new Object[] {
                MakeState(s, alive), gens
        };
    }
}
