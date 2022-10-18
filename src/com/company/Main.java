package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class Main{
    public static void main(String[] args)throws Exception {

        //define an admin in the system
        Admin onlyAdmin = new Admin("Admin", "Admin001", "bob", "joe");

        //define an arraylist of students and courses to be used
        ArrayList<Student> Students = new ArrayList<Student>();
        Students.add(new Student("a", "b", "Robert", "Jiang"));
        Students.add(new Student("c", "d", "Daniel", "Tang"));
        Students.add(new Student("e", "f", "David", "Cheung"));
        Students.add(new Student("j", "k", "Alex", "Zhao"));
  

        //define an arraylist of all courses
        ArrayList<Course> Courses = new ArrayList<Course>();

        //read the course in a cvs file
        List<List<String>> lines = new ArrayList<>(); //use a nested list
        try {
            Scanner csv = new Scanner(new File("MyUniversityCourses (4).csv"));
            csv.useDelimiter(",");
            while (csv.hasNext()) {
                String line = csv.nextLine();
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int k = 1; k < 30; k++) { //add the courses in the csv file into the Courses ArrayList
            Courses.add(new Course(lines.get(k).get(0), lines.get(k).get(1), lines.get(k).get(2), lines.get(k).get(3), new ArrayList<Student>(), lines.get(k).get(5), lines.get(k).get(6), lines.get(k).get(7)));
        }

        //deserialize here because if you have a saved file, it will replace the previous csv file
        try{
            FileInputStream readCourse = new FileInputStream("Courses"); //read Courses file
            ObjectInputStream readCourse2 = new ObjectInputStream(readCourse);
            Courses = (ArrayList) readCourse2.readObject();
            readCourse2.close();
            readCourse.close();

            FileInputStream readStudent = new FileInputStream("Students"); //read Students file
            ObjectInputStream readStudent2 = new ObjectInputStream(readStudent);
            Students = (ArrayList) readStudent2.readObject();
            readStudent2.close();
            readStudent.close();
        } catch (IOException ioe) {
            System.out.println("Files not found");
//            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
//            c.printStackTrace();
        }

        //begin program
        boolean switcher = true;
        while (switcher) { //this will determine when the program will exit
        System.out.println("Welcome to the Database. Choose 1 for Admin, 2 if you are student, or 3 to exit");
        CRS Program = new CRS();
        int start = Program.obtain_int();
            if (start == 1) {  //logging into the admin class
                System.out.println("Username:");
                String user = Program.obtain_string();
                System.out.println("Password:");
                String pass = Program.obtain_string();
                if (Program.check_input_admin(user, pass) == true) {
                    boolean admin_menu = true;
                    while (admin_menu) { //start admin menu
                        System.out.println("Welcome Admin. Would you like to access Course Management or Report? Choose 1 for Course management and 2 for Report. Enter 3 to logout.");
                        int management_or_report = Program.obtain_int();
                        if (management_or_report == 1) { //start Course management
                            boolean admin_course = true;
                            while (admin_course) {  //start admin course
                                Program.display_course_management();
                                int answer = Program.obtain_int();
                                //choose an answer choice
                                if (answer == 1) {
                                    Course newCourse = onlyAdmin.Create_Course();
                                    Courses.add(newCourse);
                                    System.out.println("Course Created");
                                } else if (answer == 2) {
                                    onlyAdmin.Delete_Course(Courses);
                                } else if (answer == 3) {
                                    onlyAdmin.Edit_Course(Courses);
                                } else if (answer == 4) {
                                    onlyAdmin.Display_information(Courses);
                                } else if (answer == 5) {
                                    Courses = onlyAdmin.Register_Student(Courses, Students);
                                } else if (answer == 6) {
                                    System.out.println("Returning...");
                                    admin_course = false;
                                }
                            }
                        } else if (management_or_report == 2) { //start Report management
                            boolean admin_report = true;
                            while (admin_report) {
                                Program.display_reports();
                                int answer2 = Program.obtain_int();
                                //choose an answer choice
                                if (answer2 == 1) {
                                    onlyAdmin.View_Course(Courses);
                                } else if (answer2 == 2) {
                                    onlyAdmin.view_course_full(Courses);
                                } else if (answer2 == 3) {
                                    onlyAdmin.write_to_file(Courses);
                                } else if (answer2 == 4) {
                                    onlyAdmin.view_student_courses(Courses);
                                } else if (answer2 == 5) {
                                    onlyAdmin.view_courses_student(Courses);
                                } else if (answer2 == 6) {
                                    Courses = onlyAdmin.sort(Courses);
                                } else if (answer2 == 7) {
                                    System.out.println("Exiting...");
                                    admin_report = false;
                                }
                            }
                        }
                        else if (management_or_report == 3){ //exits
                            admin_menu = false;
                        }
                    }
                }
            }else if (start == 2) { //logging into student module
                    System.out.println("Username:");
                    String user1 = Program.obtain_string();
                    System.out.println("Password:");
                    String pass1 = Program.obtain_string();
                    if (Program.check_input_student(user1, pass1, Students)) { //check to see if the username and password match one of the student
                        boolean student_inputs = true;
                        while (student_inputs){
                            Student protagonist = CRS.return_student(user1, pass1, Students);
                            System.out.println("Hello " + protagonist.getFirst_name() + " " + protagonist.getLast_name() + ", what would you like to do today?");
                            Program.display_reports(0);
                            int answer12 = Program.obtain_int();
                            //choose an option for the student
                            if (answer12 == 1) {
                                protagonist.View_my_course(Courses);
                            } else if (answer12 == 2) {
                                protagonist.View_Course_Not_Full(Courses);
                            } else if (answer12 == 3) {
                                protagonist.Register_Course(protagonist, Courses);
                            } else if (answer12 == 4) {
                                protagonist.Withdraw(protagonist, Courses);
                            } else if (answer12 == 5) {
                                protagonist.Current_Registered(protagonist, Courses);
                            } else if (answer12 == 6) {
                                System.out.println("Exiting...");
                                student_inputs = false;
                            }
                    }
                }

            }else if (start == 3) { //give the user the option to exit
                   System.out.println("Exiting...");
                   switcher = false;
                }
            }

        //Serialize the student and course class here, after the use exits the platform
        try{
            FileOutputStream writeStudent = new FileOutputStream("Students"); //write Students
            ObjectOutputStream writeStudent2 = new ObjectOutputStream(writeStudent);
            writeStudent2.writeObject(Students);
            writeStudent2.close();
            writeStudent.close();

            FileOutputStream writeCourse = new FileOutputStream("Courses"); //write Courses
            ObjectOutputStream writeCourse2 = new ObjectOutputStream(writeCourse);
            writeCourse2.writeObject(Courses);
            writeCourse2.close();
            writeCourse.close();
        }catch (IOException ioe){ //exception handling
            ioe.printStackTrace();
        }
        }
    }
