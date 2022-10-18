package com.company;
import java.util.Comparator;

public class course_sort implements Comparator<Course>{ //for sorting, I used the course_sort class which implements the comparator, allowing me to compare properties within an object ArrayList

    public int compare(Course c1, Course c2){
        return (Integer.toString(c1.getArrayList().size())).compareTo(Integer.toString(c2.getArrayList().size()));
    }
}
