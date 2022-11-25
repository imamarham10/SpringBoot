package com.example.testprojecy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class StudentController {
    private Map<String, StudentRequest> db = new HashMap(){{
        put("1", new StudentRequest(
                "1", "Raj", "23", "India"
    ));
        put("2", new StudentRequest("2","Harsh","24", "India"));
    }};
    // add a new student
    @PostMapping("/addstudent")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest){
        db.put(studentRequest.id , studentRequest);
        System.out.println("Student Name" +" "+ studentRequest.name);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setResult("PASS");
        studentResponse.setSubject("ENGLISH");
        return studentResponse;
    }
    //get all students
    @GetMapping("/students")
    public Collection<StudentRequest> getAllStudents(){
        return db.values();
    }
    //delete a student
    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable String id){
        StudentRequest student = db.remove(id);
        System.out.println("Delete");
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //get a student
    @GetMapping("/students/{id}")
    public StudentRequest getStudent(@PathVariable String id){
        StudentRequest student = db.get(id);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }

    // update a student
    @PutMapping("/updatestudent/{id}")
    public Collection<StudentRequest> updateStudent(@PathVariable String id,@RequestBody StudentRequest studentRequest){
        StudentRequest student = db.get(id);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        db.put(id,studentRequest);
        return db.values();
    }

    @PostMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer multiplication = num1 * num2;
        return "multiplication is: " + multiplication;
    }

    @PostMapping("/add")
    public String addMethod(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer addition = num1 + num2;
        return "the addition is :" + addition;
    }

    @DeleteMapping("/")
    public String methodDelete() {
        return "This is delete method";
    }

    @PutMapping("/")
    public String methodPut() {
        return "This is put method";
    }

    @PostMapping("/post")
    public String methodPost() {
        return "This is post method";
    }

    @GetMapping("/")
    public String hello() {
        return "hello Xgile";
    }
}









