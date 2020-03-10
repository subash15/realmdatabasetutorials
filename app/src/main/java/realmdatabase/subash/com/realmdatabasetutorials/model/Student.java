package realmdatabase.subash.com.realmdatabasetutorials.model;

import io.realm.RealmObject;

public class Student extends RealmObject {
    private String name;
    private String address;
    private String mobileNumber;
    private String occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Student : " +" name = "+name+ ",address ="+address+ " , Ocuupation ="+occupation ;
    }
}
