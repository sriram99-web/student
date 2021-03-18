package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class StudentController {
 
     @Autowired
     private StudentService service;
 
     @GetMapping("/")
     public String viewHomePage(Model model) {
         List<Student> liststudent = service.listAll();
         model.addAttribute("liststudent", liststudent);
         System.out.println("Get /"); 
         return "index";
     }
 
     @GetMapping("/new")
     public String add(Model model) {
         model.addAttribute("student", new Student());
         return "new";
     }
 
     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String saveStudent(@ModelAttribute("student") Student std) {
         service.save(std);
         return "redirect:/";
     }
 
     @RequestMapping("/edit/{id}")
     public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
         ModelAndView mv = new ModelAndView("new");
         Student std = service.get(id);
         mv.addObject("student", std);
         return mv;
         
     }
     @RequestMapping("/delete/{id}")
     public String deletestudent(@PathVariable(name = "id") int id) {
         service.delete(id);
         return "redirect:/";
     }
     
//     @GetMapping("/students/{pageNo}/{pageSize}")
//     public String getPaginatedStudents(Model model,@PathVariable int pageNo,@PathVariable int pageSize){
//    	 //System.out.print("aasffffffffffffsd");
//    	 List<Student> liststudent = service.findPaginated(pageNo,pageSize);
//         model.addAttribute("liststudent", liststudent);
//         System.out.println("Get /"); 
//         return "index";
//    	 
//     }
     
//     @GetMapping("/students/{pageNo}/{pageSize}/{sortBy}")
//     public String getPaginSorted(Model model,@PathVariable int pageNo,@PathVariable int pageSize,@PathVariable String sortBy){
//    	 //System.out.print("aasffffffffffffsd");
//    	 List<Student> liststudent = service.findPageSorted(pageNo,pageSize,sortBy);
//         model.addAttribute("liststudent", liststudent);
//         System.out.println("Get /"); 
//         return "index";
//    	 
//     }
}
