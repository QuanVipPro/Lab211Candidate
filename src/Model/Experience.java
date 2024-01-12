
package Model;

public class Experience extends Candidate{
    private String experienceYear;
    private String proSkill;

    public Experience() {
        super();
    }
    
    public Experience(String candidateID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType, String experienceYear, String proSkill) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.experienceYear = experienceYear;
        this.proSkill = proSkill;
    }

    public String getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(String experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
}

