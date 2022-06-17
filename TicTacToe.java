package com.homeproject.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    Random random;
    Scanner scanner;
    char[][] field;

    TicTacToe() {
        field = new char[3][3];
        random = new Random();
        scanner = new Scanner(System.in);

    }

    public static void main(String[] args) {
        new TicTacToe().game();

    }

    void game() {
        System.out.println("Game is started!");
        initField();
        printField();

        while (true) {
            turnHuman();
            if (checkWin('x')) {
                System.out.println("YOU WON!");
                break;
            }

            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }
            turnAI();
            printField();
            if (checkWin('o')) {
                System.out.println("AI WON!");
                break;
            }
        }

    }


    boolean isFieldFull() {
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(field[x][y] == '.') return false;
            }
        }
        return true;
    }

    private boolean checkWin(char symbol) {
        if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol) return true;
        if (field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol) return true;
        if (field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) return true;

        if(field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) return true;
        if(field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol) return true;
        if(field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) return true;

        if(field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) return true;
        if(field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) return true;


        return false;
    }
    void turnHuman() {
        int x, y;


            System.out.println("Enter x y from [0..2]");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if(isCellValid(x, y)) field[x][y] = 'x';
            else  turnHuman();
    }

    boolean isCellValid(int x, int y) {
        if(x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return field[x][y] == '.';
    }
    void turnAI() {
        int x, y;

            x = random.nextInt(3);
            y = random.nextInt(3);
        if(isCellValid(x, y)) field [x][y] = 'o';
    }

    void initField() {
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                field[x][y] = '.';
            }
        }

    }

    void printField(){
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                System.out.print(field[x][y] + " ");
            }
            System.out.println();
        }

    }

}


