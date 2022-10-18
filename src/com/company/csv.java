package com.company;
import java.util.Scanner;

abstract class csv { //using an abstract class so CRS can inherit from it
    public String obtain_string(){ //User will input a string
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        return i;
    }
    public int obtain_int(){ //User will input an integer
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }
    public void display_reports(int b){ //method overriding the display_reports for admin, this will work for student
        System.out.println("1. View all courses");
        System.out.println("2. View all course that are not full");
        System.out.println("3. Register on a course");
        System.out.println("4. Withdraw from a course");
        System.out.println("5. View all courses that the current student is being registered in");
        System.out.println("6. Exit");
    }
}
