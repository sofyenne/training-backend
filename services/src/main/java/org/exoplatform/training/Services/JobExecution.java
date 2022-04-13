package org.exoplatform.training.Services;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobExecution implements Job{

    private static final Log log = ExoLogger.getLogger(JobExecution.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
           log.info(UserService.eventcounter.get("create"));
           log.info(UserService.eventcounter.get("get"));
           log.info("done!!!!!!!!!!");
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }
}
