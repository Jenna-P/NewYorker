package NewYorkerApp;

public class CalculateOffer {

    int totalFrame ;
    int totalPane;
    double price;
    boolean offerRejected;
    double glassPanelPrice = 985;
    final double VAT = 1.25;
    WallLayout wall = new WallLayout();


    public double calculatePrice(int tg){

        price = tg * glassPanelPrice * VAT;
        System.out.println("pris : " + price + "DKK.");

        return price;
    }

    public boolean rejectOffer() {

        return offerRejected;
    }


}
