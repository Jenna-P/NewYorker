import com.example.newyorkerui.UserContact;
import com.example.newyorkerui.UserMeasurements;

import KD_iteration1.CalculateOffer;
import KD_iteration1.PersonData;
import KD_iteration1.WallLayout;

public class BackendToFrontendComs {

    //Data fra systemet
    WallLayout wallLayout = new WallLayout();
    PersonData personData = new PersonData();
    CalculateOffer calculateOffer = new CalculateOffer();

    //Data til systemet
    UserMeasurements userMeasurements = new UserMeasurements();
    UserContact userContact = new UserContact();


    //Krydsfælt med Data
    public UserMeasurements getUserMeasurements() {
        return userMeasurements;
    }

    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public WallLayout getWallLayout() {
        return wallLayout;
    }

    public void setCalculateOffer(CalculateOffer calculateOffer) {
        this.calculateOffer = calculateOffer;
    }
}
