package com.example.springdatajpapractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    //display all students
    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute("listStudents",studentService.getAllStudents());
        return "home";
    }
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "new_Student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value ="id") long id, Model model){
        //get student from the service
        Student student = studentService.getStudentById(id);
        //set student as a model attribute to pre-populate the form
        model.addAttribute("student",student);
        return "update_student";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value="id") long id){
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
