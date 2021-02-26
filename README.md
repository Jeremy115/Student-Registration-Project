# Student-Registration-Project
Sign up for college classes using a registration system. 

created by: Jeremy115



This was one of my old programs from my junior year in college. This was a project for CS 232, which was my Java programming class. The code was assigned to create a registration system that would help register students for classes. I was to add four options that allowed the student to Search for courses, register for cources, view cources the student signed up for, and to quit the program. 

The program gives you a curriculum of classes to choose from. As you sign up for classes, it will store what classes you have registered for. When you are done selecting your classes you can select the "View Trial Schedule" option to see the courses you signed up for. 

This program does not pull from an actual college curriculum, but the professor gave us a crv file with all the courses Jacksonville State University offered at the time. We were to read into the file using and if the user wanted to search for classes it would read all the files and bring up any courses that the student looked for. If a student put in, for example, CS 488 into the "Search Courses" option. They would receive online and traditional classroom classes JSU offered for that particular course. As well as not letting the student to have no conflicting times on the same day. 

The program reads each line of the crv file and if it found anything that would conatin the CS 488 when you search for courses, it would output a formated document of that classes description. If it is a online class it prints online, If traditional then it gives when, where, and what time the class started and other information about the course. 


When the student registers for a class, the program will ask for the CRN number of the class and if that class does not exist it will output that this class does not exist. If the class exist it will successfully add the course to their schedule. When the student registers for another traditional class within the same day and the same time, then the program tells the user that the course conflicts with their current scheudle. If the course is online, there will be no conflicting times and days to be evaluated by the code and it will add the class to the schedule. Again, if that online class does not exist then the program states that the class does not exist.  Once the student is done registering for courses and have no conflicting times and dates, they can review the courses they have signed up for by choosing the "View Trial Schedule" option.
 **The list with the classes are added into the files of the program.**
 
 
 
 With that said, here is a little information about the project. There are 4 different .java files each containing its own part. 
 
 **Course.java: 
 
 Course.java is a getter and setter class for the CourseBrowsing(main) class. This stores the information of the crn, section, credits, name, number, type, and instructor. 
 
 
 
**OnlineCourse.java: 

Set the properties of the online classes. As well as a toString method that formats the information of the crv file read. 



**TraditionalCourse.java: 

Sets the properties of the traditional classes and adds the days, room, start, and stop time of the class. This Class checks the day and time and if they conflict, if the days conflicts the conflicts boolean gate type is set to true. Which when set to true, the main class has the conflcits type set true and prints there is a conflict between 2 different courses. If there is no conflict set to false. This class contains a toString method that formats the information from the crv file as well. 



**CourseBrowsing.java

 This is the main class which all the other .java files connect. 
 This class sets the information from the file and stores it when needed into the appropriate type. 
 
 The main class is where we ask the user to search for courses, register for courses, view trial schedule, or quit. 
 A switch statement is added for either selections the user inputs as their option.(based on an option of 1-4)
 
 Case 1 
 (Search for courses)
 user ask to Search for courses. 
 
 user gives course type for ex. CS 232
 searches catalog/crv file for anything that has CS 232 in the file and print everything that contains CS 232 as the course section and number. 
 then goes back to the section where it ask the student if they want to search for cources, regiester for cources, view trial scedule, or quit. 
 
 
 Case 2
 (Register for courses) 
 once student presses 2 to register for course. the program then ask the CRN number for the course and if it exist then it will insert the course. 
 If the course exist and doesnt conflict with the time(from the TraditionalCourse.java class) then it will add the class, and will not add if the times conflict. 
 
 Case 3: 
 (View Trial Schedule)
 Dispays the array of stored classes.As well as the format based on if the class is traditional or online. 
 
 Case 4: 
 (Quit)
 Simply ends the switch statements programs while loop and ends the executed code. 
 
 
 
 
 









