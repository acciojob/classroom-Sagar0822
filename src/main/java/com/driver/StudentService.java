package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;
    public void addStudent(Student student){
        repository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String teacher, String student){
        repository.addStudentTeacherPair(teacher, student);
    }
    public Student getStudentByName(String sName){
        return repository.getStudentByName(sName);
    }
    public Teacher getTeacherByName(String tName){
        return repository.getTeacherByName(tName);
    }
    public List<String> getStudentsByTeacherName(String tName){
        return repository.getStudentsByTeacherName(tName);
    }
    public List<String> getAllStudents(){
        return repository.getAllStudents();
    }
    public void deleteTeacherByName(String teacher){
        repository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        repository.deleteAllTeachers();
    }
}
