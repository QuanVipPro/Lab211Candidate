package Controller;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Internship;
import View.Validation;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    ArrayList<Candidate> candidates = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void createCandidate(ArrayList<Candidate> candidates, int candidateType) {
        while (true) {
            System.out.print("Enter Id: ");
            String candidateID = Validation.checkInputString();
            if (Validation.checkIdExist(candidates, candidateID)) {
                System.out.print("Enter first name: ");
                String firstName = Validation.checkInputName();
                System.out.print("Enter last name: ");
                String lastName = Validation.checkInputName();
                System.out.print("Enter year of birth: ");
                String birthDate = Validation.checkBirthDay();
                //System.err.println("\nBirth date: " + birthDate + " .. " + Calendar.getInstance().get(Calendar.YEAR));
                System.out.print("Enter address: ");
                String address = Validation.checkInputString();
                System.out.print("Enter phone: ");
                String phone = Validation.checkPhone();
                System.out.print("Enter email: ");
                String email = Validation.checkEmail();
                Candidate candidate = new Candidate(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
                Manager mg = new Manager();
                switch (candidateType) {
                    case 1:
                        mg.createExperience(candidates, candidate);
                        break;
                    case 2:
                      mg.createFresher(candidates, candidate);
                        break;
                    case 3:
                        mg.createInternship(candidates, candidate);
                        break;
                }
            } else {
                System.out.println("Exist Id, please input Id again!");
                continue;
            }
            System.err.print("Do you want to continue(Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {//create an object to invoke method from Candidate.java
        System.out.print("Enter year of experience: ");
        String yearExperience = Validation.checkExperienceYear(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new Experience(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                yearExperience, professionalSkill));
        System.err.println("Create success !");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {//create an object to invoke method from Candidate.java
        System.out.print("Enter graduation time(dd/MM/yyyy): ");
        String graduationTime = Validation.checkGraduationTime();
        System.out.print("Enter graduation rank (Excellence, Good, Fair, Poor): ");
        String graduationRank = Validation.checkRankOfGraduation();
        System.out.print("Enter graduation school: ");
        String graduationSchool = Validation.checkInputString();
        candidates.add(new Fresher(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                graduationTime, graduationRank, graduationSchool));
        System.err.println("Create success !");
    }

    public void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter your major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter your semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter your University Name: ");
        String universityName = Validation.checkInputString();
        candidates.add(new Internship(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                major, semester, universityName));
        System.err.println("Create success !");
    }
    public void printAllList(ArrayList<Candidate> candidates) {
        
        boolean experienceFound = false;
        System.out.print("\n==========EXPERIENCE CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                experienceFound = true;
            }
        }
        if (!experienceFound) {
            System.out.println("Empty List");
        }
        
        boolean fresherFound = false;
        System.out.print("\n==========FRESHER CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                fresherFound = true;
            }
        }
        if (!fresherFound) {
            System.out.println("Empty List");
        }
        
        boolean internshipFound = false;
        System.out.print("\n==========INTERNSHIP CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                internshipFound = true;
            }
        }
        if (!internshipFound) {
            System.out.println("Empty List");
        }
    }


   

  public void searchCandidate(ArrayList<Candidate> candidates) {
    printAllList(candidates);
    System.out.println("=======================");
    System.out.print("Enter candidate name (First name or Last name): ");
    String nameSearch = Validation.checkInputName();
    int typeCandidate = 0;
    do{
        try{
            System.out.println("===TYPE OF CANDIDATE===");
            System.out.println("1.Experience.");
            System.out.println("2.Fresher.");
            System.out.println("3.Internship.");
            System.out.print("\nEnter type of candidate: ");
            typeCandidate = sc.nextInt();
            if (typeCandidate < 1 || typeCandidate > 3) {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Invalid choice. Please type a number between 1 and 3 !");
            sc.nextLine();
        }
    }while(typeCandidate < 1 || typeCandidate > 3);
    int count = 0;
    for (Candidate candidate : candidates) {
        
        if (candidate.getCandidateType() == typeCandidate
                && (candidate.getFirstName().toLowerCase().contains(nameSearch.toLowerCase()))
                || candidate.getLastName().toLowerCase().contains(nameSearch.toLowerCase())) {
            if(count == 0){
                System.out.println("The Candidate Found:");
            }
            System.out.println(candidate.toString());
            count++;
        }
        
    }
    if (count == 0) {
        System.out.println("Not found");
    }
}
}
