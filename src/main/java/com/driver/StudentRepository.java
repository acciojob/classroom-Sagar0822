package com.driver;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String,Student> studentDb = new HashMap<>(); //student name Database
    Map<String, Teacher> teacherDb = new HashMap<>(); //Teacher name Database
    Map<String, List<String>> studentTeacherPairDb = new HashMap<>(); //Teacher name & student list

   //.1 add student
    public void addStudent(Student student){
        studentDb.put(student.getName(), student);
    }

    //.2 add teacher
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(), teacher);
    }

    //Add student teacher pair
    public void addStudentTeacherPair(String teacher, String student){
        List<String> studentList = new ArrayList<>();
        if(studentTeacherPairDb.containsKey(teacher)){
            studentList = studentTeacherPairDb.get(teacher);
            studentList.add(student);
            studentTeacherPairDb.put(teacher, studentList);
        }
        else{
            studentList.add(student);
            studentTeacherPairDb.put(teacher, studentList);
        }
    }

    //get student by name
    public Student getStudentByName(String sName){
        return studentDb.get(sName);
    }

    //get teacher by name
    public Teacher getTeacherByName(String tName){
        return teacherDb.get(tName);
    }

    //get student by teacher name
    public List<String> getStudentsByTeacherName(String tName){
        List<String> students = new ArrayList<>();
        if(studentTeacherPairDb.containsKey(tName)) students = studentTeacherPairDb.get(tName);
        return students;
    }

    //get all student
    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(String stud : studentDb.keySet()){
            students.add(stud);
        }
        return students;
    }

    //Delete teacher and students of this teacher
    public void deleteTeacherByName(String teacher){
        List<String> students = new ArrayList<>();
        if(studentTeacherPairDb.containsKey(teacher)) {
            students = studentTeacherPairDb.get(teacher);
            studentTeacherPairDb.remove(teacher);

            for (String student : students) {
                if (studentDb.containsKey(student))
                    studentDb.remove(student);
            }
        }
    }
    //Delete all students and teachers
    public void deleteAllTeachers(){
        teacherDb = new HashMap<>();
        HashSet<String> studentSet = new HashSet<>();
        for(String tech : studentTeacherPairDb.keySet()){
            for(String stud : studentTeacherPairDb.get(tech)){
                studentSet.add(stud);
                }
             for(String student : studentSet){
                if(studentDb.containsKey(student))
                    studentDb.remove(student);
            }
        }
        studentTeacherPairDb = new HashMap<>();
    }
}
