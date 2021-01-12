package com.javarush.task.task22.task2213;

public class Tester {
    public static void main(String[] args) {
//        Field field = new Field(10, 20);
        Tetris.game = new Tetris(10, 20);
        for (int i = 0; i < 20; i++) {
            Tetris.game.getField().setValue(i, 2, 1);
            Tetris.game.getField().setValue(i, 4, 1);
            if (i%3==0){
                for (int j = 0; j < 20; j+=2) {
                    Tetris.game.getField().setValue(j, i, 1);
                }
            }
        }
        int[][] matrix = Tetris.game.getField().getMatrix();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println("result\n\n");
        Tetris.game.getField().removeFullLines();
        matrix = Tetris.game.getField().getMatrix();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
