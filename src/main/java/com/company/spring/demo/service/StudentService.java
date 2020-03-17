package com.company.spring.demo.service;

import com.company.spring.demo.model.Student;
import com.company.spring.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public void saveOrUpdate(Student student)
    {
        System.out.println("Inside Service of save");
        studentRepo.save(student);
    }
    public List<Student> getallstudent()
    {   System.out.println("Inside Service of getall");
        List<Student> studentlist = new ArrayList<Student>();
        studentRepo.findAll().forEach(student1 -> studentlist.add(student1));
        return studentlist;
    }
    public Student getstudentbyid(int id)
    {   System.out.println("Inside Service of getone");
        return studentRepo.findById(id).get();
    }
    public void update(Student student, int id)
    {   System.out.println("Inside Service of update");
        studentRepo.save(student);
    }
    public void delete(int id)
    {   System.out.println("Inside Service of delete");
        studentRepo.deleteById(id);
    }
}

