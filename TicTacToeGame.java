package com.example.user.tictactoe;

import android.widget.Button;
import java.io.Serializable;

public class TicTacToeGame implements Serializable{
    Button[][] ticTacToe;
    int player;
    int computer;

    public TicTacToeGame(Button Square00, Button Square01, Button Square02, Button Square10,Button Square11, Button Square12, Button Square20,Button Square21, Button Square22){
        ticTacToe = new Button[3][3];
        player = 0;
        computer = 0;
        ticTacToe[0][0] = Square00; ticTacToe[0][1] = Square01; ticTacToe[0][2] = Square02;
        ticTacToe[1][0] = Square10; ticTacToe[1][1] = Square11; ticTacToe[1][2] = Square12;
        ticTacToe[2][0] = Square20; ticTacToe[2][1] = Square21; ticTacToe[2][2] = Square22;
        for(int i=0; i<9; i++){
            ticTacToe[i/3][i%3].setText("");
        }
    }

    public void allMove(Button Square){
        String str = checkWin(ticTacToe);
        if(str.equals("")) {
            playerMove(Square);
            str = checkWin(ticTacToe);
            if(str.equals("")) {
                if (player == computer + 1) {
                    computerMove();
                }
            }
        }
    }

    public void playerMove(Button Square){
        if(Square.getText().toString().equals("")) {
            Square.setText("X");
            player++;
        }
    }

    public void computerMove(){
        if(player < 5) {
            boolean found = false;
            while (found == false) {
                int i = (int) (Math.random() * 3);
                int j = (int) (Math.random() * 3);
                if (ticTacToe[i][j].getText().toString().equals("")) {
                    ticTacToe[i][j].setText("O");
                    computer++;
                    found = true;
                    return;
                }
            }
        }
    }


    public String checkWin(Button[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[0][i].getText().toString().equals(arr[1][i].getText().toString())){
                if (arr[1][i].getText().toString().equals(arr[2][i].getText().toString())){
                    if (!arr[0][i].getText().toString().equals("")) {
                        return arr[0][i].getText().toString();
                    }
                }
            }
            if(arr[i][0].getText().toString().equals(arr[i][1].getText().toString())){
                if (arr[i][1].getText().toString().equals(arr[i][2].getText().toString())) {
                    if (!arr[i][0].getText().toString().equals("")) {
                        return arr[i][0].getText().toString();
                    }
                }
            }
        }
        if(arr[0][0].getText().toString().equals(arr[1][1].getText().toString())){
            if (arr[1][1].getText().toString().equals(arr[2][2].getText().toString())) {
                if (!arr[0][0].getText().toString().equals("")) {
                    return arr[0][0].getText().toString();
                }
            }
        }
        if(arr[2][0].getText().toString().equals(arr[1][1].getText().toString())){
            if (arr[1][1].getText().toString().equals(arr[0][2].getText().toString())) {
                if (!arr[2][0].getText().toString().equals("")) {
                    return arr[2][0].getText().toString();
                }
            }
        }
        int count = 0;
        for(int i=0; i<9; i++){
            if(!arr[i/3][i%3].getText().toString().equals("")){
                count++;
            }
        }
        if(count == 9){
            return "Draw";
        }
        return "";
    }

    public void createNewGame(){
        for(int i=0; i<9; i++){
            ticTacToe[i/3][i%3].setText("");
        }
        player = 0;
        computer = 0;
        disable(true);
    }

    public void disable(boolean status){
        for(int i=0; i<9; i++){
            ticTacToe[i/3][i%3].setEnabled(status);
        }
    }
}
