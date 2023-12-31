import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class MineSweeper {
    int row;
    int column;
    String[][] meinMap;
    String[][] gameBoard;
    int gameRow;
    int gameColumn;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    // Constructor to initialize the MineSweeper object with given dimensions
    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.meinMap = new String[row][column];
        this.gameBoard = new String[row][column];

    }
    // Method to start the game
    public void play() {
        arraysFill(); // Fill the mine map and game board
        addStar(); // Add mines to the mine map
       // printMeinMap(meinMap); // Print the mine map for reference
        printGameBoard(gameBoard); // Print the initial state of the game board
        gameStart(); // Start the game

    }
    // Method to fill the mine map and game board with default values
    public void arraysFill(){
        for (int i = 0; i < row; i++) {
            for (int j= 0; j< column; j++){
                meinMap[i][j] = " - ";
                gameBoard[i][j] = " - ";
            }
        }
    }
    // Method to randomly add mines to the mine map
    public void addStar() {      //Değerlendirme Formu 8
        int randomRow;
        int randomColumn;
        int starSize = 0;
        for (int i = 0; starSize < ((row * column) / 4); i++) {
            randomRow = rand.nextInt(row);
            randomColumn = rand.nextInt(column);
            if (!meinMap[randomRow][randomColumn].equals(" * ")){
                meinMap[randomRow][randomColumn] = " * ";
                starSize++;
            }
        }
    }
    // Method to print the mine map
    public void printMeinMap(String[][] meinMap) {
        System.out.println("Mayın Haritası");
        for (int i = 0; i < meinMap.length; i++) {
            for (int j = 0; j < meinMap[0].length; j++) {
                if ( meinMap[i][j].equals(" * ")) {
                    System.out.print(" * ");
                }else {
                    System.out.print(meinMap[i][j]);
                }
            }
            System.out.println();
        }
    }
    // Method to print the game board
    public void printGameBoard(String[][] gameBoard) {
        System.out.println("Oyun Alanı");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[i][j].equals(" - ")) {
                    System.out.print(gameBoard[i][j]);
                }else if(gameBoard[i][j].equals(" * ")){
                    System.out.print(" * ");
                }else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    // Method to handle the player's moves and determine the game outcome
    public void gameStart(){
        boolean isRun = false;
        int move = 0;

        while(!isRun){
            System.out.print("Lütfen satır numarası giriniz: ");     //Değerlendirme Formu 9
            gameRow = input.nextInt();
            System.out.print("Lütfen sütun numarası giriniz: ");
            gameColumn = input.nextInt();


            if (gameRow >= row || gameRow < 0 || gameColumn >= column || gameColumn < 0){  //Değerlendirme Formu 10
                System.out.println("Lütfen oyun alanı içerisinde bir konum giriniz.");

            } else if(!gameBoard[gameRow][gameColumn].equals(" - ") && !gameBoard[gameRow][gameColumn].equals(" * ")  ) {
                System.out.println("Bu koordinatları daha önce girdiniz. Lütfen yeni koordinat giriniz.");

            } else if(meinMap[gameRow][gameColumn].equals(" - ")){        //Değerlendirme Formu 12
                gameBoard[gameRow][gameColumn] =  " " + String.valueOf(checkValueOfCoord()) ;
                move++;
                if ( move == ((row * column) - ((row * column) / 4))) {   //Değerlendirme Formu 14
                    System.out.println("Tebrikler! Hiçbir mayına basmadınız ve oyunu kazandınız!");
                    break;
                }

            } else if(meinMap[gameRow][gameColumn].equals(" * ")){        //Değerlendirme Formu 13
                System.out.println("Mayına Bastınız. Oyunu kaybettiniz.");
                printMeinMap(meinMap);
                isRun = true;
                break;
            }
            printGameBoard(gameBoard);
        }
    }
    // Method to check the value of the coordinates on the mine map
    public  int checkValueOfCoord(){
        int count = 0;
        for (int i = (gameRow - 1); i <= (gameRow + 1); i++) {
            for (int j = (gameColumn - 1); j <= (gameColumn + 1); j++) {
                if (i < 0 || j < 0 || i >= row || j >= column) {
                    continue;
                }
                if (meinMap[i][j] == " * ") {
                    count++;
                }
            }
        }
        return count;
    }
}













