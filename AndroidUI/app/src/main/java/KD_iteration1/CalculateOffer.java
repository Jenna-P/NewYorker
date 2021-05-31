package KD_iteration1;

public class CalculateOffer {

    int totalFrame ;
    int totalPane;
    double price;
    boolean offerRejected;
    double glassPanelPrice = 985;
    final double VAT = 1.25;
    WallLayout wall = new WallLayout();


    public double calculatePrice(){
        totalPane = wall.calculatePane(200);
        totalFrame = wall.calculateFrame(120);

        price = totalPane * totalFrame * glassPanelPrice * VAT;
        System.out.println("pris : " + price + "kr.");

        return price;
    }

    public boolean rejectOffer() {

        return offerRejected;
    }


}
