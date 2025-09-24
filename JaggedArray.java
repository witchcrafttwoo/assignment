class JaggedArray {
    public static void main(String[] args) {
        // 初期値を持たせたジャグ配列の宣言と初期化
        // 2次元配列を宣言と初期化する
        int[][] jaggedNumbers = {
            {10, 20},
            {30, 40, 50, 60, 70},
            {80, 90, 100}
        };
        boolean b1 = true ,b2 = false;
        // 1次元目の要素数 (行数) を取得
        System.out.println("配列全体の行数: " + jaggedNumbers.length); // 期待値: 3

        // for文を使って配列の中身を順に確認する
        for (int i = 0; i < jaggedNumbers.length; i++) {

            // 内部ループ: 各行の列を反復
            for (int j = 0; j < jaggedNumbers[i].length; j++) {
                System.out.print(jaggedNumbers[i][j] + " ");
            }
            System.out.println();  
        }
        int i = 0;
        for(i = 1;i<10;i++ ){
            
        }
    }
}
