
package Model;

public class Fresher extends Candidate{
    private String graduationTime;
    private String graduationRank;
    private String graduationSchool;

    public Fresher() {
        super();
    }

    public Fresher(String candidateID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType, String graduationTime, String graduationRank, String graduationSchool) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationTime = graduationTime;
        this.graduationRank = graduationRank;
        this.graduationSchool = graduationSchool;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }
    
}
