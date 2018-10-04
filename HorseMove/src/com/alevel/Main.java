package com.alevel;

public class Main {


    public static void main(String[] args) {
        int a = 2, b = 4, a1 = 6, b1 = 7;
        if(HorseMove(a, b, a1, b1))
            System.out.println("Horse can move from [" + a + "][" + b + "]  to [" + a1 + "][" + b1 + "!");
        else
            System.out.println("Horse can't move from [" + a + "]["+ b + "] to [" + a1 + "][" + b1 + "]!");

    }

    public static boolean HorseMove(int a, int b, int a1, int b1) {
        if(b1 < 8 && a1 < 8) {
            if (b1 - 2 == b || b1 + 2 == b) {
                if (a1 + 1 == a)
                    return true;
                else if (a1 - 1 == a)
                    return true;
                else
                    return false;
            }
            if (b1 - 1 == b || b1 + 1 == b) {
                if (a1 + 2 == a)
                    return true;
                else if (a1 - 2 == a)
                    return true;
                else
                    return false;
            } else return false;
        } else {
            System.out.println("Error! Invalid coordinates! Try again!");
            return false;
        }
    }
}