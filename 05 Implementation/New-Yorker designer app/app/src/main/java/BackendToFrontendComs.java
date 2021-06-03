import com.example.newyorkerui.UserContact;
import com.example.newyorkerui.UserMeasurements;

import NewYorkerApp.PersonData;
import NewYorkerApp.CalculateOffer;
import NewYorkerApp.WallLayout;
//Denne klasse fungere som et led, mellem Frontend, og Backend.
//På denne måde, kan vi overholde "clean architecture", der UI ikke er i direktig forbindelse med systemet.
//alt hvad denne klasse gør, er at tage info fra den ene, og gør det klar til den anden.

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
