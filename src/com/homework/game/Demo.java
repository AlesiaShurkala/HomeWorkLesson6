package com.homework.game;

import java.util.Scanner;

public class Demo {
    public static final int EMPTY=0;
    public static final int ZERO=-1;
    public static final int CROSS=1;

    public static void main(String[] args) {
        int[][] table = createTable();
        int user=CROSS;
        while (true){
            System.out.println("Пользователь введи координату: ");
            Scanner scanner = new Scanner(System.in);
            int x=scanner.nextInt() -1;
            int y=scanner.nextInt() -1;
            int result=checkTable(table, x,y,user);
            print(table);
            if (result==-1){
                System.out.println("Введите новое число:");
            } else if (result==1){
                System.out.println("Вы выиграли!:");
                break;
            }else if (result==2){
                System.out.println("Ничья!:");
                break;
            }else{ user=user*-1;}

        }

    }

    public static int [][] createTable() {
        int [][] table=new int[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j]=EMPTY;
            }
        }
        return table;
    }

    private static int checkTable(int [][] table, int x, int y, int sign){
        if (table[x][y]!=EMPTY){
            return -1;
        }
        table[x][y] = sign;
        int mainDiagonalCnt = 0;
        int addDiagonalCnt = 0;
        int emptyCount = 0;
        for (int i = 0; i < table.length; i++) {
            int rowCount =0;
            int columnCount =0;

            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == sign ) {
                    rowCount++;
                }

                if (table[j][i] == sign ) {
                    columnCount++;
                }
                if (table[i][j]==EMPTY){
                    emptyCount++;
                }
                if( i == j && table[i][j] == sign)  {
                    mainDiagonalCnt++;
                }

                if(i + j == table.length -1 && table[i][j] == sign) {
                    addDiagonalCnt++;
                }
            }

            if(rowCount == 3 || columnCount == 3 || mainDiagonalCnt == 3 || addDiagonalCnt == 3) {
                return 1;
            }
        }
        if (emptyCount==0){
            return 2;
        }
        return 0;
    }

    private static void print (int [][] table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j]==CROSS){
                    System.out.print("x");
                }else if (table[i][j]==ZERO){
                    System.out.print("o");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
