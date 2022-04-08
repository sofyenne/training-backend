package org.exoplatform.training.Listener;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.listener.Event;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;


import org.exoplatform.training.Entity.Users;
import org.exoplatform.training.Services.UserService;

import java.util.HashMap;
import java.util.Map;


public class UsersListener extends Listener<UserService, Users>{
    private static final Log log =  ExoLogger.getLogger(UsersListener.class);

    @Override
    public void onEvent(Event<UserService, Users> event ) throws Exception {
        log.info("listner : "+  event.getData().getFirstname());
    }
}
