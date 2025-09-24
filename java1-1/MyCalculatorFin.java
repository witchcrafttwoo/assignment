import java.util.Scanner;

public class MyCalculatorFin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("☆☆My 電卓 ☆☆");
		System.out.print("計算対象となる演算番号(1:加算, 2:減算, 3:乗算, 4:除算)");
		
		
		// メニュー選択処理
		int inputNumber;
		if(!sc.hasNextInt()) {
			System.out.println("不正な入力です。プログラムを終了します");
			sc.close();
			return;
			
		}
		inputNumber = sc.nextInt();
		
		
		// 選択された演算番号の有効性チェック
        // 演算番号が1～4の範囲内か確認
        if (inputNumber < 1 || inputNumber > 4) {
            System.out.println("選択肢にない番号が入力されました。");
            sc.close();
            return;
        }
		
		
		int num1 = 0, num2 = 0;
		
		System.out.print("1つ目の数値を入力してください：");
		if(!sc.hasNextInt()) {
			System.out.println("不正な入力です。プログラムを終了します");
			sc.close();
			return;
			
		}
		num1 = sc.nextInt();
		
		
		System.out.print("2つ目の数値を入力してください：");
		if(!sc.hasNextInt()) {
			System.out.println("不正な入力です。プログラムを終了します");
			sc.close();
			return;
			
		}
		num2 = sc.nextInt();
			
		
		// 加算処理
		if(inputNumber == 1) {
			System.out.println("結果は " + (num1 + num2) + " です。");
		}
		
		// 減算処理
		if(inputNumber == 2) {
			System.out.println("結果は " + (num1 - num2) + " です。");
		}
		
		// 乗算処理
		if(inputNumber == 3) {
			System.out.println("結果は " + (num1 * num2) + " です。");
		}
		
		// 除算処理
		if(inputNumber == 4) {
			if(num2 == 0) {
				System.out.println("0で割ることはできません。");
				sc.close();
				return;
			}
			System.out.println("結果は " + (num1 / num2) + " です。");
		}
		
		System.out.println("計算を終了します。");
		sc.close();
		
	}

}
