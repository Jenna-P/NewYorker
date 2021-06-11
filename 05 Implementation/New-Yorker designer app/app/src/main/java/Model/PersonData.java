package Model;

public class PersonData {

    private String name;
    private String email;
    private String phoneNumber;



    public String getName() {
        //hente fra bruger input
        return name;
    }

    public String getEmail() {
        //hente fra bruger input
        return email;
    }

    public String getPhoneNumber() {
        //hente fra bruger input
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
