package com.zenvia.newhorizon.agendabot.controller;

import com.zenvia.newhorizon.agendabot.model.User;
import com.zenvia.newhorizon.agendabot.repository.UserRepository;
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
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @ApiOperation(value = "Create a new user on our API ")
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "successfully user created"),
    @ApiResponse(code = 500, message = "an internal error occurred, it was not possible to complete this request")
  }
  )
  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  @ApiOperation(value = "Get all users on our API ")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "successfully get all contents "),
    @ApiResponse(code = 500, message = "an internal error occurred, it was not possible to complete this request")
  }
  )
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }


}
