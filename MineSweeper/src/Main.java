import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int row;
        int column;

        System.out.println("Mayın Tarlası Oyunu Başlatılıyor.");
        System.out.println("Oyunun satır ve sütun sayısını belirleyebilirsiniz."); //Değerlendirme Formu 7
        do {
            System.out.print("Satır sayısını giriniz (Minimum 2): ");
            row = input.nextInt();
            System.out.print("Sütun sayısını giriniz (Minimum 2): ");
            column = input.nextInt();
        }while (row < 2 || column < 2);

        MineSweeper mein = new MineSweeper(row,column);
        mein.play();

    }
}