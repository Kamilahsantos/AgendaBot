package com.zenvia.newhorizon.agendabot.controller;

import com.zenvia.newhorizon.agendabot.model.Employee;
import com.zenvia.newhorizon.agendabot.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @ApiOperation(value = "Create a new employee on our API ")
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "successfully employee created"),
    @ApiResponse(code = 500, message = "an internal error occurred, it was not possible to complete this request")
  }
  )
  @PostMapping("/employee")
  public Employee createEmployee(@Valid @RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @ApiOperation(value = "Get all employee on our API ")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "successfully get all employees "),
    @ApiResponse(code = 500, message = "an internal error occurred, it was not possible to complete this request")
  }
  )
  @GetMapping("/employee")
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

}
