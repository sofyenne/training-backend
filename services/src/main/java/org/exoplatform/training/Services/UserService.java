package org.exoplatform.training.Services;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Users;
import org.exoplatform.training.dao.UserDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService implements   UserInterface{
    private static final Log log =  ExoLogger.getLogger(UserServiceRest.class);
    private final UserDAO userDAO ;
    private final ListenerService listenerService;
    public UserService(UserDAO userDAO , ListenerService listenerService){
        this.userDAO = userDAO ;
        this.listenerService =listenerService;
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
               listenerService.broadcast("user-added-success",this,res);
           }else {
               res =userDAO.update(user);
               listenerService.broadcast("user-updated-success",this,res);
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
    @Override
    public Users getById(long id) {
    	Users users = userDAO.find(id);
        return users ;
    }

    @Override
    public Users getByName(String name){
        return userDAO.findByName(name);
    }
}

