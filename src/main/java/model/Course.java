package model;

import java.util.ArrayList;

public class Course {
    private String name;
    private String code;
    private String description;
    private int credits;
    private String semester;
    private ArrayList<Student> listStudents;

    public Course(String name, String code, String description, int credits, String semester){
        this.name = name;
        this.code = code;
        this.description = description;
        this.credits = credits;
        this.semester = semester;
        this.listStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }
    public String addStudent(Student student){
        String result = "";
        Student foundStudent = searchStudent(student.getId());
        if(foundStudent == null){
            listStudents.add(student);
            result = "Student added successfully";
        } else {
            result = "Student already exists";
        }
        return result;
    }
    public Student searchStudent(String id){
        Student foundStudent = null;
        for(Student student : listStudents){
            if(student.getId().equals(id)){
                foundStudent = student;
            }
        }
        return foundStudent;
    }
    public String removeStudent(Student student) {
        String result = "";
        Student foundStudent = searchStudent(student.getId());
        if(foundStudent != null) {
            listStudents.remove(foundStudent);
            result = "Student has been removed successfully";
        } else {
            result = "Student not found";
        }
        return result;
    }
    public String updateStudent(String id, Student student){
        String result = "";
        Student foundStudent = searchStudent(id);
        if(foundStudent != null){
            listStudents.remove(foundStudent);
            listStudents.add(student);
            result = "Student has been updated successfully";
        } else {
            result = "Student not found";
        }
        return result;
    }
}
