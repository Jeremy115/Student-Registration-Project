import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CourseBrowsing{
    
    public static final int TRADITIONAL_FIELDS = 11;
    public static final int ONLINE_FIELDS = 7;

    public static final String INPUT_FILE = "project1input.csv"; 
    
    public static void main(String[] args) {

        boolean done = false;

        /* Row Objects */
        
        ArrayList<String> row;
        ArrayList<Course> catalog = new ArrayList<>();
        ArrayList<Course> trialschedule = new ArrayList<>();
        
        int rowCounter = 0;

        try {
            
            /* Attempt to open input file */

            Scanner inputFile = new Scanner(Paths.get(INPUT_FILE), "UTF-8");
            
            while ( inputFile.hasNextLine() ) {
                
                /* Get next line */
                
                String line = inputFile.nextLine();
                row = new ArrayList(Arrays.asList(line.split("\t")));
                rowCounter++;
                
                /* Does row have 11 fields?  If so, it's a TraditionalCourse */
                
                if ( row.size() == TRADITIONAL_FIELDS ) {
                    
                    TraditionalCourse c = new TraditionalCourse();
                    
                    /* Get data in common fields */
                    
                    c.setName( row.get(0) );
                    c.setCrn( Integer.parseInt(row.get(1)) );
                    c.setNumber( row.get(2) );
                    c.setSection( Integer.parseInt(row.get(3)) );
                    c.setCredits( Integer.parseInt(row.get(4)) );
                    c.setType( row.get(9) );
                    c.setInstructor( row.get(10) );
                    
                    /* Get start time */
                    
                    String[] time = row.get(5).split(":");
                    int hour = Integer.parseInt(time[0]);
                    int minute = Integer.parseInt(time[0]);
                    c.setStart( LocalTime.of(hour, minute) );

                    /* Get stop time */

                    time = row.get(6).split(":");
                    hour = Integer.parseInt(time[0]);
                    minute = Integer.parseInt(time[0]);
                    c.setStop( LocalTime.of(hour, minute) );

                    /* Get remaining fields */

                    c.setDays( row.get(7) );
                    c.setRoom( row.get(8) );
                    
                    /* Create TraditionalCourse object; add to collection */
                    
                    catalog.add(c);
                    
                }
                
                /* Does row have 7 fields?  If so, it's an Online course */
                
                else if ( row.size() == ONLINE_FIELDS ) {
                    
                    OnlineCourse c = new OnlineCourse();
                    
                    /* Get data in common fields */
                    
                    c.setName(row.get(0));
                    c.setCrn(Integer.parseInt(row.get(1)));
                    c.setNumber( row.get(2) );
                    c.setSection( Integer.parseInt(row.get(3)) );
                    c.setCredits( Integer.parseInt(row.get(4)) );
                    c.setType( row.get(5) );
                    c.setInstructor( row.get(6) );
                    
                    /* Create OnlineCourse object; add to collection */
                    
                    catalog.add(c);
                    
                }
                
                else {
                    
                    StringBuilder s = new StringBuilder();
                    
                    s.append("*** BAD DATA: ");
                    s.append("Line ").append(rowCounter).append(" ");
                    s.append("has ").append(row.size()).append(" field(s)!");
                    
                    System.out.println(s.toString());
                                        
                }

            }
            
            /* Close input file */
            
            inputFile.close();
            
            /* Main Menu */
            
            Scanner in = new Scanner(System.in);

            while ( !done ) {

                int choice = 0;
                boolean valid_input = false;

                /* Display Menu */

                while (!valid_input) {

                    System.out.println("\n1) Search Courses");
                    System.out.println("2) Register for Course");
                    System.out.println("3) View Trial Schedule");
                    System.out.println("4) Quit");

                    System.out.print("\nYour Choice? ");

                    choice = in.nextInt();

                    if (choice < 1 || choice > 4) {
                        System.out.println("ERROR: Invalid Input!  Try again.\n");
                    }

                    else {
                        valid_input = true;
                    }

                }

                switch (choice) {

                    case 1:
                        
                        /* Get Course Number */

                        String number = "";
                        boolean valid = false;

                        while (!valid) {
                            System.out.print("Enter the course number in the format SSNNN ");
                            System.out.print("for example, CS201): ");
                            number = in.next().toUpperCase().trim();
                            if (number.length() == 5) {
                                number = number.substring(0, 2) + ' ' + number.substring(2, 5);
                                valid = true;
                            }
                            else {
                                System.out.println("ERROR: Invalid Input!  Try again.\n");
                            }
                        }

                        /* Find Sections */

                        ArrayList<Course> results = new ArrayList<>();

                        for (int i = 0; i < catalog.size(); ++i) {

                            if (catalog.get(i).getNumber().equals(number)) 
                            {
                                results.add(catalog.get(i));
                            }
                        }
                        
                        /* Print Results */

                        for (int i = 0; i < results.size(); ++i) {
                            System.out.println(results.get(i));
                        }

                        break;

                    case 2:                                 //This is where we are focusing on case 2 in the switch statement

                        System.out.print("Enter CRN number: ");
                        int crn = in.nextInt();

                        /* Get Course */
                        
                        Course c = null;

                        for (int i = 0; i < catalog.size(); ++i) 
                        {     
                            if (catalog.get(i).getCrn() == crn) 
                            {
                                c = catalog.get(i);
                            }

                        }
                        
                        /* Check for Conflicts */

                        boolean conflicts = false;

                        if (c != null) {

                            for (Course s : trialschedule) {      //Here is where it inheriance the Course conflictWith method. 

                                if(s.conflictsWith(c))

                                    conflicts = true;
                                
                            }

                        }
                        
                        /* If no conflicts, register for course */
                        if(c == null)
                        {
                            System.out.print("ERROR: Course not found, or it conflicts with your schedule.\n"); 
                        }
                        else if (!conflicts)
                        {

                            trialschedule.add(c);
                            System.out.println("Course added successfully!\n");

                        }
                        else
                        {
                            
                            System.out.print("ERROR: Either the course was not found, or it ");
                            System.out.println("conflicts with your current schedule!");
                            
                        }

                        break;

                    case 3:
                        
                        /* Print Trial Schedule */

                        for (int i = 0; i < trialschedule.size(); ++i) {
                            System.out.println(trialschedule.get(i));
                        }
                        
                        break;

                    case 4:

                        done = true;
                        break;

                }

            }
        
            System.out.print("\nThank you for using the Student Registration ");
            System.out.println("System!\n\n");
            
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }       
    }   
}

