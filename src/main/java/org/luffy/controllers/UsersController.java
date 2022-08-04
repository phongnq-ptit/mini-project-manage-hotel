package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.UserDTO;
import org.luffy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
  private final UserService userService;

  @Autowired
  public UsersController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public Response getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  public Response getUsers(@PathVariable("id") Long id) {
    return userService.getUser(id);
  }

  @PostMapping(path = "/login")
  public Response handleLogin(@RequestBody UserDTO userDto) {
    return userService.handleLogin(userDto.toUser());
  }

  @PostMapping("/register")
  public Response handleRegister(@RequestBody UserDTO userDTO) {
    return userService.handleRegister(userDTO.toUser());
  }

  @PatchMapping("/{id}")
  public Response updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
    return userService.updateUser(id, userDTO.toUser());
  }

  @DeleteMapping("/{id}")
  public Response delete(@PathVariable("id") Long id) {
    return userService.deleteUser(id);
  }
}
