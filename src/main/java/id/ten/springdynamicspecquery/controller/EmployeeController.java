package id.ten.springdynamicspecquery.controller;

import id.ten.springdynamicspecquery.dto.EmployeeDto;
import id.ten.springdynamicspecquery.model.Employee;
import id.ten.springdynamicspecquery.search.SearchQuery;
import id.ten.springdynamicspecquery.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getEmployees(@RequestBody SearchQuery searchQuery) {

        List<EmployeeDto> emps = employeeService.findAll(searchQuery);

        return emps;
    }

}
