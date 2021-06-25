package com.behnam.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

// https://www.hackerrank.com/challenges/java-priority-queue/problem

class Student {

    public Student(String event){
        this.name = event.split(" ")[1];
        this.cgpa = Double.parseDouble(event.split(" ")[2]);
        this.id = Integer.parseInt(event.split(" ")[3]);
    }

    int id;
    String name;
    double cgpa;

    public String getName(){
        return name;
    }
}

class Priorities {
    List<Student> students = new ArrayList<>();

    public List<Student> getStudents(List<String> events){
        List<Student> students = new ArrayList<>();;
        for(String e: events){
            if(e.startsWith("ENTER")){
                students.add(new Student(e));
                students.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student s0, Student s1) {
                        if(s0.cgpa>s1.cgpa)
                            return -1;
                        else if(s0.cgpa<s1.cgpa)
                            return 1;

                        if(!s0.name.equals(s1.name))
                            return s0.name.compareTo(s1.name);

                        if(s0.id>s1.id)
                            return -1;
                        else if(s0.id<s1.id)
                            return 1;

                        return 0;
                    }
                });
            }
            else if("SERVED".equals(e)){
                if(students.size()!=0)
                    students.remove(0);
            }
        }
        return students;
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
