class Ens67_1 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4]; // 3行4列の2次元配列を宣言

        // 配列に値を代入 (matrix[i][j] = i * j)
        for (int i = 0; i < matrix.____; i++) { // 行の走査
            for (int j = 0; j < matrix[____].____; j++) { // 列の走査
                matrix[____][____] = i * j;
            }
        }

        // 配列の要素を表形式で表示
        System.out.println("2次元配列の要素:");
        for (int i = 0; i < matrix.____; i++) { // 行の走査
            for (int j = 0; j < matrix[____].____; j++) { // 列の走査
                System.out.print(matrix[____][____] + "\t");
            }
            System.out.println(); // 各行の終わりに改行
        }
    }
}
