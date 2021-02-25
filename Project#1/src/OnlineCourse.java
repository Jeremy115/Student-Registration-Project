/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
class OnlineCourse extends Course
{
        public OnlineCourse()
        {
                // Initializing Properties
                this.name       = "";
                this.crn        = 0;
                this.number     = "";
                this.section    = 0;
                this.credits    = 0;
                this.type       = "";
                this.instructor = "";
        }
        
        public boolean conflictsWith(Course c)            
        {
            return false; 
        }

        
        @Override
        public String toString()
        {
                String str = "Course Details: \n";
                str += "Name: " + name + " ";
                str += "CRN:  " + crn + " ";
                str += "Number:  " + number+ " ";
                str += "Section: " +section+ " ";
                str += "Credits: " + credits + "\n";
                str += "Type: " + type + " ";
                str += "Instructor: " + instructor + "\n";
                return str;
        }
}
