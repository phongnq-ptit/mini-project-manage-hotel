package org.luffy.controllers;

import javax.ws.rs.core.Response;
import org.luffy.dto.UserDTO;
import org.luffy.services.UsersService;
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
@RequestMapping(path = "/api/users")
public class UsersController {

  private final UsersService usersService;

  @Autowired
  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping
  public Response getUsers() {
    return usersService.getUsers();
  }

  @GetMapping("/{id}")
  public Response getUsers(@PathVariable("id") Long id) {
    return usersService.getUser(id);
  }

  @PostMapping(path = "/login")
  public Response handleLogin(@RequestBody UserDTO userDto) {
    return usersService.handleLogin(userDto.toUser());
  }

  @PostMapping(path = "/register")
  public Response handleRegister(@RequestBody UserDTO userDTO) {
    return usersService.handleRegister(userDTO.toUser());
  }

  @PatchMapping("/{id}")
  public Response updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
    return usersService.updateUser(id, userDTO.toUser());
  }

  @DeleteMapping("{id}")
  public Response delete(@PathVariable("id") Long id) {
    return usersService.deleteUser(id);
  }
}
