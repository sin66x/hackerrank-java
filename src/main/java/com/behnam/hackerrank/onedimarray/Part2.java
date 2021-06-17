package com.behnam.hackerrank.onedimarray;

import java.util.Scanner;

public class Part2 {
    public static boolean canWin(int leap, int[] game) {
        return move(leap,game,0);
    }

    public static boolean move(int leap, int[] game,int i){
        if(i<0||i>=game.length)
            return false;

        int n=game.length;
        if(game[i]!=0)
            return false;
        game[i]=1;
        if(i+leap>n-1||i==n-1)
            return true;
        if(move(leap,game,i+1) || move(leap,game,i+leap))
            return true;
        if(i!=0  && move(leap,game,i-1))
            return true;
        return false;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
