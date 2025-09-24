import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner; // 文字コード指定のため

public class SalesDataDisplayG {

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

        // データ行を表示 (インデックスベース)
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < maxColCount; j++) {
                // nullチェックと整形
                System.out.printf("%-15s", (salesData[i][j] != null ? salesData[i][j] : ""));
            }
            System.out.println();
        }
        String[][] goukei =new String[10][10];
        goukei[0][0]= "p001";
        goukei[0][1]= "0";
        for(int i=0;i<rowCount;i++){
            String projectId = salesData[i][0];
            double price =Double.parseDouble(salesData[i][3].trim());
            double kazu = Double.parseDouble(salesData[i][4].trim());
            double amount = kazu * price ;
            if(projectId.equalsIgnoreCase("P001")){
                String cra = goukei[0][1];
                double result = Double.parseDouble(cra)+amount;
                goukei[0][1] = String.valueOf(result);
            }
        }

        System.out.printf("商品id: %-10s の合計金額: %-10s\n ",(goukei[0][0]),(goukei[0][1]));
    }
}