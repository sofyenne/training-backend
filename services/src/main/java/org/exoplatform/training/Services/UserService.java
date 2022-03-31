package org.exoplatform.training.Services;

import liquibase.pro.packaged.S;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Users;
import org.exoplatform.training.dao.UserDAO;

import java.util.List;

public class UserService implements   UserInterface{

    private static Log log =  ExoLogger.getLogger(UserServiceRest.class);
    private UserDAO userDAO ;
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO ;
    }
    @Override
    public List<Users> getall() throws Exception {
        return userDAO.findAll();
    }

    @Override
    public Users SavOrUpdateUser(Users user) {
        Users res = null ;
       try{
           if(user != null && user.getId() == 0){
              res =userDAO.create(user);
           }else {
               res =userDAO.update(user);
           }
       }
       catch (Exception e ){
           System.out.println(e);
       }
       return  res ;
    }

    @Override
    public void deleteUser(Users u) {
        userDAO.delete(u);

    }
}
