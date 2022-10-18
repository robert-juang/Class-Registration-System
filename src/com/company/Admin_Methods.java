package com.company;

import java.util.ArrayList;

public interface Admin_Methods { //implementing all the admin methods stated in req 03
    public Course Create_Course();

    public ArrayList Delete_Course(ArrayList<Course> current_course);

    public ArrayList Edit_Course(ArrayList<Course> course1);

    public void Display_information(ArrayList<Course> course2);

    public ArrayList Register_Student(ArrayList<Course> course3, ArrayList<Student> student_list);

    public void View_Course(ArrayList<Course> course4);

    public void view_course_full(ArrayList<Course> course5);

    public void write_to_file(ArrayList<Course> course9);

    public void view_student_courses(ArrayList<Course> course6);

    public void view_courses_student(ArrayList<Course> course7);

    public ArrayList sort(ArrayList<Course> course8);
}