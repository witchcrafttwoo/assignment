import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesDataDisplayV2 {

    public static void main(String[] args) throws Exception {

        int rowCount = 0;
        int maxColCount = 0;

        // --- 行数と最大列数のカウント ---
        File fileForCount = new File("./data.csv");
        Scanner scanner = new Scanner(fileForCount, "UTF-8");

        if (scanner.hasNextLine()) {
            scanner.nextLine(); // ヘッダー行をスキップ
        }

        while (scanner.hasNextLine()) {
            rowCount++;
            String line = scanner.nextLine();
            String[] values = line.split(",");
            if (values.length > maxColCount) {
                maxColCount = values.length;
            }
        }
        scanner.close();

        // --- データの読み込み ---
        String[][] salesData = new String[rowCount][maxColCount];
        int currentRow = 0;
        Scanner scannerForData = new Scanner(fileForCount, StandardCharsets.UTF_8.name());

        if (scannerForData.hasNextLine()) {
            scannerForData.nextLine(); // ヘッダー行をスキップ
        }

        while (scannerForData.hasNextLine()) {
            String line = scannerForData.nextLine();
            String[] values = line.split(",");
            for (int j = 0; j < values.length; j++) {
                if (j < maxColCount) {
                    salesData[currentRow][j] = values[j];
                }
            }
            currentRow++;
        }
        scannerForData.close();

        // --- 表形式で表示 ---
        System.out.println("--- 架空の商品の売り上げデータ ---");
        String[] headers = {"ProductID", "ProductName", "Category", "Price", "Quantity", "SaleDate", "Salesperson"};
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("%-15s", headers[i]);
        }
        System.out.println("\n--------------------------------------------------------------------------------------------------");

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < maxColCount; j++) {
                System.out.printf("%-15s", (salesData[i][j] != null ? salesData[i][j] : ""));
            }
            System.out.println();
        }

        // treemapを使っての初期化
        Map<String, Double> totalAmountMap = new TreeMap<>();

        for (int i = 0; i < rowCount; i++) {
            String productId = salesData[i][0];
            String priceStr = salesData[i][3];
            String quantityStr = salesData[i][4];

            try {
                double price = Double.parseDouble(priceStr.trim());
                int quantity = Integer.parseInt(quantityStr.trim());
                double amount = price * quantity;

                // 合計に加算
                totalAmountMap.put(productId, totalAmountMap.getOrDefault(productId, 0.0) + amount);

            } catch (NumberFormatException e) {
                System.err.println("数値変換エラー（" + productId + "）： " + e.getMessage());
            }
        }

        // --- 合計金額の出力 ---
        System.out.println("\n--- ProductIDごとの合計売上金額 ---");
        for (Map.Entry<String, Double> entry : totalAmountMap.entrySet()) {
            System.out.printf("ProductID: %-10s → 合計金額: %.1f円\n", entry.getKey(), entry.getValue());
        }
    }
}
