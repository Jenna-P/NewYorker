import com.example.newyorkerui.UserContact;
import com.example.newyorkerui.UserMeasurements;

import KD_iteration1.CalculateOffer;
import KD_iteration1.PersonData;
import KD_iteration1.WallLayout;

public class BackendToFrontendComs {
    //wrappers
    WallLayout wallLayout = new WallLayout();
    PersonData personData = new PersonData();
    CalculateOffer calculateOffer = new CalculateOffer();
    UserMeasurements userMeasurements = new UserMeasurements();
    UserContact userContact = new UserContact();


    //Krydsfælt med Data---------------

    //get data--
    public UserMeasurements getUserMeasurements() {
        return userMeasurements;
    }

    public UserContact getUserContact() {
        return userContact;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public WallLayout getWallLayout() {
        return wallLayout;
    }

    public CalculateOffer getCalculateOffer() {
        return calculateOffer;
    }

    //set data--
    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    public void setUserMeasurements(UserMeasurements userMeasurements) {
        this.userMeasurements = userMeasurements;
    }
}
