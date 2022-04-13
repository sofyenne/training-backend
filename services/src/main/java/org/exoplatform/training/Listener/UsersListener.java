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
        try {
            final String name = event.getEventName();
            log.info("Listner : " + name);
            switch (name) {
                case "user-added-success":
                    UserService.eventcounter.put("create", UserService.eventcounter.get("create") + 1);
                    log.info("Event : ", name);
                    break;
                case "user-updated-success":
                    UserService.eventcounter.put("update", UserService.eventcounter.get("update") + 1);
                    log.info("Event : ", name);
                    break;
                case "user-finded-success":
                    UserService.eventcounter.put("get", UserService.eventcounter.get("get") + 1);
                    log.info("Event : ", name);
                    break;
            }
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
