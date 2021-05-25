package KD_iteration1;

public class calculateOffer {

    int totalFrame ;
    int totalPane;
    double price;
    boolean offerRejected;
    double glassPanelPrice = 985;
    final double VAT = 1.25;
    WallLayout wall = new WallLayout();


    public double calculatePrice(){
        totalPane = wall.calculatePane();
        totalFrame = wall.calculateFrame();

        price = totalPane * totalFrame * glassPanelPrice * VAT;

        return price;
    }

    public boolean rejectOffer() {

        return offerRejected;
    }

    
}
