package Logic;

public class CalculateOffer {

    int totalFrame;
    int totalPane;
    double totalPrice;
    boolean offerRejected;
    double glassPanelPrice = 985;
    double satinGlass = 70;
    double lydGlass = 95;
    public double lockCase = 500;
    double singleDoor = 2000;
    double doubleDoor = 4000;
    double singleSlideDoor = 2480;
    double doubleSlideDoor = 4960;
    double messing = 500;
    double blackHandle = 250;

    final double VAT = 1.25;
    WallLayout wall = new WallLayout();


    public double calculatePrice(int tg) {

        totalPrice = tg * glassPanelPrice * VAT;
        System.out.println("pris : " + totalPrice + "DKK.");

        return totalPrice;
    }

    public boolean rejectOffer() {

        return offerRejected;
    }

    public double calculateSatinGlass(int totalGlass) {

        return totalGlass * satinGlass * VAT;

    }

    public double calculateLydGlass(int totalGlass) {
        return totalGlass * lydGlass * VAT;
    }



    public double chooseSingleDoor(int tg) {
        return (tg * glassPanelPrice + singleDoor) * VAT;
    }

    public double chooseDoubleDoor(int tg) {
        return (tg * glassPanelPrice + doubleDoor) * VAT;
    }

    public double chooseSingleSlideDoor(int tg) {
        return (tg * glassPanelPrice + singleSlideDoor) * VAT;
    }

    public double chooseDoubleSlideDoor(int tg) {
        return (tg * glassPanelPrice + doubleSlideDoor) * VAT;
    }

    public double chooseMessingOne(){

        return messing * VAT;
    }

    public double chooseMessingTwo(){

        return messing * 2 * VAT;
    }

    public double chooseBlackOne(){

        return blackHandle * VAT;
    }

    public double chooseBlackTwo(){

        return blackHandle * 2 * VAT;
    }
}
