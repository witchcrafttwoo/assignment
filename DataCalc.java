class DataCalc{
    public static void main(String[] args) {
        // 1. 売上データの定義
        String[][] salesData = {
            {"Laptop", "Electronics", "1200"},
            {"Java Book", "Books", "45"},
            {"Smartphone", "Electronics", "800"},
            {"Science Fiction", "Books", "30"},
            {"Tablet", "Electronics", "500"},
            {"C++ Book", "Books", "60"}
        };

        // 2. カテゴリ別合計売上の格納用配列
        // "Electronics"と"Books"の2つのカテゴリの合計を格納
        String[] categoryTotals = new String[80];

        // 3. 合計金額の初期化
        double electronicsTotal = 0;
        double booksTotal = 0;

        // 4. 拡張forループでデータ処理
        for (String[] product : salesData) {
            // 5. カテゴリの判別と計算
            String category = product[1];
            String salesAmountStr = product[2];

            if (category.equals("Electronics")) {
                // 売上金額をdouble型に変換して加算
                electronicsTotal += Double.parseDouble(salesAmountStr);
            } else if (category.equals("Books")) {
                // 売上金額をdouble型に変換して加算
                booksTotal += Double.parseDouble(salesAmountStr);
            }
        }

        // 6. 結果を文字列に戻して配列に格納
        // Electronicsの合計
        categoryTotals[0] = String.valueOf(electronicsTotal);
        // Booksの合計
        categoryTotals[1] = String.valueOf(booksTotal);

        // 7. 結果の表示
        System.out.println("Electronicsの総売上: ¥" + categoryTotals[0]);
        System.out.println("Booksの総売上: ¥" + categoryTotals[1]);
    }
}
