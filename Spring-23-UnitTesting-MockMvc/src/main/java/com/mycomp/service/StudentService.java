package com.mycomp.service;

import com.mycomp.entity.Student;
import com.mycomp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {

        return studentRepository.findAll();
    }
}
