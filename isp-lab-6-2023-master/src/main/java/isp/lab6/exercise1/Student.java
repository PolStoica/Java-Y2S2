package isp.lab6.exercise1;
import java.util.*;

public class Student {
    HashMap<String, Integer> hashMap=new HashMap<>();
    private String name;

    public Student(String subject, int grade, String name) {
        this.name = name;
        hashMap.put(subject,grade);
    }

    public String getName() {
        return this.name;
    }
    //  constructor

    public void addGrade(String subject, int grade) {
        hashMap.put(subject,grade);
    }
    //1
    public void addStudent(ArrayList<Student> list,Student student) {
        list.add(student);
    }

    // 3. Remove student
    public ArrayList<Student>  removeStudent(ArrayList<Student> list, Student student) {
        list.remove(student);
        return list;
    }

    //4. update information
    public void updateInformation(int grade, String subject) {
        this.hashMap.put(subject, grade);
    }
    //5. calculate average
    public int averageGrade(Student student) {
        int average=0;
        if(hashMap.isEmpty()){
            throw new IllegalArgumentException("the list is empty");
        }
        for (int grade:hashMap.values()) {
            average+=grade;
        }
        return average/hashMap.size();
    }
}
