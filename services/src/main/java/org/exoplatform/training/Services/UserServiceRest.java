package org.exoplatform.training.Services;


import com.google.javascript.jscomp.jarjar.javax.annotation.security.RolesAllowed;
import io.swagger.annotations.ApiParam;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/api/user")
@RolesAllowed("users")
public class UserServiceRest implements ResourceContainer {
    private UserService userService ;
    private static final Log log = ExoLogger.getLogger(UserServiceRest.class) ;
    public UserServiceRest(){}

    public  UserServiceRest(UserService userService){

        this.userService = userService ;}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> GetallUsers()throws Exception{
        return userService.getall() ;
    }
    
    @GET
    @Path("/test")
    public String testrest() {
    	return "done!!!!";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
   	@Produces(MediaType.APPLICATION_JSON)
    public Response adduser(Users user) {
        Users users =null ;
    	try {
    		users = userService.SavOrUpdateUser(user);
    	}
    	catch(Exception e ) {
    		log.error(e.getMessage());
    	}
    	return Response.ok(users).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteuser( @PathParam("id") long id) {
    	try {
            Users users = userService.getById(id);
            userService.deleteUser(users);
    	}
    	catch(Exception  e) {
    		log.error(e.getMessage());
    	}
    	return Response.ok().build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") long id) {
        Users users=null ;
         try {
             users = userService.getById(id);
         }
         catch (Exception e){
             log.error(e.getMessage());
         }
         return Response.ok(users).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name")
    public Response getByName(@QueryParam("name") String name){
        Users users = null ;
        try{
            users = userService.getByName(name);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Response.ok(users).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public List<Users>search(@QueryParam("value")String value) throws  Exception{
        return userService.Search(value);
    }
}
