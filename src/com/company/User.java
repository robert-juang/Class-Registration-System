package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

class User implements Serializable{ //implement Serializable since Courses ArrayList needs to be serializable
    protected String username;
    protected String password;
    protected String first_name;
    protected String last_name;
    protected User(String user, String pass, String first, String last){
        this.username = user;
        this.password = pass;
        this.first_name = first;
        this.last_name = last;
    }
    //getters
    public String getUser(){
        return username;
    }
    public String getPass(){
        return password;
    }
    public String getFirst_name(){ return first_name;}
    public String getLast_name(){return last_name;}

    //overridden methods here
    public void View_Course(ArrayList<Course> current_course){
        for (int k = 0; k < current_course.size(); k++){
            System.out.println(current_course.get(k).getCourse_name());
        }
    }

    public String obtain_string(){
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        return i;
    }
    public int obtain_int(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }
}