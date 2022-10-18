package com.company;
import java.util.ArrayList;


public class CRS extends csv {
    public CRS(){
    }

    public void display_course_management(){ //displaying the course management menu
        System.out.println(">>>>>Course Management<<<<<");
        System.out.println("1. Create new course ");
        System.out.println("2. Delete course ");
        System.out.println("3. Edit a course ");
        System.out.println("4. Display information for a given course (by course ID) ");
        System.out.println("5. Register a student ");
        System.out.println("6. Return ");
    }
    public void display_reports(){ //displaying the report management menu
        System.out.println(">>>>>Course Report<<<<<");
        System.out.println("1. View all courses ");
        System.out.println("2. View all courses that are full ");
        System.out.println("3. Write to file the list of course that are full");
        System.out.println("4. View the names of student in a specific course");
        System.out.println("5. View the list of courses that a given student is registered on");
        System.out.println("6. Sort courses based on the current number of student registers");
        System.out.println("7. Return");
    }


    public boolean check_input_admin(String username, String password){ //check to see if the admin username and passwords are correct
        if ((username.equals("Admin"))&&(password.equals("Admin001"))){
            return true;
        }
        return false;
    }
    public boolean check_input_student(String username, String password, ArrayList<Student>list_student){ //if username and password match those in user, allow access to them
        int a;
        for (a = 0; a < list_student.size()-1; a++){
            String student_username = list_student.get(a).getUser();
            String student_password = list_student.get(a).getPass();
            if ((student_username.equals(username))&&(student_password.equals(password))) {
                return true;
            }
        }
        return false;
    }
    public static Student return_student(String username, String password, ArrayList<Student> list){ //return the student object given a username, password, and the arraylist of the students
        for (int b = 0; b < list.size()-1; b++){
            String student_first = list.get(b).getUser();
            String student_last = list.get(b).getPass();
            if ((student_first.equals(username))&&(student_last.equals(password))){
                return list.get(b);
            }
        }
        return null;
    }
}
