package com.minhhai.thymeleafdemo.controller;

import com.minhhai.thymeleafdemo.entity.Employee;
import com.minhhai.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> all = employeeService.findAll();
        model.addAttribute("employees", all);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        var employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        // get the employee from the service
        Optional<Employee> employee = employeeService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save the employee
        employeeService.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
