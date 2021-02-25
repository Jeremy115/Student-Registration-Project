/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public abstract class Course
{
        protected int crn,section,credits;
        protected String name,number;
        protected String type,instructor;
        
        public String getNumber()
        {
            return this.number; 
        }
        public int getCrn() 
        {
          return this.crn;
        }
        
        public abstract boolean conflictsWith(Course c);
 
        public void setName(String name)
        {
                this.name = name;
        }
        public void setCrn(int crn)
        {
                this.crn = crn;
        }
        
        public void setNumber(String number)
        {
                this.number = number;
        }
        
        public void setSection(int section)
        {
                this.section = section;
        }
        
        public void setCredits(int credits)
        {
                this.credits = credits;
        }
        
        public void setType(String type)
        {
                this.type = type;
        }
        
        public void setInstructor(String instructor)
        {
                this.instructor = instructor;
        }
        
        @Override
        public abstract String toString();   
}