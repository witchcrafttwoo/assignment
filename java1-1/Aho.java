import java.util.Scanner;


public class Aho{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("2桁の数を打ち込んで下さい");
        String str = scanner.nextLine();
        if (str.contains("3")) {
            System.out.println("あほになります");
        }else{
            System.out.println("3を含んだ数を入力してね");
        }
    }
}