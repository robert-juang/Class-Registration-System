package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


class Admin extends User implements Admin_Methods{

    Admin(String username, String password, String first_name, String last_name){
        super(username, password, first_name, last_name); //constructor extends the user class so use super keyword
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Course Create_Course() { //creating a course
        System.out.println("Enter the following information for the course you want to create");
        System.out.println("Course Name:");
        Scanner obj = new Scanner(System.in);
        String Name = obj.nextLine();
        System.out.println("Course id:");
        Scanner obj1 = new Scanner(System.in);
        String ID = obj1.nextLine();
        System.out.println("Max student registered:");
        Scanner obj2 = new Scanner(System.in);
        String registered = obj2.nextLine();
        System.out.println("Course instructor");
        Scanner obj3 = new Scanner(System.in);
        String Instructor = obj3.nextLine();
        System.out.println("course section number ");
        Scanner obj4 = new Scanner(System.in);
        String section_number = obj4.nextLine();
        System.out.println("course location");
        Scanner obj5 = new Scanner(System.in);
        String location = obj5.nextLine();
        Course newCourse = new Course(Name, ID, registered,Integer.toString(0), new ArrayList<Student> (),Instructor, section_number, location);
        return newCourse;
    }
    public ArrayList Delete_Course(ArrayList<Course> course_list) { //delete a course
        System.out.println("Which course would you like to delete? Please enter the course name (case sensitive):");
        View_Course(course_list);
        String ans = obtain_string();
        for (int i = 0; i < course_list.size(); i++) {
            if (ans.equals(course_list.get(i).getCourse_name())) {
                course_list.remove(i);
            }
        }
        return course_list;
    }
    public ArrayList Edit_Course(ArrayList<Course> course_list) { //edit a course
        System.out.println("Choose a course you would like to edit. Please enter the course name (case sensitive):");
        View_Course(course_list);
        String ans1 = obtain_string();
        for (int i = 0; i < course_list.size(); i++) {
            if (ans1.equals(course_list.get(i).getCourse_name())) {
                System.out.println("What information would you like to edit? Enter a number:");
                System.out.println("1. instructor");
                System.out.println("2. section number");
                System.out.println("3. course location");
                System.out.println("4. max_num_student_registered");
                int ans2 = obtain_int();
                if (ans2 == 1) {
                    System.out.println("What would you like to change it to?");
                    String ans3 = obtain_string();
                    course_list.get(i).setInstructor(ans3);
                    return course_list;
                } else if (ans2 == 2) {
                    System.out.println("What would you like to change it to?");
                    String ans4 = obtain_string();
                    course_list.get(i).setSection_number(ans4);
                    return course_list;
                } else if (ans2 == 3) {
                    System.out.println("What would you like to change it to?");
                    String ans5 = obtain_string();
                    course_list.get(i).setCourse_location(ans5);
                    return course_list;
                } else if (ans2 == 4) {
                    System.out.println("What would you like to change it to?");
                    String ans6 = obtain_string();
                    course_list.get(i).setMax_num_student_registered(ans6);
                    return course_list;
                }
            }
        }
        return course_list;
    }
    public void Display_information(ArrayList<Course> course_list){ //display information for a given course
        System.out.println("Enter Course ID:");
        String ans7 = obtain_string();
        for (int i = 0; i < course_list.size(); i++){
            if (ans7.equals(course_list.get(i).getCourse_id())){
                System.out.println("----------");
                System.out.println("Course name: " + course_list.get(i).getCourse_name());
                System.out.println("Course Id:" + course_list.get(i).getCourse_id());
                System.out.println("Max number of student registered:" + course_list.get(i).getmax_num_student_registered());
                System.out.println("Current number of students registered:" + course_list.get(i).getArrayList().size());
                System.out.println("Section Number:" + course_list.get(i).getSection_number());
                System.out.println("Instructor:" + course_list.get(i).getInstructor());
                System.out.println("Location:" + course_list.get(i).getLocation());
                System.out.println("----------");
            }
        }
    }
    public ArrayList<Course> Register_Student(ArrayList<Course> course_list, ArrayList<Student> student_list){ //register a student to a class
            System.out.println("Which student would you like to register? Type his or her first then last name:");
            System.out.println("First:");
            String first = obtain_string();
            System.out.println("Last:");
            String last = obtain_string();
            System.out.println("Which Course would you like to register the student to? Enter course name:");
            View_Course(course_list);
            String ans8 = obtain_string();
            for (int i = 0; i < course_list.size(); i++) { // start for loop
                if (ans8.equals(course_list.get(i).getCourse_name())) { //check if the course exists within the database
                    for (int j = 0; j < student_list.size(); j++) { //another loop for the student array
                        if (first.equals(student_list.get(j).getFirst_name()) && last.equals(student_list.get(j).getLast_name())){ //if the first and last name match a student in the student arraylist
                            course_list.get(i).getArrayList().add(student_list.get(j)); //add student object to the arraylist for the course
//                            System.out.println(course_list.get(i).getArrayList()); //checking to make sure it works
                        }
                    }
                }
            }
            return course_list;
        }
    public void View_Course(ArrayList<Course> course_list){ //displays all course, using a couple of strategies to arrange a slightly nicer interface
        System.out.println("Course name                               |   Course ID  |  Max student registered  |  Current student registered  |  section number  |  instructors  |  location");
        for (int i = 0; i < course_list.size(); i++){
                System.out.print("\n" + "|" + course_list.get(i).getCourse_name()+ "\t");
                for (int z = 0; z < 40 - course_list.get(i).getCourse_name().length(); z++){
                    System.out.print(" ");
                }
                System.out.print("|" + course_list.get(i).getCourse_id()+ "\t");
                System.out.print("|"+"\t\t\t" + course_list.get(i).getmax_num_student_registered()+ "\t\t\t    ");
                System.out.print("|"+"\t\t\t" +course_list.get(i).getArrayList().size()+ "\t\t\t\t\t");
                System.out.print("|" +"\t\t"+course_list.get(i).getSection_number()+ "\t\t");
                System.out.print("|" +course_list.get(i).getInstructor()+ "\t");
                System.out.print("|" +course_list.get(i).getLocation()+ "\t");
            }
        System.out.println("");
    };
    public void view_course_full(ArrayList<Course> course_list){ //display all course that are full
        for (int i = 0; i < course_list.size(); i++){
            if (Integer.toString((course_list.get(i).getArrayList().size())).equals((course_list.get(i).getmax_num_student_registered()))){
                System.out.println(course_list.get(i).getCourse_name());
            }
        }
    }
    public void write_to_file(ArrayList<Course> course_list){ //write a FullClass.txt file
        String fileName = "FullClasses.txt";
        ArrayList <String> names = new ArrayList<String>();
        try{
            for (int i = 0; i < course_list.size(); i++) {
                if (Integer.toString((course_list.get(i).getArrayList().size())).equals((course_list.get(i).getmax_num_student_registered()))){
                    names.add(course_list.get(i).getCourse_name());
                }
            }
            FileWriter write = new FileWriter(fileName);
            for (int j = 0; j<names.size(); j++){
                write.write(names.get(j) + ", ");
            }
            write.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException exk) { //io exception handling
            System.out.println( "Error writing file '" + fileName + "'");
            exk.printStackTrace();
        }
    }

    public void view_student_courses(ArrayList<Course> course_list){ //viewing names of student being registered in a specific course
        System.out.println("Which course would you like to choose? Enter the name of the course:");
        View_Course(course_list);
        String ans9 = obtain_string();
        for (int i = 0; i < course_list.size(); i++){
            if (ans9.equals(course_list.get(i).getCourse_name())){
                System.out.println("This course contains the following people:");
                for (int j = 0; j < course_list.get(i).getArrayList().size(); j++){
                        Student tempstu = (Student) course_list.get(i).getArrayList().get(j); //examples of polymorphism, need to cast to student object
                        System.out.println(tempstu.getFirst_name() + " " + tempstu.getLast_name());
                        }
                    }
                }
            }

    public void view_courses_student(ArrayList<Course> course_list){ //viewing a list of course a given student is being registered on
        System.out.println("What is the student's name? Please enter first then last:");
        System.out.println("First");
        String ans11 = obtain_string();
        System.out.println("Last");
        String ans12 = obtain_string();
        System.out.println("This student has the following courses registered:");
        for (int i = 0; i < course_list.size(); i++){
            for (int j = 0; j < course_list.get(i).getArrayList().size(); j++){
                Student tempstu2 = (Student) course_list.get(i).getArrayList().get(j);
                if (ans11.equals(tempstu2.getFirst_name()) && ans12.equals(tempstu2.getLast_name())) {
                        System.out.println(course_list.get(i).getCourse_name());
                }
            }
        }
    };

    public ArrayList sort(ArrayList<Course> course_list){  //sorting algorithm involving Comparator implementation
        course_list.sort(new course_sort());
        System.out.println("Sorted by Ascending Current Student");
        return course_list;
    };

}
