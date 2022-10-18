package com.company;

import java.util.ArrayList;
import java.io.Serializable;

class Course implements Serializable{ //implement Serializable since Courses ArrayList needs to be serializable
    public String course_name;
    public String course_id;
    private String max_num_student_registered;
    private String current_student_registered;
    ArrayList<Student> Student_in_class = new ArrayList<Student>();
    private String instructor;
    private String section_number;
    private String course_location;

    //Constructor
    public Course(String name, String id, String max_student, String current_student, ArrayList<Student> student_list, String instru, String section_num, String location){
        this.course_name = name;
        this.course_id = id;
        this.max_num_student_registered = max_student;
        this.current_student_registered = Integer.toString(Student_in_class.size()); //measuring the size of Student_in_class list is better than having a current_student variable
        this.Student_in_class = student_list;
        this.instructor = instru;
        this.section_number = section_num;
        this.course_location = location;
    }

    //getters
    public String getCourse_id(){return course_id;}
    public String getCourse_name(){return course_name;}
    public String getmax_num_student_registered(){return max_num_student_registered;}
    public String getSection_number(){return section_number;}
    public String getInstructor(){return instructor;}
    public String getLocation(){return course_location;}
    public ArrayList getArrayList(){return Student_in_class;}

    //setters
    public void setInstructor(String a){this.instructor = a;}
    public void setSection_number(String b){this.section_number = b;}
    public void setCourse_location(String c){this.course_location = c;}
    public void setMax_num_student_registered(String d){this.max_num_student_registered = d;}

    //return the size of ArrayList
    public int ArrayList_size(){return Student_in_class.size();}
}
