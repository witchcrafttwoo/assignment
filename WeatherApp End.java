import java.util.Random; // 乱数生成のためにインポート

class WeatherApp {
    public static void main(String[] args) {
        Random random = new Random(); // 乱数生成器の変数を作成します
        
        // 1週間（7日間）分の気温を格納する配列
        int[] temperatures = new int[7]; 

        // 曜日表示のための配列
        String[] daysOfWeek = {"月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日"};

        System.out.println("--- 1週間分の天気予報 ---");

        // --- 1. ランダムな気温データの生成と配列への格納 ---
        for (int i = 0; i < daysOfWeek.length; i++) {
            int temp = random.nextInt(16) + 20; // 20～35の範囲でランダムな気温を生成します

            // 【continue文の使用例】
            // 気温が15℃未満の場合、その日の予報はスキップし、次の日の処理に進みます。
            if (temp < 15) { 
                System.out.println(daysOfWeek[i] + ": 気温が異常なため、予報をスキップします。");
                continue; // この日の処理をスキップし、次の日へ
            }

            temperatures[i] = temp; // 生成された気温を配列の適切な添字（インデックス）に格納
            System.out.println(daysOfWeek[i] + ": " + temperatures[i] + "℃");
        }

        System.out.println("\n--- 気温データの並び替え ---");

        // --- 2. 気温のバブルソート（昇順） ---
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                // 昇順に並べ替えるため、現在の基準要素(i)が比較対象要素(j)より大きい場合に交換
                String sortOrder = "asc";
                String sortOrderDisplay = "昇順";
                if(args.length>0){
                    if(args[0].equals("desc")){
                        sortOrder = "desc";
                        sortOrderDisplay = "降順";
                    }else if(args[0].equals("asc")){
                        sortOrder = "asc";
                        sortOrderDisplay = "降順";
                    }else{
                        System.out.println("ソート順が指定されなかったか、無効な値のため、昇順でソートします。");
                    }
                    System.out.println(sortOrderDisplay + "でソートします");
                }
                if (temperatures[i] > temperatures[j]) { 
                    int temp = temperatures[i]; // temperatures[i]の値をtempに避難
                    temperatures[i] = temperatures[j]; // temperatures[j]の値をtemperatures[i]にコピー
                    temperatures[j] = temp; // tempに避難しておいた値をtemperatures[j]にコピー
                }
            }
        }
        
        // --- 3. ソート後の気温の表示 ---
        System.out.print("気温（昇順）：[");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(temperatures[i]);
            if (i < temperatures.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}