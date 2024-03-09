/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SWE3Project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author basel
 */
@RestController
@RequestMapping("/api/students")
public class studentController {
    
    @Autowired
    private studentInterface studentRepo;
    
    @GetMapping()
    public List<students> getAllStudent(){
        return studentRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public students getStudent(@PathVariable int id){
        return studentRepo.findById(id).get();
    }
    
    @PostMapping()
    public List<students> addStudent(@RequestBody students student){
        studentRepo.save(student);
        return studentRepo.findAll();
    }
    
    @PutMapping("/{id}")
    public List<students> updateStudent(@PathVariable int id, @RequestBody students student){
        students st = studentRepo.findById(id).get();
        st.setName(student.getName());
        st.setEmail(student.getEmail());
        st.setPassword(student.getPassword());
        st.setGender(student.getGender());
        studentRepo.save(st);
        return studentRepo.findAll();
    }
    
    @DeleteMapping("/{id}")
    public List<students> deleteStudent(@PathVariable int id){
        students st = studentRepo.findById(id).get();
        studentRepo.delete(st);
        return studentRepo.findAll();
    }
}
