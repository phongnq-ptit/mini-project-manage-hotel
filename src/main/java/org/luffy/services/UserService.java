package org.luffy.services;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.User;
import org.luffy.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserQuery userQuery;

  /**
   * Function to get list of users
   */
  public Response getUsers() {
    try {
      List<User> users = userQuery.queryGetUsers();

      return Response.ok(users).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Function to get User's information by id
   * Output: A response type json
   */
  public Response getUser(Long id) {
    try {
      User user = userQuery.queryGetUser(id);

      if (user == null) {
        throw new HandleNullValue("This user does not exist!!");
      }

      return Response.ok(user).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Handle check login from client input
   */
  public Response handleLogin(User user) {
    try {
      User userLogin = userQuery.queryGetUser(user.getEmail(), user.getPassword());

      // if userLogin is empty -> user does not exist
      if (userLogin == null) {
        throw new HandleNullValue("Account or password is incorrect!!");
      }

      return Response.ok(userLogin).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Process customer registration forms and create accounts
   */
  public Response handleRegister(User user) {
    try {
      if (!userQuery.queryCreateUser(user)) {
        throw new HandleNullValue("Email already exists");
      }

      return Response.ok(new Message("Register Successful!")).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Update user's information by id
   */
  public Response updateUser(Long id, User userUpdate) {
    try {
      if (!userQuery.queryUpdateUser(id, userUpdate)) {
        throw new HandleNullValue("This user does not exist!!");
      }

      return Response.ok(new Message("Update Successful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  /**
   * Delete user by id
   */
  public Response deleteUser(Long id) {
    try {
      if (!userQuery.queryDeleteUser(id)) {
        throw new HandleNullValue("This user does not exist!!");
      }

      return Response.ok(new Message("Delete Successful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }
}