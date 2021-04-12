package ru.korochkin.spring.mvc.data;

import ru.korochkin.spring.mvc.validation.CheckEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Employee {

    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;

    @NotBlank(message = "surname is required field")
    private String surname;

    @Min(value = 500, message = "must be greater than 499")
    @Max(value = 4000, message = "must be less than 4001")
    private int salary;

    private String department;

    private Map<String, String> departments;

    private String carBrand;

    private Map<String, String> carBrands;

    private String[] languages;

    private Map<String, String> languageList;

    @Pattern(regexp = "(\\+7)\\s(\\d{3}-\\d{3}-\\d{2}-\\d{2})", message = "please use pattern +7 XXX-XXX-XX-XX")
    private String phoneNumber;

    @CheckEmail
    private String email;

    public Employee() {
        departments = new HashMap<>();
        departments.put("Information Technology", "IT");
        departments.put("Human Resources", "HR");
        departments.put("Sales", "Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Audi", "Audi");
        carBrands.put("Mercedes-Benz", "MB");

        languageList = new HashMap<>();
        languageList.put("English", "EN");
        languageList.put("Deutch", "DE");
        languageList.put("French", "FR");


    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
