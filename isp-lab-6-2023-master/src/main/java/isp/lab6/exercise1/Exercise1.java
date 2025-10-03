package isp.lab6.exercise1;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {

    ArrayList<Student> list=new ArrayList<>();
    Student student1=new Student("Matematica",5,"Marsius");
    student1.addStudent(list,student1);
    student1.removeStudent(list,student1);

    Student student2=new Student("Matematica",5,"Ion");
    student2.updateInformation(10,"ISP");
    student2.addGrade("Matematica",8);
    student2.addStudent(list,student2);

    System.out.print("The average grade of student2 is: ");
    System.out.println(student2.averageGrade(student2));

        System.out.println("The list of students:");
    for (Student student : list) {
        System.out.println(student.getName());
    }

    }
}
