package org.luffy.services;

import static org.luffy.jooq.tables.Users.USERS;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.luffy.handleException.Message;
import org.luffy.jooq.tables.records.UsersRecord;
import org.luffy.models.User;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends DSLContextDB {

  public UsersService() throws SQLException {
    super();
  }

  public Response getUsers() {
    try {

      // Get rows in user table and add to list
      List<User> users = context.selectFrom(USERS)
          .fetch(row -> {
            return new User((long) row.getId(), row.getEmail(), row.getPassword(),
                row.getName(), row.getAddress(),
                row.getPhone(), row.getAvatar(), row.getRole());
          });

      return Response.ok(users).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response getUser(Long id) {
    try {
      // get the values in the columns of the user table
      UsersRecord row = context.selectFrom(USERS)
          .where(USERS.ID.eq(id.intValue()))
          .fetchOne();

      // if row is empty -> user does not exist -> status 404
      if (row == null) {
        return Response
            .status(Status.NOT_FOUND)
            .entity(new Message("This user does not exist!!"))
            .build();
      }

      User user = new User((long) row.getId(), row.getEmail(), row.getPassword(), row.getName(),
          row.getAddress(),
          row.getPhone(), row.getAvatar(), row.getRole());

      return Response.ok(user).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response handleLogin(User user) {
    try {
      /*
       * Input: User's Email and Password entered
       * Output: Returns user information if the information is correct
       * */
      // Query database
      UsersRecord row = context.selectFrom(USERS)
          .where(USERS.EMAIL.eq(user.getEmail()))
          .and(USERS.PASSWORD.eq(user.getPassword()))
          .fetchOne();

      // if row is empty -> user does not exist -> status 404
      if (row == null) {
        return Response
            .status(Status.NOT_FOUND)
            .entity(new Message("Account or password is incorrect!!"))
            .build();
      }

      User newUser = new User((long) row.getId(), row.getEmail(), row.getPassword(), row.getName(),
          row.getAddress(),
          row.getPhone(), row.getAvatar(), row.getRole());

      return Response.ok(newUser).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response handleRegister(User user) {
    try {
      // check email exists
      UsersRecord checkEmailExists = context.selectFrom(USERS)
          .where(USERS.EMAIL.eq(user.getEmail()))
          .fetchOne();

      if (checkEmailExists != null) {
        return Response.status(Status.BAD_REQUEST)
            .entity(new Message("Email already exists!"))
            .build();
      }

      // Query database
      context.insertInto(USERS,
              USERS.EMAIL, USERS.PASSWORD, USERS.NAME, USERS.PHONE, USERS.ADDRESS)
          .values(user.getEmail(), user.getPassword(), user.getName(), user.getPhone(),
              user.getAddress())
          .execute();

      return Response.ok(new Message("Register Successful!")).build();

    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response updateUser(Long id, User userUpdate) {
    try {
      // check id exists
      UsersRecord checkIdExists = context.selectFrom(USERS)
          .where(USERS.ID.eq(id.intValue()))
          .fetchOne();

      if (checkIdExists == null) {
        return Response
            .status(Status.NOT_FOUND)
            .entity(new Message("This user does not exist!!"))
            .build();
      }

      // update info user
      context.update(USERS)
          .set(USERS.NAME, userUpdate.getName())
          .set(USERS.PHONE, userUpdate.getPhone())
          .set(USERS.ADDRESS, userUpdate.getAddress())
          .set(USERS.AVATAR, userUpdate.getAvatar())
          .where(USERS.ID.eq(id.intValue()))
          .execute();

      return Response.ok(new Message("Update Succsessful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response deleteUser(Long id) {
    try {
      // check id exists
      UsersRecord checkIdExists = context.selectFrom(USERS)
          .where(USERS.ID.eq(id.intValue()))
          .fetchOne();

      if (checkIdExists == null) {
        return Response
            .status(Status.NOT_FOUND)
            .entity(new Message("This user does not exist!!"))
            .build();
      }

      // Query database
      context.delete(USERS).where(USERS.ID.eq(id.intValue())).execute();

      return Response.ok(new Message("Delete Succsessful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }
}
