package View;

import Model.Candidate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Validation {
    public static final Scanner sc = new Scanner(System.in);
    
    public static String checkBirthDay(){
    while (true) {
        String result = sc.nextLine().trim();
        String regex = "^[0-9]{4}$";
        if (result.matches(regex)) {
            int birthYear = Integer.parseInt(result);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            
            if (birthYear < currentYear) {
                return result;
            } else {
                System.err.println("Invalid input. Birth year cannot be in current or the future.");
                System.out.print("Enter again: ");
            }
        } else {
            System.err.println("Invalid input. Please enter a valid birth year with a length of 4 digits.");
            System.out.print("Enter again: ");
        }
    }
}

    
    public static String checkGraduationTime(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (true){
            try{
                Date date = df.parse(sc.nextLine());
                return df.format(date);
            }catch(ParseException e){
                System.out.print("Wrong format, please input with format(dd/MM/yyyy): ");
                sc.nextLine();
            }
        }
    }
    public static String checkPhone(){
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[0-9]{10,}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid phone number is number with minimum 10 characters.");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String checkEmail(){
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid email with format <account name>@<domain>.<Top-level Domains>. ");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String checkExperienceYear(String birthDate){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birth = Integer.parseInt(birthDate);
        int age = currentYear - birth;
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[0-9]{0,100}$";
            int newResult = Integer.parseInt(result);
            if (result.matches(regex) && newResult < age) {
                return result;
            } else {
                System.out.println("Invalid input. Please enter a valid Year of Experience is number from 0 to 100 and must be smaller than age.");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String checkRankOfGraduation(){
    while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            }
            System.err.println("There are only four Rank of Graduation: Excellence, Good, Fair, Poor");
            System.out.print("Enter again: ");
        }
    }
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.print("Not empty, enter again: ");
            } else {
                return result;
            }
        }
    }
    public static boolean checkInputYN() {
        while (true) {
            try{
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            else{
                throw new Exception();
            }
            }catch(Exception e){
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    }
    public static boolean checkIdExist(ArrayList<Candidate> ls, String id) {
        for (Candidate cd : ls) {
            if (id.equalsIgnoreCase(cd.getcandidateID())) {
                return false;
            }
        }
        return true;
    }
    public static String checkInputName() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            String regex ="^[a-zA-Z\\s'-]+$";
            if (result.matches(regex)) {         
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number.");
                System.out.print("Enter again: ");
            }
        }
    }
}
