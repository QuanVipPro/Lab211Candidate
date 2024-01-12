
package Model;

public class Candidate {
    private String candidateID;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType;
    
    public Candidate(){       
    }
    
    public Candidate(String candidateID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType=candidateType;
    }

    public String getcandidateID() {
        return candidateID;
    }

    public void setcandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return candidateID + " | " + firstName + " | " + lastName + " | " + birthDate + " | " + address + " | " + phone + " | " + email + " | " + candidateType;
    }
    
}
