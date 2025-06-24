import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner; // 文字コード指定のため

public class SalesDataDisplay {

    // mainメソッドがFileNotFoundExceptionをスローする可能性を宣言
    public static void main(String[] args) throws Exception {

        int rowCount = 0; // 行数をカウントする変数
        int maxColCount = 0; // 最大列数をカウントする変数

        // --- 最初のパス: 行数と最大列数をカウント ---
        //
        File fileForCount = new File("./data.csv"); // ファイルを指定
        Scanner scanner = new Scanner(fileForCount, "UTF-8"); // 文字コードをUTF-8に指定

        // ヘッダー行を読み飛ばす (カウントに含めない)
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // １行読み込んでヘッダー行を読み飛ばす
        }

        while (scanner.hasNextLine()) { // 次の行が存在する限りループ
            rowCount++;
            String line = scanner.nextLine(); // 行を読み込む
            String[] values = line.split(","); // CSVの区切り文字で分割して配列に格納
            if (values.length > maxColCount) { // 現在の行の列数が最大列数より大きい場合
                // 最大列数を更新
                maxColCount = values.length;
            }
        }
        scanner.close(); // Scannerを閉じる

        // 2次元配列を宣言 (ヘッダー行を除くデータ行のみ)
        String[][] salesData = new String[rowCount][maxColCount];
        int currentRow = 0; // データを格納する現在の行インデックス

        // --- 2番目のパス: データを2次元配列に格納 ---
        File fileForData = new File("./data.csv");
        Scanner scannerForData = new Scanner(fileForData, StandardCharsets.UTF_8.name()); // 文字コードをUTF-8に指定

        // ヘッダー行を読み飛ばす
        if (scannerForData.hasNextLine()) {
            scannerForData.nextLine();
        }

        while (scannerForData.hasNextLine()) { // 次の行が存在する限りループ
            String line = scannerForData.nextLine(); // 行を読み込む
            String[] values = line.split(","); // CSVの区切り文字で分割して配列に格納

            // 各行のデータを配列にコピー
            for (int j = 0; j < values.length; j++) {
                if (j < maxColCount) { // 配列の範囲を超えないようにチェック
                    salesData[currentRow][j] = values[j]; 
                }
            }
            currentRow++;  // 行を進める
        }
        scannerForData.close(); // Scannerを閉じる

        // --- 読み込んだ2次元配列の内容を表示 ---
        System.out.println("--- 架空の商品の売り上げデータ ---");

        // ヘッダーを表示 (手動で定義するか、最初のスキャンで取得することも可能)
        String[] headers = {"ProductID", "ProductName", "Category", "Price", "Quantity", "SaleDate", "Salesperson"};
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("%-15s", headers[i]); // 整形して表示
        }
        System.out.println("\n--------------------------------------------------------------------------------------------------");


            String[][] sumTable = new String[100][2]; // 合計表 [ProductID, 合計金額]
            int Count = 0; // 登録済みのProductID数
        // データ行を表示 (インデックスベース)
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < maxColCount; j++) {
                // nullチェックと整形
                System.out.printf("%-15s", (salesData[i][j] != null ? salesData[i][j] : ""));
            }
            System.out.println();
        }

        for(int i =0;i<rowCount;i++){
            String ProjectId = salesData[i][0];
            String priceStr = salesData[i][3];
            String kazuStr = salesData[i][4];

            double price = Double.parseDouble(priceStr.trim()); //Stringをdooubleに変換
            int quantity = Integer.parseInt(kazuStr.trim());//ここもおんなじ
            double amount = price * quantity;
            boolean found = false;
            for(int j =0;j<Count;j++){
                if(sumTable[j][0].equals(ProjectId)){
                    double currentTotal = Double.parseDouble(sumTable[j][1]);
                    sumTable[j][1] = String.valueOf(currentTotal + amount);//また文字列に戻すんやで
                        found = true;
                        break;
                }

            }
            if(!found){
                    sumTable[Count][0] = ProjectId;
                    sumTable[Count][1] = String.valueOf(amount);
                    Count++;
                }
        }
        for(int i = 0;i<Count;i++){
            String pid =sumTable[i][0];
            String amt =sumTable[i][1];
            System.out.printf("商品id: %-10s2f の合計金額: %s 円\n",pid,amt);
        }
    }
}