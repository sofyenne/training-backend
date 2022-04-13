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
    public static HashMap<String,Integer>eventcounter = new HashMap<>();
    static {
        eventcounter.put("create",0);
        eventcounter.put("update",0);
        eventcounter.put("delete",0);
        eventcounter.put("get",0);
    }
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
    public List<Users> Search(String value) throws Exception {
        return userDAO.Search(value);
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
        Users users = null ;
        try {
             users = userDAO.find(id);
            listenerService.broadcast("user-finded-success", this, users);
        }
        catch(Exception e){ log.error(e.getMessage());}
        return users ;
    }

    @Override
    public Users getByName(String name){
        return userDAO.findByName(name);
    }
}

