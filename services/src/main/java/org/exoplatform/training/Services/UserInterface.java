package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Users;

import java.util.List;

public interface UserInterface {
    List<Users>getall() throws Exception ;

    Users SavOrUpdateUser(Users user) ;

    void deleteUser(Users u);
}
