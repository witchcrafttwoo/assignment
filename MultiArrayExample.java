class MultiArrayExample {
    public static void main(String[] args) {
        // 2次元配列の宣言（int[学生][教科]）
        // 行：学生（3人）、列：教科（0 = 国語, 1 = 算数）
        int[][] studentScores = new int[3][2];

        // 各学生の点数を手動で設定
        // 学生1
        studentScores[0][0] = 85; // 国語
        studentScores[0][1] = 78; // 算数
        // 学生2
        studentScores[1][0]  = 70;
        studentScores[1][1]= 82;
        // 学生3
        studentScores[2][0] = 92;
        studentScores[2][1] = 60;

        // 学生成績の表示
        System.out.println("--- 学生のテスト成績 ---");

        for (int i = 0; i < studentScores.length; i++) {
            System.out.print("学生" + (i + 1) + " ");
            System.out.print("国語: " + studentScores[i][0] + "点 ");
            System.out.println("算数: " + studentScores[i][1] + "点");
        }
    }
}
