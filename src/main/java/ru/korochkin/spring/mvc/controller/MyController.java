package ru.korochkin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.korochkin.spring.mvc.data.Employee;

import javax.validation.Valid;


@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView()   {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @GetMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp
    , BindingResult bindingResult)  {

        if (bindingResult.hasErrors())  {
            return "ask-emp-details-view";
        }
        else {
            emp.setPhoneNumber(emp.getPhoneNumber());
            return "show-emp-details-view";
        }
    }
}
