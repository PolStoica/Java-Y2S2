package isp.lab6.exercise1;

import junit.framework.TestCase;

import java.util.ArrayList;

public class StudentTest extends TestCase {

    public void testAddGrade() {
        Student student=new Student("Matematica",5,"Ion");
        student.addGrade("Matematica",8);
        int a=student.hashMap.get("Matematica");
        assertEquals(8,a);
    }

    public void testAddStudent() {
        Student student=new Student("Matematica",5,"Ion");
        ArrayList<Student> list=new ArrayList<>();
        student.addStudent(list,student);

        assertEquals(1, list.size());
        assertEquals("Ion", list.get(0).getName());
    }

    public void testRemoveStudent() {
        Student student=new Student("Matematica",5,"Ion");
        ArrayList<Student> list=new ArrayList<>();
        student.addStudent(list,student);

        student.removeStudent(list,student);
        assertEquals(0, list.size());
        //assertNull(list.get(0).getName());
    }

    public void testUpdateInformation() {
        Student student=new Student("Matematica",5,"Ion");
        ArrayList<Student> list=new ArrayList<>();
        student.addStudent(list,student);
        student.updateInformation(4,"Matematica");
        int a=student.hashMap.get("Matematica");
        assertEquals(4,a);
    }
}