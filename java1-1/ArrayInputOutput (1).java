import java.util.Scanner; // Scannerクラスを使用するために必要

class ArrayInputOutput {

    public static void main(String[] args) {
        // 1. 整数型で10個の要素を持つ配列 `numbers` を宣言し、初期化する
        int[] numbers = new int[10];

        // Scannerの変数を作成し、ユーザーからの入力を受け取れるようにする
        Scanner sc = new Scanner(System.in);

        // 2. ユーザーに要素番号と値を入力させ、配列に格納するループを作成
        //    無効な要素番号が入力された場合はエラーメッセージを表示し、再入力を促すのではなく、その入力処理をスキップしてください。
        while (true) { // 無限ループで入力処理を繰り返す
            System.out.print("値を代入する要素番号（0～9）を入力してください。終了する場合は-1を入力: ");
            int index = sc.nextInt();
             // 要素番号の入力

            if (index == -1) { // -1が入力されたらループを終了
                System.out.println("入力処理を終了します。");
                break;
            }

            // 3. 入力された要素番号が配列の有効な範囲内にあるかチェック
            if (index >= 0 && index < numbers.length) { 
                System.out.print("要素に代入する整数値を入力してください: ");
                int value = sc.nextInt();  // 値の入力
                numbers[index] = value; // 配列に値を代入
                System.out.println("値を代入しました。");
            } else {
                System.out.println("エラー: 無効な要素番号です。0から9の範囲で入力してください。");
            }
            System.out.println("---"); // 区切り線
        }

        System.out.println("\n--- 配列の全要素を出力します ---");

        // 4. forループを使って配列 `numbers` の全要素を順番に表示してください。
        //    ループカウンタ変数 `i` を利用して、配列の添字（インデックス）を0から末尾まで走査します。
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "]: " + numbers[i]);
        }

        sc.close();; // Scannerを閉じる
    }
}
