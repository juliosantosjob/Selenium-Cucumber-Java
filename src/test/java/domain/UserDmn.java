package domain;

public class UserDmn {
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String country;
    private String zip;
    private String address;
    private String additionalNotes;

    public UserDmn(String firstName, String lastName, String company, String email, String country, String zip, String address, String additionalNotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.country = country;
        this.zip = zip;
        this.address = address;
        this.additionalNotes = additionalNotes;
    }

    public UserDmn() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getAddress() {
        return address;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

}