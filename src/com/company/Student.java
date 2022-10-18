package com.company;
import java.util.ArrayList;

class Student extends User implements Student_Methods{
    Student(String username, String password, String first_name, String last_name){
        super(username, password, first_name, last_name); //constructor extends the user class so use super keyword
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void View_my_course(ArrayList<Course> current_course){ //view every single course
        System.out.println("----------");
        View_Course(current_course);
        System.out.println("----------");
    }
    public void View_Course_Not_Full(ArrayList<Course> course_list){ //view courses that are not full
        System.out.println("----------");
        for (int i = 0; i < course_list.size(); i++){
            boolean isFull = Integer.toString((course_list.get(i).getArrayList().size())).equals((course_list.get(i).getmax_num_student_registered()));
            if (!isFull){
                System.out.println(course_list.get(i).getCourse_name());
            }
        }
        System.out.println("----------");
    }
    public void Register_Course(Student student, ArrayList<Course> course_list){ //student will register for class
        System.out.println("Enter the course name:");
        String ans9 = obtain_string();
        System.out.println("Enter the section number:");
        String ans10 = obtain_string();
        for (int i = 0; i < course_list.size(); i++) {
            if ((ans9.equals(course_list.get(i).getCourse_name())) && (ans10.equals(course_list.get(i).getSection_number()))){
                course_list.get(i).getArrayList().add(student);
            }
        }
    }
    public void Withdraw(Student student, ArrayList<Course> course_list){ //students withdrawing from the course
        System.out.println("Enter the course name:");
        String ans9 = obtain_string();
        System.out.println("Enter the section number:");
        String ans10 = obtain_string();
        for (int i = 0; i < course_list.size(); i++) {
            if ((ans9.equals(course_list.get(i).getCourse_name())) && (ans10.equals(course_list.get(i).getSection_number()))){
                for (int j = 0; j < course_list.get(i).getArrayList().size(); j++) {
                    course_list.get(i).getArrayList().remove(student);
                }
            }
        }
    }

    public void Current_Registered(Student current_student, ArrayList<Course> course_list){ //shows what the current registered students are here
        System.out.println("You are currently registered in:");
        for (int i = 0; i < course_list.size(); i++) {
                for (int j = 0; j < course_list.get(i).ArrayList_size(); j++){
                    Student tempstu4 = (Student) course_list.get(i).getArrayList().get(j);
                    if (current_student.equals(tempstu4)){
                        System.out.println(course_list.get(i).getCourse_name());
                }
            }
        }
    }
}