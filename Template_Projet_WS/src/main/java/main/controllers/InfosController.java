package main.controllers;

import java.sql.Time;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.controllers.common.AbstractController;
import main.model.ErrorBuilder;
import main.utils.Converter;

@RestController
public class InfosController extends AbstractController{
	
	public static final String CONF_ALARM_CLOCK_PROPERTY_NAME = "alarmClockTime";
	public static final Time DEFAULT_ALARM_TIME = new Time(7, 30, 0);

    @GetMapping(value = "/getTimeAlarm")
    public String GetTimeAlarm(@RequestParam(value = "token") String token) throws AuthenticationException {
    	String failedAuthMessage = processAuthorization(token);
    	if(failedAuthMessage != null)
    		return failedAuthMessage;
    	
    	try {
    		Time alarmTime = (Time) this.dataStorage.getData(CONF_ALARM_CLOCK_PROPERTY_NAME, Time.class, DEFAULT_ALARM_TIME);
    		
    		return Converter.convertTimeToString(alarmTime);
    	}catch(Exception e) {
    		return ErrorBuilder.buildError(formatStringException(e));
    	}
    }
    
}
