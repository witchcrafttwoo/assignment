import java.util.Scanner; // Scannerを使用する準備

class Ens65_1 {
    public static void main(String[] args) { // throws宣言は不要（Scannerは例外が発生しない）
        Scanner scanner = new Scanner(System.in); // Scannerの変数を作成

        System.out.print("配列のサイズを入力してください: ");
        int arraySize = __________; // ① int型の入力を受け取る
        
        // 入力されたサイズでint型配列を宣言
        int[] numbers = new int[arraySize];

        System.out.println(arraySize + "個の数値を入力してください:");

        // ループを使って、各要素に数値を入力
        for (int i = 0; i < arraySize; ) {
            if (scanner.__________) { // ② 入力をチェック
                numbers[i] = __________; // ③ Scannerでint型の入力を受け取って配列に代入
                i++; // 入力が正しければ次へ
            } else {
                System.out.println("整数を入力してください。");
                scanner.next(); // 無効な入力を読み飛ばす
            }
        }

        // 配列の内容を表示
        System.out.println("入力された数値は:"); 



        


        scanner.close(); // Scannerを閉じる
    }
}
