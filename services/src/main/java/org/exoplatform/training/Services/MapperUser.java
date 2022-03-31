package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Users;
import org.exoplatform.training.dto.UserDto;

public class MapperUser {

    public static UserDto userdto(Users user){
        UserDto res = new UserDto();
        if (user != null){
            res.setId(user.getId());
            res.setAge(user.getAge());
            res.setEmail(user.getEmail());
            res.setFirstname(user.getFirstname());
            res.setLastname(user.getLastname());
        }
        return  res ;

    }
}
