package org.luffy.query;

import static org.luffy.jooq.tables.Users.USERS;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.jooq.DSLContext;
import org.luffy.jooq.tables.records.UsersRecord;
import org.luffy.models.User;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationScoped
public class UserQuery {

  @Autowired
  DSLContext query;

  // Execute a query to get all user information in the database
  public List<User> queryGetUsers() {
    return query.selectFrom(USERS)
        .fetch(row -> {
          return new User((long) row.getId(), row.getEmail(), row.getPassword(),
              row.getName(), row.getAddress(),
              row.getPhone(), row.getAvatar(), row.getRole());
        });
  }

  // Execute the query to get the user's information by id
  public User queryGetUser(Long id) {
    // get the values in the columns of the user table
    UsersRecord row = query.selectFrom(USERS)
        .where(USERS.ID.eq(id.intValue()))
        .fetchOne();

    // if row is empty -> user does not exist
    if (row == null) {
      return null;
    }

    return new User((long) row.getId(), row.getEmail(), row.getPassword(), row.getName(),
        row.getAddress(),
        row.getPhone(), row.getAvatar(), row.getRole());
  }

  // Execute the query to get the user's information by email and password
  public User queryGetUser(String email, String password) {
    // get the values in the columns of the user table
    UsersRecord row = query.selectFrom(USERS)
        .where(USERS.EMAIL.eq(email))
        .and(USERS.PASSWORD.eq(password))
        .fetchOne();

    // if row is empty -> user does not exist
    if (row == null) {
      return null;
    }

    return new User((long) row.getId(), row.getEmail(), row.getPassword(), row.getName(),
        row.getAddress(),
        row.getPhone(), row.getAvatar(), row.getRole());
  }

  // Execute the query to create a new user
  public boolean queryCreateUser(User user) {

    // check email exists
    UsersRecord checkEmailExists = query.selectFrom(USERS)
        .where(USERS.EMAIL.eq(user.getEmail()))
        .fetchOne();

    if (checkEmailExists != null) {
      return false;
    }

    query.insertInto(USERS, USERS.EMAIL, USERS.PASSWORD, USERS.NAME, USERS.PHONE, USERS.ADDRESS)
        .values(user.getEmail(), user.getPassword(), user.getName(), user.getPhone(),
            user.getAddress()).execute();

    return true;
  }

  // Execute a query to edit a user's information
  public boolean queryUpdateUser(Long id, User userUpdate) {
    int result = query.update(USERS)
        .set(USERS.NAME, userUpdate.getName())
        .set(USERS.PHONE, userUpdate.getPhone())
        .set(USERS.ADDRESS, userUpdate.getAddress())
        .set(USERS.AVATAR, userUpdate.getAvatar())
        .where(USERS.ID.eq(id.intValue()))
        .execute();

    return result != 0;
  }

  // Execute a query to delete a user's information
  public boolean queryDeleteUser(Long id) {
    int result = query.delete(USERS)
        .where(USERS.ID.eq(id.intValue()))
        .execute();

    return result == 1;
  }
}
