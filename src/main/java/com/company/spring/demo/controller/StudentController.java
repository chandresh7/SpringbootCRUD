package com.company.spring.demo.controller;

import com.company.spring.demo.model.Student;

import com.company.spring.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {
     @Autowired
     StudentService studentService ;

    @RequestMapping(value="home")
    public ModelAndView home(){
        System.out.println("hi");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
    @RequestMapping("register")
    public String register(){
        System.out.println("hi");
        return "register";
    }
    //refer from javatpoint and  test through postman
    @PostMapping("/create")
    public int savestudent(@RequestBody Student student)
    {
        System.out.println("inside save student");
         studentService.saveOrUpdate(student);
         return student.getId();

    }
    @GetMapping("/student")
    private List<Student> getAllstudents()
    { System.out.println("inside getAllstudents controller");
        return studentService.getallstudent();
    }
    @GetMapping("/student/{studentid}")
    private Student getstudent(@PathVariable("studentid") int studentid)
    {  System.out.println("inside getonestudent controller");
        System.out.println("studentid:"+studentid);
        return studentService.getstudentbyid(studentid);
    }
    @PutMapping("/update")
    private Student update(@RequestBody Student student)
    {   System.out.println("inside updateonestudent controller");
        studentService.saveOrUpdate(student);
        return student;
    }
    @DeleteMapping("/delete/{id}")
    private void deleteBook(@PathVariable("id") int id)
    {    System.out.println("inside delete onestudent controller");
         studentService.delete(id);
    }



}
