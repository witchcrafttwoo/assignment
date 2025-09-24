import java.util.Scanner;
public class FindMaxInArray{
    public static void main(String[] args){
        int[] numbers = new int[5];
        Scanner SC = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println((i+1)+"番目の数を入力してください");
            numbers[i] = SC.nextInt();
        }
        int Max=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(Max<numbers[i]){
                Max = numbers[i];
            }

        }
        System.out.println("入力された最大値は"+Max);
        SC.close();

    }
}