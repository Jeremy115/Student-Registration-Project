
import java.time.LocalTime;

public class TraditionalCourse extends Course
{
        private String days,room;
        private LocalTime start,stop;
           
        
        public boolean conflictsWith(Course c)   
        {
            
            boolean conflicts = false; 
            boolean sharesDay = false;
            
            
            if(c instanceof TraditionalCourse)
            {
               TraditionalCourse t = (TraditionalCourse)(c); 
            
            for(int i = 0; i < this.days.length(); i++)
            {
             for (int j = 0; j < t.days.length(); ++j )
             {
                 if(days.charAt(i) == t.days.charAt(j))
                 {
                     sharesDay = true; 
                 }
            }
        } 
        if(sharesDay)
        {
            if(start.isBefore(t.start) && stop.isAfter(t.start) ||              //Starts Before and Ends During or After
                   (start.isAfter(t.start) && stop.isAfter(t.start)) ||          //Starts During and Ends After
                    (start.isAfter(t.start) && stop.isBefore(t.start)) ||         //Starts During and Stops During
                            (start.isBefore(t.start) && stop.isBefore(t.start) &&
                                (start.equals(t.start) || (start.equals(t.stop)))))  //Starts or Stops At The Same Time
            {
                conflicts = true; 
            }
        }
    }
       return conflicts;      
}
              public TraditionalCourse()
        {
                // Basic Properties
                this.name       = "";
                this.crn        = 0;
                this.number     = "";
                this.section    = 0;
                this.credits    = 0;
                this.type       = "";
                this.instructor = "";
                
                // Other Properties
                this.days   = "";
                this.room   = "";
                this.start  = null;
                this.stop   = null;
        }
        
        public void setStart(LocalTime start)
        {
                this.start = start;
        }
        
        public void setStop(LocalTime stop)
        {
                this.stop = stop;
        }
        
        public void setDays(String days)
        {
                this.days = days;
        }
        
    public void setRoom(String room)
        {
                this.room = room;
        }
        
        public String toString()
        {
                String str = "Course Details:-\n";
                str += "Name: " + name + " ";
                str += "CRN:  " + crn + " ";
                str += "Number:  " + number + " ";
                str += "Section: " + section + " ";
                str += "Credits: " + credits + " ";
                str += "Type: " + type + "\n";
                str += "Instructor: " + instructor + " ";
                str += "Days:  " + days + " ";
                str += "Room:  " + room + " ";
                str += "Start: " + start + " ";
                str += "Stop:  " + stop + "\n";
                return str;
        }
}

