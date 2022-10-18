package com.company;

import java.util.ArrayList;

public interface Student_Methods{ //implementing all the student methods stated in req 04
    public void View_my_course(ArrayList<Course> current_course);
    public void View_Course_Not_Full(ArrayList<Course> current_course);
    public void Register_Course(Student person, ArrayList<Course> current_course);
    public void Withdraw(Student person, ArrayList<Course> current_course);
    public void Current_Registered(Student person, ArrayList<Course> current_course);
}