public class PriceCalculator{
    public static void main(String[] args){
        double[] regularPrices = {1000.0,1500.0,2000.0};
        double[] discountedPrices = new double[3];
        for(int i = 0;i < regularPrices.length; i++){
        discountedPrices[i]= regularPrices[i]*0.9;

        }
            System.out.println("--商品価格一覧--");
        for(int j = 0; j < discountedPrices.length; j++){
            System.out.println("商品"+ (j + 1)+": 定価"+" "+regularPrices[j]+"円、"+"割引価格"+" "+discountedPrices[j]+"円");

        }
    }
}