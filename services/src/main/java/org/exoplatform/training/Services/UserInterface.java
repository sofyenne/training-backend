package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Users;

import java.util.HashMap;
import java.util.List;

public interface UserInterface {
    List<Users>getall() throws Exception ;
    List<Users> Search(String value) throws Exception ;
    Users SavOrUpdateUser(Users user) ;

    void deleteUser(Users u);
    
	Users getById(long id);

    Users getByName(String name);
}
