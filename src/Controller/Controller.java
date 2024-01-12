package Controller;

import Model.Candidate;
import java.util.ArrayList;
import View.Menu;

public class Controller extends Menu {
    ArrayList<Candidate> candidates = new ArrayList<>();
    Manager mg = new Manager();

    public Controller() {
        super("\nCANDIDATE MANAGEMENT SYSTEM", new String[]{"Experience", "Fresher", "Internship", "Searching", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch(ch) {
            case 1:
                mg.createCandidate(candidates, 1);
                break;
            case 2:
                mg.createCandidate(candidates, 2);
                break;
            case 3:
                mg.createCandidate(candidates, 3);
                break;
            case 4:
                if(candidates.isEmpty()){
                    System.out.println("No candidates have been created. Please create a candidate first !");
                }else{
                    mg.searchCandidate(candidates);
                }
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

}
