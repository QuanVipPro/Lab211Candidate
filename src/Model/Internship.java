
package Model;

public class Internship extends Candidate{
    private String major;
    private String semester;
    private String universityName;

    public Internship() {
        super();
    }

    public Internship(String candidateID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType, String major, String semester, String universityName) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    
}
