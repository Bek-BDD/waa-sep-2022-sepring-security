package com.example.springsecurity.Aspect;

import com.example.springsecurity.Exceptions.AopIsAwesomeHeaderException;
import com.example.springsecurity.Model.ActivityLog;
import com.example.springsecurity.Service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;


@Aspect
@Component
public class Logger {
    @Autowired
    HttpServletRequest httpRequest;
   private ActivityLogService activityLogService;
   public Logger(ActivityLogService activityLogService){
       this.activityLogService=activityLogService;
   }

    @Pointcut("@annotation(com.example.springsecurity.Aspect.ExecutionTime)")
    public void executionTime(){}

    @Pointcut("within(com.aop.springaop.Service.*.*)")
    public void serviceClass(){}

    @Around("executionTime()")
    public Object prformanceManagment(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long starttime = System.currentTimeMillis();
        ActivityLog activityLog = new ActivityLog();
        Object result =proceedingJoinPoint.proceed();
        long endtime =System.currentTimeMillis();
        long timetaken=endtime-starttime;
        String operation=  proceedingJoinPoint.getSignature().getName();
        LocalDateTime time =LocalDateTime.now();
        activityLog.setDate(time);
        activityLog.setDuration(timetaken);
        activityLog.setOperation(operation);
        activityLogService.addActivity(activityLog);
        return result;
    }

    @Around("serviceClass()")
    public Object checkHeader(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
       if(httpRequest.getMethod().equals("POST")){
        if( httpRequest.getHeader("AOP-IS-AWESOME") != null){
             result =proceedingJoinPoint.proceed();
            return null;
        }
        else{
            throw new AopIsAwesomeHeaderException();
        }
       }
       else {
       result= proceedingJoinPoint.proceed();

       }
        return null;
    }

}
