import java.util.Scanner;

class MenuSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0; // ループを制御するために初期値を設定

        do {
            // 1. メニューの表示
            System.out.println("--- メニュー ---");
            System.out.println("1. 機能Aを実行");
            System.out.println("2. 機能Bを実行");
            System.out.println("9. 終了");
            System.out.print("選択してください > ");

            // 2. ユーザーからの入力受付と入力チェック
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();;

                // 3. 入力値に応じた処理の分岐
                if (choice == 1) {
                    System.out.println("機能Aが実行されました。");
                } else if (choice == 2) {
                    System.out.println("機能Bが実行されました。");
                } else if (choice == 9) {
                    System.out.println("プログラムを終了します。");
                } else {
                    System.out.println("無効な選択です。1, 2, 9のいずれかを入力してください。");
                }
            } else {
                // 数値以外の入力の場合の処理
                System.out.println("不正な入力です。数値を入力してください。");
                scanner.nextLine();
                choice = -1; // 無効な選択としてループを継続させるための値
            }

            System.out.println(); // 改行を入れて見やすくする

        } while (choice < 0);

        scanner.close(); // Scanner変数をクローズ
    }
}

