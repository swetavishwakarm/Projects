package com.example.springbootstudentmanagementsystem.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springbootstudentmanagementsystem.controller.ControllerUtils;
import com.example.springbootstudentmanagementsystem.model.Department;
import com.example.springbootstudentmanagementsystem.model.DepartmentDTO;
import com.example.springbootstudentmanagementsystem.model.Student;
import com.example.springbootstudentmanagementsystem.model.User;
import com.example.springbootstudentmanagementsystem.service.DepartmentService;
import com.example.springbootstudentmanagementsystem.service.StudentService;
import com.example.springbootstudentmanagementsystem.service.UserService;

import jakarta.validation.Valid;





@Controller
public class AppController {
	@Autowired
	private StudentService service;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	
		User user = new User();
		model.addAttribute("user", user);
		
		return "home";
	}
	@RequestMapping("/dashboard")
	public String viewDashboardPage(Model model) {
		List<Student> listStudents = service.listAll();
		model.addAttribute("listOfStudents", listStudents);
		List<Department> listOfDepartments =departmentService.listAll();
		model.addAttribute("listOfDepartments", listOfDepartments);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "new-student";
	}
	
	@RequestMapping("/new-user")
	public String showNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new-user";
	}
	@RequestMapping("/new-department")
	public String showNewDepartment(Model model) {
		DepartmentDTO department = new DepartmentDTO();
		List<Student> studNames = service.listAll();
		System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
		System.out.println(studNames);
		model.addAttribute("listOfStuds", studNames);
		model.addAttribute("departmentDTO", department);
		return "new-department";
		
	
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute(" student")  Student student, Model model) {
		service.save( student);
	   	return viewDashboardPage(model);
	}
	@RequestMapping("/save-department")
	public String saveDepartment(@ModelAttribute("department") DepartmentDTO department, BindingResult bindingResult,
            Model model
			) {
		
		System.out.println(" Save Department ");
		
		if(bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            //return "index"
        } else{
        	System.out.println(department);
        	Student student = service.get(department.getStudentid());
        	Department departmentObj = new Department();
        	departmentObj.setName(department.getName());
        	departmentObj.setSelectedStudent(student);
        	departmentObj.setPassingyear(department.getPassingyear());
        	departmentObj.setPercentage(department.getPercentage());
        	departmentService.save(departmentObj);
        }
        	return viewDashboardPage(model);
	}	
	@RequestMapping("/save-department-byid")
	public String saveDepartmentById(@ModelAttribute("department")  DepartmentDTO department, BindingResult bindingResult,
            Model model
			) {
		
		System.out.println(" Save Department ");
		
		if(bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            //return "index"
        } else{
        	
        	System.out.println(department);
        	Student student = service.get(department.getStudentid());
        	Department departmentObj = departmentService.get(department.getId());
        	departmentObj.setName(department.getName());
        	departmentObj.setSelectedStudent(student);
        	departmentObj.setPassingyear(department.getPassingyear());
        	departmentObj.setPercentage(department.getPercentage());
        	departmentService.save(departmentObj);
        }
        	//return "index";
	   	return viewDashboardPage(model);
	}
	@RequestMapping("/save-user")
	public String saveUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if(bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            System.out.println(errorsMap);
            System.out.println(errorsMap.toString());
            redirectAttributes.addFlashAttribute("message",errorsMap.toString());
           // return "error";
            return "new-user";
        } else{
	     	userService.save(user);
	     	redirectAttributes.addFlashAttribute("message","User Created Successfully!");
	     	return "redirect:/";
        }
	}
	
	
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable (name="id") long id) {
		ModelAndView mav = new ModelAndView("edit_student");
		Student student= service.get(id);
		mav.addObject("student", student);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable (name="id") long id, Model model) {
		service.delete(id);
		//return "index";
	   	return viewDashboardPage(model);
	}
	
	@RequestMapping("/edit-department/{id}")
	public ModelAndView showEditDepartmentPage(@PathVariable (name="id") long id) {
		ModelAndView mav = new ModelAndView("edit-department");
		Department department = departmentService.get(id);
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setId(department.getId());
		departmentDTO.setName(department.getName());
		departmentDTO.setPassingyear(department.getPassingyear());
		departmentDTO.setPercentage(department.getPercentage());
		departmentDTO.setStudentid(department.getSelectedStudent().getId());
		List<Student> studNames = service.listAll();
		System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
		System.out.println(studNames);
		mav.addObject("listOfStuds", studNames);
		mav.addObject("department", departmentDTO);
		return mav;
	}
	
	@RequestMapping("/delete-department/{id}")
	public String deleteDepartment (@PathVariable (name="id") long id, RedirectAttributes redirectAttributes, Model model) {
		departmentService.delete(id);
		redirectAttributes.addFlashAttribute("message", "Department deleted Successfully !!");
		//return "index";
	   	return viewDashboardPage(model);
	}
	
	@RequestMapping("/login")
	public String validateUser(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {
		
		User fetchUser = userService.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		System.out.println(fetchUser);
		if(fetchUser != null) {
			redirectAttributes.addFlashAttribute("message", "User successfully Logged In!!!");
			model.addAttribute("fetchUser", fetchUser);
			return viewDashboardPage(model);
		}else {
			redirectAttributes.addFlashAttribute("message", "Invalid User credentials!!!");
			return "redirect:/";
		}
	}
		@RequestMapping("/search")
		public String showSearchPage(Model model) {
			Student student= new Student();
			model.addAttribute("student", student);
			
			return "search";
		}

		@RequestMapping("/search-student")
		public String searchStudentResults(@ModelAttribute("student") Student student, Model model) {
			Student studentResult = service.get(student.getId());
			System.out.println(studentResult);
			model.addAttribute("studentResult", studentResult);
			
			return "search";
		
	
	}
}
