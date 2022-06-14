import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a number (1 - 9):");
            int player1Pos = scan.nextInt();
            while(player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos)){
                System.out.println("Looks like your opponent beat you it. Enter a Different Position");
                player1Pos = scan.nextInt();

            }
            placeKeeper(gameBoard, player1Pos, "player 1");

            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int player2Pos = rand.nextInt(9) + 1;
            while(player1Positions.contains(player2Pos) || player2Positions.contains(player2Pos)){
                player2Pos = rand.nextInt(9) + 1;
            }
            placeKeeper(gameBoard,player2Pos,"player 2");
            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;

            }
            System.out.println(result);
        }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
    public static void placeKeeper(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player 1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("player 2")) {
            symbol = '0';
            player2Positions.add(pos);
        }
        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }

    }
    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftSide = Arrays.asList(1, 4, 7);
        List inSide = Arrays.asList(2, 5, 8);
        List rightSide = Arrays.asList(3, 6, 9);
        List lowUpcross = Arrays.asList(7, 5, 3);
        List upLowcross = Arrays.asList(1, 5, 9);

        List<List> winningRules = new ArrayList<List>();
        winningRules.add(topRow);
        winningRules.add(middleRow);
        winningRules.add(bottomRow);
        winningRules.add(leftSide);
        winningRules.add(inSide);
        winningRules.add(rightSide);
        winningRules.add(lowUpcross);
        winningRules.add(upLowcross);

        for(List l : winningRules) {
            if(player1Positions.containsAll(l)) {
                return "Winner !!!";
            } else if(player2Positions.containsAll(l)) {
                return "Nice try, you lose :(";
            }else if(player1Positions.size() + player2Positions.size() == 9) {
                return "Its a Tie!";
            }
        }
        return "";

    }
}
