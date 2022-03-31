package org.exoplatform.training.Services;


import com.google.javascript.jscomp.jarjar.javax.annotation.security.RolesAllowed;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/user/")
@RolesAllowed("users")
public class UserServiceRest implements ResourceContainer {
    private UserService userService ;
    private static Log log = ExoLogger.getLogger(UserServiceRest.class) ;
    public UserServiceRest(){};
    public  UserServiceRest(UserService userService){

        this.userService = userService ;};

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> GetallUsers()throws Exception{
        return userService.getall() ;
    }

}
