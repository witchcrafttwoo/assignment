
import java.util.Scanner;

class ConsoleTodoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"Shift_JIS");
        int choice;
    
        int maxTodos = 5;

        String[] todos = new String[maxTodos];
        boolean[] todoStatuses = new boolean[maxTodos];

        int nextTodoIndex = 0;

        int maxGoals = 3;
        String[] goals = new String[maxGoals];
        int nextGoalIndex = 0;

        System.out.println("ToDoアプリへようこそ!");
        do{
            System.out.println("\n=== メニュー ===");
            System.out.println("1. ToDoを登録");
            System.out.println("2. ToDoを完了");
            System.out.println("3. ToDoを確認");
            System.out.println("4. 今日の目標を設定");
            System.out.println("5. 今日の目標を確認する");
            System.out.println("6. 終了");
            System.out.print("番号を選択してください (1-6)");

            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine(); // おまじない
                
                
                switch(choice){
                    case 1 -> {
                        if(nextTodoIndex < maxTodos){
                            System.out.print("登録するToDoを入力してください:");
                            String newTodo = scanner.nextLine();

                            todos[nextTodoIndex] = newTodo; // ToDoを登録
                            todoStatuses[nextTodoIndex] = false; // 初期状態は未完了
                            System.out.println("ToDo「" + newTodo + "」を登録しました。");
                            nextTodoIndex++;
                        }else{
                            System.out.println("ToDoリストがいっぱいです。これ以上登録できません。");
                        }

                    }
                    case 2 -> { // ToDoを完了
                        if (nextTodoIndex == 0) {
                            System.out.println("ToDoが登録されていません。\n完了にするToDoがありません。");
                        } else {
                            System.out.println("\n--- 完了するToDoを選択してください ---");
                            for (int i = 0; i < nextTodoIndex; i++) {
                                System.out.println((i + 1) + ". " + todos[i] + (todoStatuses[i] ? " (完了済み)" : " (未完了)"));
                            }
                            System.out.print("完了にするToDoの番号を入力してください (1-" + nextTodoIndex + "): ");
                            if (scanner.hasNextInt()) {
                                int inputNum = scanner.nextInt();
                                scanner.nextLine(); // nextIntの後の改行読み飛ばし

                                // 入力チェック
                                if (inputNum > 0 && inputNum <= nextTodoIndex) {
                                    int targetIndex = inputNum - 1;

                                    if (!todoStatuses[targetIndex]) { // まだ未完了の場合
                                        todoStatuses[targetIndex] = true; // 完了にする
                                        System.out.println("ToDo「" + todos[targetIndex] + "」を完了にしました！");
                                    } else {
                                        System.out.println("ToDo「" + todos[targetIndex] + "」は既に完了済みです。");
                                    }
                                } else {
                                    System.out.println("無効な番号です。1から" + nextTodoIndex + "の間で入力してください。");
                                }

                            } else {
                                System.out.println("番号を数字で入力してください。");
                                scanner.nextLine(); // 不正な入力を読み飛ばす
                            }
                        }
                    }

                    case 3 -> {
                        System.out.println("\n=== 今日のToDo一覧 ===");
                        if(nextTodoIndex == 0){
                            System.out.println("今日のToDoは登録されていません。");
                        }else{
                            for(int i = 0; i < nextTodoIndex; i++){
                                String status = todoStatuses[i] ? "完了" : "未完了";
                                System.out.println((i+1) + ". " + todos[i] + " (" + status + ")");
                            }
                        }
                        System.out.println("---------------------");
                    }
                    case 4 -> { // 今日の目標を設定 (配列対応版)
                        if (nextGoalIndex < maxGoals) { // 配列に空きがあるか確認
                            System.out.print("設定する目標を入力してください: ");
                            String newGoal = scanner.nextLine();
                            goals[nextGoalIndex] = newGoal; // 次の空き場所に目標を格納
                            System.out.println("目標「" + goals[nextGoalIndex] + "」を設定しました。");
                            nextGoalIndex++; // 次に登録するインデックスを一つ進める
                        } else {
                            System.out.println("目標リストがいっぱいです。これ以上設定できません。(" + maxGoals + "個まで)");
                        }
                    }
                    case 5 -> { // 今日の目標を確認する (配列対応版)
                        System.out.println("\n--- 今日の目標一覧 ---");
                        if (nextGoalIndex == 0) { // まだ何も目標が登録されていないかチェック
                            System.out.println("今日の目標は設定されていません。");
                        } else {
                               for (int i = 0; i < nextGoalIndex; i++) { // 登録されている数だけループ
                                    // goals[i] が null でないことを確認する方がより安全ですが、
                                    // 今回は nextGoalIndex までに必ず目標がある想定です。
                                    // (削除機能などを追加する場合はnullチェックが重要になります)
                                    System.out.println((i + 1) + ". " + goals[i]);
                                }
                        }
                        System.out.println("--------------------");
                    }             
                    case 6 -> { // 終了
                        System.out.println("終了処理中...");
                    }
                    default -> { // 1-3, 6以外の番号が入力された場合
                        System.out.println("無効な選択です。メニューの番号を入力してください。");
                    }
                    
                }
                
                
            }else { // 数字以外の入力があった場合
                System.out.println("数字でメニュー番号を入力してください。");
                scanner.nextLine(); // 不正な入力（数字でないトークンとその行の残り）を読み飛ばす
                choice = 0; // ループを継続させるためのダミー値 (6以外なら何でもよい)

            }


        } while (choice != 6);

        System.out.println("アプリを終了します。ご利用ありがとうございました。");

        scanner.close();
        System.out.println("プログラムを終了しました。");
    }
}
