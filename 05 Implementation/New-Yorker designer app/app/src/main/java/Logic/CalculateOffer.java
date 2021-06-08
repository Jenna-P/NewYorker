package Logic;

public class CalculateOffer {

    int totalFrame;
    int totalPane;
    double totalPrice;
    boolean offerRejected;
    double glassPanelPrice = 985;
    double satinGlass = 70;
    double lydGlass = 95;
    double lockCase = 500;
    public double singleDoor = 2000;
    public double doubleDoor = 4000;
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

    public double calculateDoor(int totalglass, String doorType) {

        if (doorType.equals("Enkeltdør uden låsekasse")) {
            return (totalglass * glassPanelPrice + singleDoor) * VAT;

        } else if (doorType.equals("Enkeltdør med låsekasse")) {
            return (totalglass * glassPanelPrice + singleDoor + lockCase) * VAT;

        } else if (doorType.equals("Dobbeltdør uden låsekasse")) {
            return (totalglass * glassPanelPrice + doubleDoor) * VAT;

        }else if (doorType.equals("Dobbeltdør med låsekasse")) {
            return (totalglass * glassPanelPrice + doubleDoor + lockCase) * VAT;

        }else if (doorType.equals("Enkelt skydedør")) {
            return (totalglass * glassPanelPrice + singleSlideDoor) * VAT;

        }else if (doorType.equals("Dobbelt skydedør")) {
            return (totalglass * glassPanelPrice + doubleSlideDoor) * VAT;
        }


        return 0;
    }
}
