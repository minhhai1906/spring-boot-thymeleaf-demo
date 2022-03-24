package com.minhhai.thymeleafdemo.controller;

import com.minhhai.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList;

    @PostConstruct
    private void loadData(){
        Employee employee1 = new Employee(1, "King", "Luis", "king@luv2code.com");
        Employee employee2 = new Employee(2, "Johnathan", "Travel", "johnathan@luv2code.com");
        Employee employee3 = new Employee(3, "Mary", "Jane", "mary@luv2code.com");

        employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeList);
        return "list-employees";
    }

}
